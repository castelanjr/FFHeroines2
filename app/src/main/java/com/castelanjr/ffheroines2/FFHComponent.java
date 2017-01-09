package com.castelanjr.ffheroines2;

import com.castelanjr.ffheroines2.data.DataModule;
import com.castelanjr.ffheroines2.heroine_details.HeroineDetailsComponent;
import com.castelanjr.ffheroines2.heroine_details.HeroineDetailsModule;
import com.castelanjr.ffheroines2.heroines.HeroinesComponent;
import com.castelanjr.ffheroines2.heroines.HeroinesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class, DataModule.class})
public interface FFHComponent {

    void inject(FFHApplication application);

    HeroinesComponent plus(HeroinesModule module);
    HeroineDetailsComponent plus(HeroineDetailsModule module);

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
