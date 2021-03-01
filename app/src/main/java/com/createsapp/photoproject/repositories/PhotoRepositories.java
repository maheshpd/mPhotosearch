package com.createsapp.photoproject.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.createsapp.photoproject.model.PhotoModel;
import com.createsapp.photoproject.network.ApiClient;
import com.createsapp.photoproject.network.ApiService;
import com.createsapp.photoproject.response.PhotoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepositories {

    private ApiService apiService;
    private Context context;

    public PhotoRepositories() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<List<PhotoResponse>> getPhoto() {
        MutableLiveData<List<PhotoResponse>> photoData = new MutableLiveData<>();
        apiService.getPhoto().enqueue(new Callback<List<PhotoResponse>>() {
            @Override
            public void onResponse(Call<List<PhotoResponse>> call, Response<List<PhotoResponse>> response) {
                photoData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoResponse>> call, Throwable t) {
                photoData.setValue(null);
            }
        });

        return photoData;
    }

}
