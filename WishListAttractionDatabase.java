package com.example.tokyo2020;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {WishListAttraction.class},version = 1)
public abstract class WishListAttractionDatabase extends RoomDatabase {
    public abstract WishListAttractionDao wishlistattractionDao();
}
