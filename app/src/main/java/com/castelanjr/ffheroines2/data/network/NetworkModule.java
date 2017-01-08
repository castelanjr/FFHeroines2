package com.castelanjr.ffheroines2.data.network;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.castelanjr.ffheroines2.BuildConfig;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.HttpLoggingInterceptor;
import com.squareup.moshi.Moshi;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {

    private static final String BASE_ENDPOINT_URL = "https://api.myjson.com";

    @Provides
    @Singleton
    FFHService provideService(Retrofit retrofit) {
        return retrofit.create(FFHService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Provides @Singleton
    Executor provideExecutor() {
        return new MainThreadExecutor();
    }

    @Provides @Singleton CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides @Singleton
    HttpUrl provideBaseUrl() {
        return HttpUrl.parse(BASE_ENDPOINT_URL);
    }

    @Provides @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor(HttpLoggingInterceptor.Logger logger) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(logger);

        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.BASIC);

        return interceptor;
    }

    @Provides @Singleton
    HttpLoggingInterceptor.Logger provideLogger() {
        return new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        };
    }

    @Provides
    @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .add(Heroine.typeAdapterFactory())
                .build();
    }

    public static class MainThreadExecutor implements Executor {
        private final Handler handler = new Handler(Looper.getMainLooper());

        @Override public void execute(@NonNull Runnable runnable) {
            handler.post(runnable);
        }
    }

}
