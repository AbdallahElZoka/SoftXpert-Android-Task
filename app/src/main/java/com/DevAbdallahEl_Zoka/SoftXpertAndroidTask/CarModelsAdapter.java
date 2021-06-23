package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.databinding.CarItemUiBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CarModelsAdapter extends PagingDataAdapter<CarDataItem, CarModelsAdapter.ViewHolder> {

    public CarModelsAdapter(@NotNull DiffUtil.ItemCallback<CarDataItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.car_item_ui, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.carItemUiBinding.setCarDataItem(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CarItemUiBinding carItemUiBinding;

        public ViewHolder(@NonNull @NotNull CarItemUiBinding carItemUiBinding) {
            super(carItemUiBinding.getRoot());
            this.carItemUiBinding = carItemUiBinding;
        }
    }
}
