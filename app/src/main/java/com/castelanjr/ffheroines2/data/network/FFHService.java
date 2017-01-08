package com.castelanjr.ffheroines2.data.network;

import com.castelanjr.ffheroines2.data.network.response.HeroinesResponse;

import retrofit2.http.GET;

public interface FFHService {

    @GET("/bins/atxfj")
    HeroinesResponse heroines();

}
