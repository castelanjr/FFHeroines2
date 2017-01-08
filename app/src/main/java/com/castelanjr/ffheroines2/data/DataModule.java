package com.castelanjr.ffheroines2.data;

import android.app.Application;

import com.castelanjr.ffheroines2.data.network.NetworkModule;
import com.castelanjr.ffheroines2.util.AppScheduler;
import com.castelanjr.ffheroines2.util.AppSchedulerImpl;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import timber.log.Timber;

@Module(includes = { NetworkModule.class })
public class DataModule {

    @Provides @Singleton
    AppScheduler provideScheduler() {
        return new AppSchedulerImpl();
    }

    @Provides @Singleton
    Picasso providePicasso(Application app, OkHttpClient client) {
        return new Picasso.Builder(app)
                .downloader(new OkHttp3Downloader(client))
                .listener((picasso, uri, e) -> Timber.e(e, "Failed to load image: %s", uri))
                .build();
    }

}
