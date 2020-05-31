package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    String CurrentLogin;

    AttractionListViewAdapter adapter;

    final String TAG = "EMPLOYEE";
    public static final int PICK_IMAGE = 1;
    ImageView imageView;
    Uri selectedImage;
    String selectedImagePath;
    List<Attraction> attractionList;
    ArrayList<Attraction> attractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        imageView=(ImageView)findViewById(R.id.imageedit);

        attractionList = MainActivity.ad.attractionDao().getAllAttrName();
        attractions=(ArrayList<Attraction>) attractionList;

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");

    }

    public void addattractionbutton(View view) {

        attractionList = MainActivity.ad.attractionDao().getAllAttrName();
        attractions=(ArrayList<Attraction>) attractionList;
        Boolean attractionFlag = false;

        EditText name = (EditText) findViewById(R.id.addname);
        String attname = name.getText().toString();
        EditText add = (EditText) findViewById(R.id.addaddress);
        String attadd = add.getText().toString();
        EditText oneLine = (EditText) findViewById(R.id.oneline);
        String oneline = oneLine.getText().toString();
        EditText desc = (EditText) findViewById(R.id.description);
        String description = desc.getText().toString();
        EditText videoUrl = (EditText) findViewById(R.id.videoUrl);
        String VideoUrl = videoUrl.getText().toString();


        for(int i=0;i<attractions.size();i++) {

            if (attname.equals(attractions.get(i).name)) {
                attractionFlag = true;
                Toast t = Toast.makeText(getApplicationContext(), "" + attname + " already exists !", Toast.LENGTH_SHORT);
                t.show();
                break;
            }
        }


        if(attname.equals(""))
        {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Attraction Name can't be Empty!", Toast.LENGTH_SHORT);
            toast1.show();
        }

        if(!attname.equals("") && attractionFlag == false)
        {
            Attraction attraction = new Attraction(attname, attadd,oneline, description, selectedImagePath, VideoUrl);
            MainActivity.ad.attractionDao().insert(attraction);


            Toast toast = Toast.makeText(getApplicationContext(), "Attraction inserted", Toast.LENGTH_SHORT);
            toast.show();

            name.setText("");
            add.setText("");
            oneLine.setText("");
            desc.setText("");
            videoUrl.setText("");
            imageView.setImageResource(0);
            selectedImagePath=null;
        }



        //adapter.notifyDataSetChanged();

    }

    public void totourist(View view) {
        Intent i = new Intent(this, TouristActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivity(i);
    }


    public void onlogout(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void onimagebuttonclick(View view) {
        selectedImagePath=null;
        Intent pickPhoto = new Intent(Intent.ACTION_OPEN_DOCUMENT,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickPhoto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        startActivityForResult(pickPhoto, 0);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                    selectedImagePath = selectedImage.toString();
                }
                break;

        }

    }

}