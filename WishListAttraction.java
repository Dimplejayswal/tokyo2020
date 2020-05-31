package com.example.tokyo2020;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wishlist_attraction_table")
public class WishListAttraction {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    String emailid;
    String name;
    String address;
    String oneline;
    String description;
    String ImagePath;


    public WishListAttraction() {
    }

    public WishListAttraction(String emailid, String name, String address, String oneline ,String description, String Imagepath) {
        this.emailid = emailid;
        this.name = name;
        this.address = address;
        this.oneline = oneline;
        this.description = description;
        this.ImagePath = Imagepath;
    }

    @NonNull
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(@NonNull String emailid) {
        this.emailid = emailid;
    }

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
}
