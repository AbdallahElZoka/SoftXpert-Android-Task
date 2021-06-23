package com.dev_abdallah_el_zoka.softxpert_android_task.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dev_abdallah_el_zoka.softxpert_android_task.view.adpaters.CarModelsAdapter;
import com.dev_abdallah_el_zoka.softxpert_android_task.view_models.HomeViewModel;
import com.dev_abdallah_el_zoka.softxpert_android_task.R;
import com.dev_abdallah_el_zoka.softxpert_android_task.databinding.ActivityHomeBinding;
import com.dev_abdallah_el_zoka.softxpert_android_task.model.pojo.CarDataItem;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {
    HomeViewModel homeViewModel;

    private ActivityHomeBinding activityMainBinding;
    private CarModelsAdapter carModelsAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        linearLayoutManager = new LinearLayoutManager(this);
        activityMainBinding.carsRecyclerView.setLayoutManager(linearLayoutManager);
        carModelsAdapter = new CarModelsAdapter(new DiffUtil.ItemCallback<CarDataItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull CarDataItem oldItem, @NonNull @NotNull CarDataItem newItem) {
                return oldItem.getCarId() == oldItem.getCarId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull @NotNull CarDataItem oldItem, @NonNull @NotNull CarDataItem newItem) {
                return oldItem.getCarId() == oldItem.getCarId();
            }
        });
        activityMainBinding.carsRecyclerView.setAdapter(carModelsAdapter);
        homeViewModel.getCarsModelsFromAPI().observe(this, carDataItemPagingData -> {
            carModelsAdapter.submitData(getLifecycle(), carDataItemPagingData);
            carModelsAdapter.notifyDataSetChanged();
            Log.e("MyTag", "Entered On Data Changed Live Data");
        });

    }
}
