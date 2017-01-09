package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.util.ActivityScope;
import com.castelanjr.ffheroines2.util.AppScheduler;

import dagger.Module;
import dagger.Provides;

@Module
public class HeroinesModule {

    private final HeroinesView view;

    HeroinesModule(HeroinesView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    HeroinesView providesHeroinesView() {
        return view;
    }

    @Provides
    @ActivityScope
    HeroinesPresenter presenter(DataManager dataManager, AppScheduler appScheduler) {
        HeroinesPresenter presenter = new HeroinesPresenter(dataManager, appScheduler);
        presenter.takeView(view);
        return presenter;
    }
}
