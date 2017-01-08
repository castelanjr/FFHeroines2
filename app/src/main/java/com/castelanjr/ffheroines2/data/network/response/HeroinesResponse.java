package com.castelanjr.ffheroines2.data.network.response;

import com.castelanjr.ffheroines2.data.model.Heroine;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class HeroinesResponse {
    public abstract List<Heroine> heroines();
}
