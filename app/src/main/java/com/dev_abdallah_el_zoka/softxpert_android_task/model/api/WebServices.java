package com.dev_abdallah_el_zoka.softxpert_android_task.model.api;

import com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo.CarApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WebServices {

    @GET("cars")
    Call<CarApiResponse> getCarsModelsFromAPI(@Query("page") int pageNumber);



}
