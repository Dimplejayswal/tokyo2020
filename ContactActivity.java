package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    String CurrentLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setTitle("ContactActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        Button call=(Button)findViewById(R.id.button1);
    }
    public void callonclick(View view){
        Intent i=new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:1234567890"));

        if(ActivityCompat.checkSelfPermission(ContactActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(i);
    }

    public void mesonclick(View view){

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        startActivity(sendIntent);

    }

    public void emailonclick(View view){

        Intent email=new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","enquiries.contact@olympic.org",null));
        email.putExtra(Intent.EXTRA_SUBJECT, "Olympic 2020 Inquiry");
        startActivity(Intent.createChooser(email, "Send Email"));


    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), TouristActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivityForResult(i, 0);
        return true;
    }
}
