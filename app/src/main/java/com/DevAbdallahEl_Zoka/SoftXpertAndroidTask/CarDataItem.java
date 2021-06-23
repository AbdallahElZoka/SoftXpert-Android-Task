package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask;

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