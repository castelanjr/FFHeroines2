package com.castelanjr.ffheroines2;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final FFHApplication app;

    public AppModule(FFHApplication app) {
        this.app = app;
    }

    @Provides @Singleton
    Application provideApp() {
        return app;
    }
}
