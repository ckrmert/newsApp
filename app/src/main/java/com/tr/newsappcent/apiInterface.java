package com.tr.newsappcent;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiInterface {

    @GET("everything")
    Call<headline> getHeadlines(
            @Query("q") String q,
            @Query("page") String page,
            @Query("apiKey") String apiKey


    );

    @GET("everything")
    Call<headline> getSearched(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );

}
