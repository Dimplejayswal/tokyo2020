package com.example.tokyo2020;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class TouristActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String CurrentLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_attraction);



        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        if(CurrentLogin.equals("admin")){
            View button=findViewById(R.id.adminlogin);
            button.setVisibility(View.VISIBLE);
        }




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tourist_attraction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.contact) {
            Intent i = new Intent(this, ContactActivity.class);
            i.putExtra("CurrentLogin",CurrentLogin);
            startActivity(i);
            return true;
        }
        else if (id == R.id.log) {

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }
        else if (id == R.id.rating) {
            Intent i = new Intent(this, RatingActivity.class);
            i.putExtra("CurrentLogin",CurrentLogin);
            startActivity(i);

        }


        return super.onOptionsItemSelected(item);
    }


    public void onadminlogin(View view)
    {
        Intent intent=new Intent(this, AdminActivity.class);
        intent.putExtra("CurrentLogin",CurrentLogin);
        startActivity(intent);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.attractions) {

            Intent i = new Intent(this,AttractionsActivity.class);
            i.putExtra("CurrentLogin",CurrentLogin);
            startActivity(i);

        } else if (id == R.id.schedule) {
            Intent i = new Intent(this, ScheduleActivity.class);
            i.putExtra("CurrentLogin",CurrentLogin);
            startActivity(i);

        } else if (id == R.id.wishllist) {
            Intent i = new Intent(this, WishListActivity.class);
            i.putExtra("CurrentLogin",CurrentLogin);
            startActivity(i);

        }





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
