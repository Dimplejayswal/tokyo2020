package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class DisplayFirstActivity extends AppCompatActivity {

    private static int Splash_time_out =2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_first);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent home=new Intent(DisplayFirstActivity.this,MainActivity.class);
                startActivity(home);
                finish();

            }
        },Splash_time_out);
    }
}
