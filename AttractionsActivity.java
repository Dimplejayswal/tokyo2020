package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AttractionsActivity extends AppCompatActivity {


    ArrayList<Attraction> attractions;
    ArrayList<WishListAttraction> wishlist;
    AttractionListViewAdapter adapter;

    String CurrentLogin;
    public static WishListAttractionDatabase wladb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        getSupportActionBar().setTitle("Attractions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

        wladb = Room.databaseBuilder(getApplicationContext(), WishListAttractionDatabase.class, "wishlist").allowMainThreadQueries().build();

        final List<Attraction> attractionList=MainActivity.ad.attractionDao().getAllAttractions();
        attractions=(ArrayList<Attraction>) attractionList;
        adapter=new AttractionListViewAdapter(this,R.layout.displayattractionlist,attractions);

        final ListView lv=(ListView)findViewById(R.id.listview1);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view, int i, long l) {


                AlertDialog.Builder builder=new AlertDialog.Builder(AttractionsActivity.this);
                builder.setTitle("More Options");
                builder.setMessage("Do you want this item to be saved in your Wish List?");

                final int k=i;
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {

                        final List<WishListAttraction> CurrentattractionList=wladb.wishlistattractionDao().
                                queryUserWishListAttractions(attractions.get(k).name, CurrentLogin);
                        ArrayList<WishListAttraction> Curattractions=(ArrayList<WishListAttraction>) CurrentattractionList;

                        if(Curattractions.size()>0)
                        {
                            Toast t = Toast.makeText(getApplicationContext(), "Attraction already in the Wish List!", Toast.LENGTH_SHORT);
                            t.show();
                        }
                        else
                        {
                            WishListAttraction wishlistobject = new WishListAttraction(CurrentLogin,attractions.get(k).name,attractions.get(k).address
                                    ,attractions.get(k).oneline,attractions.get(k).description,attractions.get(k).ImagePath);
                            wladb.wishlistattractionDao().insert(wishlistobject);
                            Toast t = Toast.makeText(getApplicationContext(), "Added to the Wish List!", Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }
                });

                builder.setNegativeButton("No",null);

                builder.setNeutralButton("More Details", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(AttractionsActivity.this,MoreDetailsActivity.class);
                        intent.putExtra("CurrentLogin",CurrentLogin);
                        intent.putExtra("AttractionName",attractions.get(k).name);
                        startActivity(intent);
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();
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
