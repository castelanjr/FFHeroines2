package com.castelanjr.ffheroines2.heroine_details;

import com.castelanjr.ffheroines2.base.BasePresenter;
import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.AppScheduler;

class HeroineDetailsPresenter extends BasePresenter<HeroineDetailsView> {
    
    HeroineDetailsPresenter(DataManager dataManager, AppScheduler appScheduler) {
        super(dataManager, appScheduler);
    }

    void loadDetails() {
        Heroine heroine = getView().getHeroine();

        if (heroine == null) {
            throw new IllegalStateException("Heroine is null");
        }

        getView().showName(heroine.fullname());
        getView().showGame("Final Fantasy " + heroine.game());
        getView().showDescription(heroine.description());
        getView().showAbility(heroine.ability());
        getView().showAvatar(heroine.avatar());
        getView().showCover(heroine.avatar());
    }
}
