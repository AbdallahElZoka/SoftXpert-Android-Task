package com.dev_abdallah_el_zoka.softxpert_android_task.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
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

    ActivityHomeBinding activityMainBinding;
    CarModelsAdapter carModelsAdapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        activityMainBinding.carsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        homeViewModel.getCarsModelsFromAPI().observe(this, carDataItemPagingData -> carModelsAdapter.submitData(getLifecycle(), carDataItemPagingData));


    }
}
