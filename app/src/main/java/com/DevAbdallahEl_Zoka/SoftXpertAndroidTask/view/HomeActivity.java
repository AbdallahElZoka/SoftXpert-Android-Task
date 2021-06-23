package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.view.adpaters.CarModelsAdapter;
import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.view_models.HomeViewModel;
import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.R;
import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.databinding.ActivityHomeBinding;
import com.DevAbdallahEl_Zoka.SoftXpertAndroidTask.model.pojo.CarDataItem;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {
    @Inject
    HomeViewModel homeViewModel;

    ActivityHomeBinding activityMainBinding;
    CarModelsAdapter carModelsAdapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
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
