package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MoreDetailsActivity extends AppCompatActivity {
    public static AttractionDatabase ad;
    ArrayList<Attraction> attractions;
    MoreDetailsAdapter adapter;
    String CurrentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        getSupportActionBar().setTitle("More Details");
        String Attractionname = getIntent().getStringExtra("AttractionName");

        ad = Room.databaseBuilder(getApplicationContext(), AttractionDatabase.class, "attractions").allowMainThreadQueries().build();
        final List<Attraction> attractionList=MainActivity.ad.attractionDao().getArrtactionDetails(Attractionname);

        attractions=(ArrayList<Attraction>) attractionList;

        adapter=new MoreDetailsAdapter(this,R.layout.display_more_details,attractions);
        final ListView lv=(ListView)findViewById(R.id.moreDetailsListView);

        lv.setAdapter(adapter);


    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), AttractionsActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivityForResult(i, 0);
        return true;
    }
}
