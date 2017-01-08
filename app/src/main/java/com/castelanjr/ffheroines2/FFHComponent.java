package com.castelanjr.ffheroines2;

import com.castelanjr.ffheroines2.heroines.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface FFHComponent {

    void inject(FFHApplication application);
    void inject(MainActivity activity);

    final class Initializer {
        private Initializer() {}

        static FFHComponent init(FFHApplication context) {
            return DaggerFFHComponent.builder()
                    .appModule(new AppModule(context))
                    .build();
        }
    }
}
