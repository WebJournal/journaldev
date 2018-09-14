package com.journaldev.androidretrofitofflinecaching;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {


    String BASE_URL = "https://api.chucknorris.io/jokes/";

    @GET("{path}")
    Observable<Jokes> getRandomJoke(@Path("path") String path);
}

