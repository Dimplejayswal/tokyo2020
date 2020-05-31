package com.example.tokyo2020;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("Select * from user_table")
    List<User>getUsers();

    @Query("Update user_table set ratings=:rating where emailId=:email")
    void setRating(double rating, String email);

    @Query("Select * from user_table where emailId=:emailId")
    List<User> getSelectedUser(String emailId);

}
