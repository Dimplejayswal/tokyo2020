package com.example.tokyo2020;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WishListAttractionListViewAdapter extends ArrayAdapter<WishListAttraction> {
    private ArrayList<WishListAttraction> wishlist;
    private Context context;
    private int resource;


    public WishListAttractionListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WishListAttraction> objects) {
        super(context, resource, objects);
        this.wishlist=objects;
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        String attractionName=this.wishlist.get(position).getName();
        String attractionAddress=this.wishlist.get(position).getAddress();
        String attractiononeline=this.wishlist.get(position).getOneline();
        String attractiondescription=this.wishlist.get(position).getDescription();
        String ImagePath=this.wishlist.get(position).getImagePath();

        LayoutInflater inflater=LayoutInflater.from(this.context);
        convertView=inflater.inflate(this.resource,parent,false);

        TextView tv1=(TextView)convertView.findViewById(R.id.attname);
        TextView tv2=(TextView)convertView.findViewById(R.id.attadd);
        TextView tv3=(TextView)convertView.findViewById(R.id.oneline);
        TextView tv4=(TextView)convertView.findViewById(R.id.description);
        ImageView im=(ImageView)convertView.findViewById(R.id.imageView2);



        tv1.setText(attractionName);
        tv2.setText(attractionAddress);
        tv3.setText(attractiononeline);
        //tv4.setText(attractiondescription);


        if(attractionName.contentEquals("MORI Building DIGITAL ART MUSEUM — teamLab Borderless")){
            im.setImageResource(R.drawable.a1);
        }
        else if(attractionName.contentEquals("Sensoji at Asakusa")){
            im.setImageResource(R.drawable.a2);
        }
        else if(attractionName.contentEquals("Tokyo National Museum")){
            im.setImageResource(R.drawable.a3);
        }
        else if(attractionName.contentEquals("Ueno Zoo")){
            im.setImageResource(R.drawable.a4);
        }
        else if(attractionName.contentEquals("Tokyo Skytree")){
            im.setImageResource(R.drawable.a5);
        }
        else {
            if(ImagePath != null)
            {
                Uri uri;
                uri = Uri.parse(ImagePath);
                context.grantUriPermission(context.getPackageName(),uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                im.setImageURI(uri);
            }


        }


        return convertView;
    }
}
