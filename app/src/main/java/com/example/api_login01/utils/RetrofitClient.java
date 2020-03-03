package com.example.api_login01.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.api_login01.utils.AppConstance.APP_BASE_URL;
import static com.example.api_login01.utils.utilities.BACKEND_BASE_URL;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }

}
