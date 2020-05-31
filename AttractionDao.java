package com.example.tokyo2020;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AttractionDao {

    @Insert
    void insert(Attraction attraction);

    @Query("Select * from attraction_table")
    List<Attraction> getAllAttractions();

    @Query("Select * from attraction_table where name = :name")
    List<Attraction> getArrtactionDetails(String name);

    @Query("Select name from attraction_table")
    List<Attraction> getAllAttrName();

}
