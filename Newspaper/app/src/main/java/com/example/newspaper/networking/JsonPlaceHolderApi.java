package com.example.newspaper.networking;

import com.example.newspaper.Models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("top-headlines")
    Call<NewsApiResponse> getNewsList(
            @Query("country") String country,
            @Query("category") String category,
            @Query("p") String query,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<NewsApiResponse> getSearchNews (
            @Query("p") String query,
            @Query("apiKey") String apiKey
    );
}
