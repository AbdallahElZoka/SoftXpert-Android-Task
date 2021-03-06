package com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo;

import com.google.gson.annotations.SerializedName;

public class CarDataItem {

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("id")
    private int carId;

    @SerializedName("constractionYear")
    private String constractionYear;

    @SerializedName("brand")
    private String brand;

    @SerializedName("isUsed")
    private boolean isUsed;

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCarId() {
        return carId;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isIsUsed() {
        return isUsed;
    }
}