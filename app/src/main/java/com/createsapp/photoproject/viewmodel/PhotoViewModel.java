package com.createsapp.photoproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.createsapp.photoproject.repositories.PhotoRepositories;
import com.createsapp.photoproject.response.PhotoResponse;

import java.util.List;

public class PhotoViewModel extends ViewModel {

    private PhotoRepositories photoRepositories;

    public PhotoViewModel() {
        photoRepositories = new PhotoRepositories();
    }

    public LiveData<List<PhotoResponse>> getAllPhotoData(){
        return photoRepositories.getPhoto();
    }
}
