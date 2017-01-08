package com.castelanjr.ffheroines2.data.network.response;

import com.castelanjr.ffheroines2.data.model.Heroine;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;

import java.util.List;

@AutoValue
public abstract class HeroinesResponse {
    public abstract List<Heroine> heroines();

    public static JsonAdapter.Factory typeAdapterFactory() {
        return AutoValue_HeroinesResponse.typeAdapterFactory();
    }
}
