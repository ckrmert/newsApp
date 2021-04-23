package com.tr.newsappcent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClient {

    private static final String BASE_URL="https://newsapi.org/v2/";
    private static apiClient apiclient;
    private static Retrofit retrofit;

    private apiClient(){

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static synchronized apiClient getInstance(){

        if (apiclient == null) {
            apiclient = new apiClient();

        }
        return apiclient;
        }

        public apiInterface getApi(){

        return retrofit.create(apiInterface.class);
        }
    }


