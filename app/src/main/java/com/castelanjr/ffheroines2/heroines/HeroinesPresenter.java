package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.base.BaseAdapter;
import com.castelanjr.ffheroines2.base.BasePresenter;
import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.AppScheduler;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import timber.log.Timber;

class HeroinesPresenter extends BasePresenter<HeroinesView>
        implements BaseAdapter.OnItemSelectedListener<Heroine> {

    HeroinesPresenter(DataManager dataManager, AppScheduler appScheduler) {
        super(dataManager, appScheduler);
    }

    void loadHeroines() {
        addSubscription(dataManager.heroines()
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .doOnSubscribe(disposable -> getView().showProgressIndicator(true))
                .subscribeWith(new DisposableSingleObserver<List<Heroine>>() {

                    @Override
                    public void onSuccess(List<Heroine> value) {
                        getView().showProgressIndicator(false);
                        getView().showHeroines(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showProgressIndicator(false);
                        getView().showError("Error loading data, please try again.");
                        Timber.e(e, "Error loading data");
                    }
                }));
    }

    @Override
    public void onItemSelected(Heroine item) {
        getView().showHeroineDetails(item);
    }
}
