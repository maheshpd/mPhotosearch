package com.createsapp.photoproject.network;

import com.createsapp.photoproject.model.PhotoModel;
import com.createsapp.photoproject.response.PhotoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("list")
    Call<List<PhotoResponse>> getPhoto();

}
