package com.dev_abdallah_el_zoka.softxpert_android_task.view.adpaters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_abdallah_el_zoka.softxpert_android_task.R;
import com.dev_abdallah_el_zoka.softxpert_android_task.databinding.CarItemUiBinding;
import com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo.CarDataItem;

import org.jetbrains.annotations.NotNull;

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
