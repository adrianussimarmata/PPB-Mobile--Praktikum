package com.example.retrofitproject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static ApiInterface service;

    public static ApiInterface getService() {
        String BASE_URL = "https://reqres.in/";

        if (service == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            service = retrofit.create(ApiInterface.class);
        }

        return service;
    }
}
