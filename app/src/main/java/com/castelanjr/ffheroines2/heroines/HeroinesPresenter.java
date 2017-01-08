package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.base.BaseAdapter;
import com.castelanjr.ffheroines2.base.BasePresenter;
import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.util.AppScheduler;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class HeroinesPresenter extends BasePresenter<HeroinesView>
        implements BaseAdapter.OnItemSelectedListener<Heroine> {

    @Inject
    HeroinesPresenter(DataManager dataManager, AppScheduler appScheduler) {
        super(dataManager, appScheduler);
    }

    void loadHeroines() {
        dataManager.heroines()
                .subscribeOn(appScheduler.io())
                .observeOn(appScheduler.mainThread())
                .subscribeWith(new SingleObserver<List<Heroine>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getView().showProgressIndicator(true);
                    }

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
                });
    }

    @Override
    public void onItemSelected(Heroine item) {

    }
}
