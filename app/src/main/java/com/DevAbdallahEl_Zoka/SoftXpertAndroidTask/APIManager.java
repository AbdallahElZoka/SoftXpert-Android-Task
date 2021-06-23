package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private Retrofit retrofitClient = null;

    private APIManager() {

    }

    public synchronized Retrofit getInstance() {
        if (retrofitClient == null) {
            return new Retrofit.Builder().baseUrl("http://demo1286023.mockable.io/api/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitClient;
    }

    public WebServices getWebServicesInstance(Retrofit retrofit) {
        return retrofit.create(WebServices.class);
    }

}
