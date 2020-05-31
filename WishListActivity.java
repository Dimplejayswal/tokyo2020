package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WishListActivity extends AppCompatActivity {


    ArrayList<WishListAttraction> wishListAttractions;
    //AttractionListViewAdapter adapter;
    WishListAttractionListViewAdapter adapter;
    public static WishListAttractionDatabase wladb;
    String CurrentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        getSupportActionBar().setTitle("WishListActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        wladb = Room.databaseBuilder(getApplicationContext(), WishListAttractionDatabase.class, "wishlist").allowMainThreadQueries().build();
        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        final List<WishListAttraction> wishList=wladb.wishlistattractionDao().getWishListAttractions(CurrentLogin);

        wishListAttractions=(ArrayList<WishListAttraction>)wishList;
        adapter=new WishListAttractionListViewAdapter(this,R.layout.displayattractionlist,wishListAttractions);

        final ListView lv=(ListView)findViewById(R.id.wishlistview);

        lv.setAdapter(adapter);




    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), TouristActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivityForResult(i, 0);
        return true;
    }
}
