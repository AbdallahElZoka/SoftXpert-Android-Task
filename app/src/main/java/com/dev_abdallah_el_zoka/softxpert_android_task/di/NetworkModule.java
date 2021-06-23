package com.dev_abdallah_el_zoka.softxpert_android_task.di;

import com.dev_abdallah_el_zoka.softxpert_android_task.model.api.WebServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public abstract class NetworkModule {

    @Provides
    @Singleton
    public static WebServices getWebServices(Retrofit retrofit) {
        return retrofit.create(WebServices.class);
    }

    @Provides
    @Singleton
    public static Retrofit getRetrofitClient(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("http://demo1286023.mockable.io/api/v1/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public static OkHttpClient getOkHTTPClientLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        return client;
    }
}
