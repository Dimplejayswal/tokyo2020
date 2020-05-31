package com.example.tokyo2020;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_table")
public class User {


    private String firstName;
    private String lastName;
    int id;
    @NonNull
    @PrimaryKey
    String emailId;
    String passWord;
    double ratings;



    public User(String emailId, String passWord, int id, double ratings) {
        this.emailId = emailId;
        this.passWord = passWord;
        this.id = id;
        this.ratings=ratings;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}
