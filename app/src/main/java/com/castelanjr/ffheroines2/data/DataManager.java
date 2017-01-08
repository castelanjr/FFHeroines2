package com.castelanjr.ffheroines2.data;

import com.castelanjr.ffheroines2.data.model.Heroine;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class DataManager {

    @Inject
    public DataManager() {
    }

    public Single<List<Heroine>> heroines() {
        return null;
    }
}
