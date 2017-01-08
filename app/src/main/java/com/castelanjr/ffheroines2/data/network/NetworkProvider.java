package com.castelanjr.ffheroines2.data.network;

import com.castelanjr.ffheroines2.data.DataProvider;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.data.network.response.HeroinesResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class NetworkProvider implements DataProvider {

    private final FFHService service;

    @Inject
    public NetworkProvider(FFHService service) {
        this.service = service;
    }

    @Override
    public Single<List<Heroine>> heroines() {
        return service.heroines().map(HeroinesResponse::heroines);
    }
}
