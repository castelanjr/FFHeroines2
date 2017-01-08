package com.castelanjr.ffheroines2.base;

import com.castelanjr.ffheroines2.data.DataManager;
import com.castelanjr.ffheroines2.util.AppScheduler;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T> {

    protected final DataManager dataManager;
    protected final AppScheduler appScheduler;

    public BasePresenter(DataManager dataManager, AppScheduler appScheduler) {
        this.dataManager = dataManager;
        this.appScheduler = appScheduler;
    }

    private WeakReference<T> view;
    private final CompositeDisposable subscriptions = new CompositeDisposable();

    public void takeView(T view) {
        this.view = new WeakReference<>(view);
    }

    void dropView() {
        if (view != null) {
            view.clear();
        }
        subscriptions.clear();
    }

    protected T getView() {
        return view.get();
    }

    protected void addSubscription(Disposable disposable) {
        subscriptions.add(disposable);
    }
}
