package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    String CurrentLogin;
    public static UserDatabase userDB;
    TextView ratingviews;
    Button ratingbtn;
    double rate;
    ArrayList <User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        getSupportActionBar().setTitle("Rating Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        userDB = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users").allowMainThreadQueries().build();

        final RatingBar ratingBar=findViewById(R.id.ratingid);
        ratingviews=(TextView)findViewById(R.id.ratingview);
        ratingbtn=(Button)findViewById(R.id.ratingbutton);

        List<User> userList = userDB.userDao().getSelectedUser(CurrentLogin);
        users=(ArrayList<User>) userList;

        ratingBar.setVisibility(View.VISIBLE);
        ratingbtn.setVisibility(View.VISIBLE);
        ratingBar.setRating((float) users.get(0).getRatings());

        ratingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               double rating=ratingBar.getRating();
               userDB.userDao().setRating(rating,CurrentLogin);
               ratingviews.setText("Ratings Submitted!");
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), TouristActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivityForResult(i, 0);
        return true;
    }
}
