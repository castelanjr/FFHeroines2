package com.castelanjr.ffheroines2;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class FFHApplication extends Application {
    private FFHComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        Timber.plant(new Timber.DebugTree());

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
