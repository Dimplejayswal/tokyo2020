package com.example.tokyo2020;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attraction_table")
public class Attraction {

    @PrimaryKey
    @NonNull
    String name;
    String address;
    String oneline;
    String description;
    String ImagePath;
    String videoUrl;

    public Attraction() {
    }


    public Attraction(String name, String address, String oneline ,String description, String Imagepath, String videoUrl) {
        this.name = name;
        this.address = address;
        this.oneline = oneline;
        this.description = description;
        this.ImagePath = Imagepath;
        this.videoUrl = videoUrl;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOneline() {
        return oneline;
    }

    public void setOneline(String oneline) {
        this.oneline = oneline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String VideoUrl) {
        videoUrl = VideoUrl;
    }
}
