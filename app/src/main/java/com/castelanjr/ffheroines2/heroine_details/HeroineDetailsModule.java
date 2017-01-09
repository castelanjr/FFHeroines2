package com.castelanjr.ffheroines2.heroine_details;

import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.util.ActivityScope;
import com.castelanjr.ffheroines2.util.AppScheduler;

import dagger.Module;
import dagger.Provides;

@Module
public class HeroineDetailsModule {

    private final HeroineDetailsView view;

    HeroineDetailsModule(HeroineDetailsView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    HeroineDetailsView provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    HeroineDetailsPresenter providePresenter(DataManager dataManager, AppScheduler appScheduler) {
        HeroineDetailsPresenter presenter = new HeroineDetailsPresenter(dataManager, appScheduler);
        presenter.takeView(view);
        return presenter;
    }
}
