package com.dev_abdallah_el_zoka.softxpert_android_task.paging;

import android.util.Log;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;

import com.dev_abdallah_el_zoka.softxpert_android_task.model.api.WebServices;
import com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo.CarApiResponse;
import com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo.CarDataItem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarModelsPagingSource extends PagingSource<Integer, CarDataItem> {
    WebServices webServices;
    int startingPage = 1;
    int pageSize;
    CarApiResponse carApiResponse;
    Integer nextKey;
    Integer prevKey;

    public CarModelsPagingSource(WebServices webServices, int pageSize) {
        this.webServices = webServices;
        this.pageSize = pageSize;
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, CarDataItem> pagingState) {
        return pagingState.getAnchorPosition();
    }

    @Nullable
    @Override
    public LoadResult load(@NotNull LoadParams<Integer> loadParams, @NotNull Continuation<? super LoadResult<Integer, CarDataItem>> continuation) {
        int position;
        if (loadParams.getKey() == null) {
            position = startingPage;
        } else {
            position = loadParams.getKey();
        }
        try {


            webServices.getCarsModelsFromAPI(position).enqueue(new Callback<CarApiResponse>() {
                @Override
                public void onResponse(Call<CarApiResponse> call, Response<CarApiResponse> response) {
                    carApiResponse = response.body();
                    if (carApiResponse.getStatus() >= 200 || carApiResponse.getStatus() < 300) {
                        nextKey = carApiResponse.getData().isEmpty() ? null : position + 1;
                        prevKey = position == startingPage ? null : position - 1;

                    }
                }

                @Override
                public void onFailure(Call<CarApiResponse> call, Throwable t) {
                    Log.e("MyTag", "Kindly Check Your Internet Connection :)");
                }
            });
            return new LoadResult.Page(carApiResponse.getData(), prevKey, nextKey);

        } catch (Exception e) {
            return new LoadResult.Error<Integer, String>(e);
        }
    }
}
