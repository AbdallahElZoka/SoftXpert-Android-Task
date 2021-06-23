package com.DevAbdallahEl_Zoka.SoftXpertAndroidTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineScope;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    @Inject
    HomeViewModel(WebServices webServices) {

    }

    WebServices webServices;


    public LiveData<PagingData<CarDataItem>> getCarsModelsFromAPI() {
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        Pager<Integer, CarDataItem> pager = new Pager(
                new PagingConfig(/* pageSize = */ 20),
                () -> new CarModelsPagingSource(webServices, 20));

        return PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);


        /*CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        Pager<Integer, CarDataItem> pager = new Pager(
                new PagingConfig(20, 15, false, 20),
                () -> new CarModelsPagingSource(webServices, 20));

        return PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);
*/

    }

}
