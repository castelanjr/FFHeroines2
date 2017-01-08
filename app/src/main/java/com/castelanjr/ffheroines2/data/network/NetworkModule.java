package com.castelanjr.ffheroines2.data.network;

import com.castelanjr.ffheroines2.BuildConfig;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.data.network.response.HeroinesResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {

    private static final String BASE_ENDPOINT_URL = "https://api.myjson.com";

    @Provides @Singleton
    FFHService provideService(Retrofit retrofit) {
        return retrofit.create(FFHService.class);
    }

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient client, HttpUrl baseUrl,
                             Converter.Factory converterFactory,
                             CallAdapter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(factory)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Provides @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides @Singleton
    Converter.Factory provideConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Provides @Singleton
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides @Singleton
    HttpUrl provideBaseUrl() {
        return HttpUrl.parse(BASE_ENDPOINT_URL);
    }

    @Provides @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor(HttpLoggingInterceptor.Logger logger) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(logger);

        interceptor.setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.BASIC);

        return interceptor;
    }

    @Provides @Singleton
    HttpLoggingInterceptor.Logger provideLogger() {
        return message -> Timber.d(message);
    }

    @Provides @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .add(Heroine.typeAdapterFactory())
                .add(HeroinesResponse.typeAdapterFactory())
                .build();
    }

}
