package com.journaldev.mvpdagger2retroiftrxjava.retrofit;

import com.journaldev.mvpdagger2retroiftrxjava.pojo.CryptoData;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
