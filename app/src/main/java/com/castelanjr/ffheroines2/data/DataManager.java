package com.castelanjr.ffheroines2.data;

import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.data.network.NetworkProvider;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class DataManager {

    private final NetworkProvider networkProvider;

    @Inject
    public DataManager(NetworkProvider networkProvider) {
        this.networkProvider = networkProvider;
    }

    public Single<List<Heroine>> heroines() {
        return networkProvider.heroines();
    }
}
