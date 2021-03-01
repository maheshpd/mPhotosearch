package com.createsapp.photoproject.response;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {
    @SerializedName("id")
    int id;

    @SerializedName("author")
    String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
