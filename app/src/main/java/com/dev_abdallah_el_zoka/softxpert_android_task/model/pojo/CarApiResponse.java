package com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CarApiResponse{

	@SerializedName("data")
	private List<CarDataItem> data;

	@SerializedName("status")
	private int status;

	public List<CarDataItem> getData(){
		return data;
	}

	public int getStatus(){
		return status;
	}
}