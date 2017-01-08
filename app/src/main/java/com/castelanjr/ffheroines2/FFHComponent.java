package com.castelanjr.ffheroines2;

import com.castelanjr.ffheroines2.data.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class, DataModule.class})
public interface FFHComponent extends FFHGraph {

    final class Initializer {
        private Initializer() {}

        static FFHComponent init(FFHApplication context) {
            return DaggerFFHComponent.builder()
                    .appModule(new AppModule(context))
                    .dataModule(new DataModule())
                    .build();
        }
    }
}
