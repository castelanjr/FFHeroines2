package com.castelanjr.ffheroines2;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

public class FFHApplication extends Application {
    private FFHComponent component;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        refWatcher = LeakCanary.install(this);

        component = FFHComponent.Initializer.init(this);
        component.inject(this);
    }

    public FFHComponent component() {
        return component;
    }

    public static FFHApplication get(Context context) {
        return (FFHApplication) context.getApplicationContext();
    }
}
