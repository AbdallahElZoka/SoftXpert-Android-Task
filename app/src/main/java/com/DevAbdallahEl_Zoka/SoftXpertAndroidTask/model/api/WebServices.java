package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.model.api;

import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.model.pojo.CarApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WebServices {

    @GET("cars")
    Call<CarApiResponse> getCarsModelsFromAPI(@Query("page") int pageNumber);



}
