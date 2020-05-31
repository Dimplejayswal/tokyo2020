package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity
{

    public  static UserDatabase ub;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ub= Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"users").allowMainThreadQueries().build();


        List<User> userList = MainActivity.userDB.userDao().getUsers();
        users=(ArrayList<User>) userList;


    }
    public  void usersignup(View view)
    {
        EditText emailId = (EditText) findViewById(R.id.emailedit);
        String username = emailId.getText().toString();
        EditText passwr = (EditText) findViewById(R.id.passedit);
        String password = passwr.getText().toString();


        if(username.equals("")||password.equals(""))
        {
            Toast t = Toast.makeText(getApplicationContext(), "Email or Password can't be Emptry!", Toast.LENGTH_SHORT);
            t.show();
        }
        else
        {
            Boolean checkUserexits = false;




            for (int i = 0; i < users.size(); i++)
            {
                if (username.equals(users.get(i).emailId))
                {
                    Toast t = Toast.makeText(getApplicationContext(), "User " + username + " already exists !", Toast.LENGTH_SHORT);
                    checkUserexits = true;
                    t.show();
                    break;
                }

            }


            if (checkUserexits == false)
            {
                User user = new User(username, password, 0,0);
                ub.userDao().insert(user);

                Toast t = Toast.makeText(getApplicationContext(), "User " + username + " Created!", Toast.LENGTH_SHORT);
                t.show();
                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
            }


        }
        }

}



