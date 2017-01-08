package com.castelanjr.ffheroines2.data;

import com.castelanjr.ffheroines2.data.model.Heroine;

import java.util.List;

import io.reactivex.Single;

public interface DataProvider {
    Single<List<Heroine>> heroines();
}
