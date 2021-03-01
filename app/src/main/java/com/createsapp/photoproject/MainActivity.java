package com.createsapp.photoproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.createsapp.photoproject.adapter.PhotoAdapter;
import com.createsapp.photoproject.model.PhotoModel;
import com.createsapp.photoproject.response.PhotoResponse;
import com.createsapp.photoproject.viewmodel.PhotoViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Widget
    RecyclerView photoRecyclerView;
    PhotoAdapter adapter;
    ArrayList<PhotoResponse> photoModelList;
    PhotoViewModel photoViewModel;

    Toolbar toolbars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbars = findViewById(R.id.toolbar);
        toolbars.setTitle("Lorem Picsum");
        setSupportActionBar(toolbars);

        photoModelList = new ArrayList<>();
        photoRecyclerView = findViewById(R.id.photo_recycler);
        photoViewModel = new ViewModelProvider(this).get(PhotoViewModel.class);
        getAllPhoto();


        photoRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        photoRecyclerView.setHasFixedSize(true);
       /* photoRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        photoRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
*/

    }

    private void getAllPhoto() {
        photoViewModel.getAllPhotoData().observe(this, allresponse -> {
            if (allresponse != null){
                photoModelList.addAll(allresponse);
                adapter = new PhotoAdapter(this,photoModelList);

                photoRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}