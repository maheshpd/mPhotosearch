package com.createsapp.photoproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.createsapp.photoproject.R;
import com.createsapp.photoproject.model.PhotoModel;
import com.createsapp.photoproject.response.PhotoResponse;


import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    Context context;
    ArrayList<PhotoResponse> photoModelArrayList;
    String url = "https://picsum.photos/300/300?image=";

    public PhotoAdapter(Context context, ArrayList<PhotoResponse> photoModelArrayList) {
        this.context = context;
        this.photoModelArrayList = photoModelArrayList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoResponse response = photoModelArrayList.get(position);
        Glide.with(context).load(url+response.getId()).into(holder.photoView);
        holder.authorName.setText(response.getAuthor());
    }

    @Override
    public int getItemCount() {
        return photoModelArrayList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        TextView authorName;
        ImageView photoView;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.place_name);
            photoView = itemView.findViewById(R.id.place_img);
        }
    }
}

