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

public class MainActivity extends AppCompatActivity
{
    public static UserDatabase userDB;
    public static AttractionDatabase ad;
    ArrayList<User> users;
    String CurrentLogin;
    User u4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        u4 = new User("admin", "admin", 001,0);


        Attraction a1=new Attraction("MORI Building DIGITAL ART MUSEUM — teamLab Borderless",
                "Japan, 〒135-0064 Tokyo, Koto City, Aomi, 1 Chome−3−8 お台場パレットタウン",
                "The museum offers an unique interactive art experience with the latest high technology.",
                "What is teamLab (チームラボ)??\n" +
                        "teamLab (f. 2001) is an art collective, an interdisciplinary group of ultratechnologists" +
                        " whose collaborative practice seeks to navigate the confluence of art, science, technology, design and the natural world. Various specialists such " +
                        "as artists, programmers, engineers, CG animators, mathematicians and architects form teamLab." +
                        "teamLab aims to explore a new relationship between humans and nature, and between oneself and the world through art. Digital technology has " +
                        "allowed art to liberate itself from the physical and transcend boundaries. teamLab sees no boundary between humans and nature, and between" +
                        " oneself and the world; one is in the other and the other in one. Everything exists in a long, fragile yet miraculous, borderless continuity of life.",
                "","https://www.youtube.com/watch?v=zsXaGmQlDPs");

        Attraction a2=new Attraction("Sensoji at Asakusa",
                "2 Chome-3-1 Asakusa, Taito City, Tokyo 111-0032, Japan",
                "Sensō-ji is an ancient Buddhist temple located in Asakusa, Tokyo, Japan.",
                "The first temple was founded in 645 AD, which makes it the oldest temple in Tokyo.[7] In the early years of the Tokugawa shogunate, Tokugawa" +
                        " Ieyasu designated Sensō-ji as tutelary temple of the Tokugawa clan.[8]\n" +
                        "\n" +
                        "The Nishinomiya Inari shrine is located within the precincts of Sensō-ji and a torii identifies the entry into the hallowed ground of the shrine." +
                        " A bronze plaque on the gateway structure lists those who contributed to the construction of the torii," +
                        " which was erected in 1727 (Kyōhō 12, 11th month).",
                "","https://www.youtube.com/watch?v=VreIzj9WRtk");

        Attraction a3=new Attraction("Tokyo National Museum",
                "13-9 Uenokoen, Taito City, Tokyo 110-8712, Japan",
                "The institution itself is a national treasure—it's Japan's oldest museum.",
                "The Tokyo National Museum (東京国立博物館, Tōkyō Kokuritsu Hakubutsukan) or TNM is an art museum in Ueno Park in the Taitō ward of Tokyo, Japan. " +
                        "It is considered the oldest national museum in Japan, is the largest art museum in Japan, and is one of the largest art museums in the world." +
                        " The museum collects, preserves, and displays a comprehensive collection of artwork and cultural objects from Asia, " +
                        "with a focus on ancient and medieval Japanese art and Asian art along the Silk Road. There is also a large collection of Greco-Buddhist art" +
                        ". The museum holds over 110,000 objects, including 87 National Treasures of Japan, 319 Horyuji Treasures, and 610 Important Cultural Properties" +
                        " (as of July 2005). The museum also conducts research and organizes educational events related to its collection.",
                "","https://www.youtube.com/watch?v=ysYrbIYRIcI");


        Attraction a4=new Attraction("Ueno Zoo",
                "9-８３ Uenokoen, Taito City, Tokyo 110-8711, Japan",
                "It is Japan's oldest zoo, opening on March 20, 1882.",
                "The Ueno Zoo (恩賜上野動物園, Onshi Ueno Dōbutsuen) is a 14.3-hectare (35-acre) zoo, managed by the Tokyo Metropolitan Government, and located in Taitō, Tokyo, Japan." +
                        "The Ueno Zoo Monorail, the first monorail in the country, connects the eastern and western parts of the grounds.\n" +
                        "The zoo is in Ueno Park, a large urban park that is home to museums, a small amusement park, and other attractions. The zoo is closed Mondays (Tuesday if Monday is a holiday)." +
                        "The zoo started life as a menagerie attached to the National Museum of Natural History. In 1881, responsibility for this menagerie was handed to naturalist and civil servant Tanaka Yoshio," +
                        " who oversaw its transition into a public zoo.[3] The ground was originally estate of the imperial family, but was bestowed (恩賜, onshi, forming the first" +
                        " part of the name in Japanese, untranslated officially) to the municipal government in 1924 — along with Ueno Park — on the occasion of crown prince " +
                        "Hirohito's wedding.",
                "","https://www.youtube.com/watch?v=kMVsGEqlVns");


        Attraction a5=new Attraction("Tokyo Skytree",
                "1 Chome-1-2 Oshiage, Sumida City, Tokyo 131-0045, Japan",
                "Topping off at 2,080 feet, Tokyo Skytree is the tallest tower in the world.",
                "From the broadcast tower's 360-degree observation decks, the whole city—its striking skyscrapers and neon intersections—looks like a magical circuit board. " +
                        "It's a major tourist attraction and a ticket isn't cheap (up to ¥4,000, or $36 for all-access), but even if you don't pay up, there's no denying that" +
                        " Tokyo Skytree brought the skyline to a whole new level. While it's a bona fide broadcast tower, it's also a major tourist attraction. " +
                        "Depending on where you're staying, it can be an out-of-the-way trip to eastern Tokyo (luckily, a train station gets you right near the entrance)." +
                        " But the tower's base also stocks hundreds of shops and nearby cafes (a Moomin House Cafe is particularly animated), so it will keep you busy for a " +
                        "full afternoon. Families with children will enjoy the experience (especially speedy elevator rides), and anyone that loves a jaw-dropping view.",
                "","https://www.youtube.com/watch?v=H7pcm5vICdU");



        ad = Room.databaseBuilder(getApplicationContext(), AttractionDatabase.class, "attractions").allowMainThreadQueries().build();
        userDB = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users").allowMainThreadQueries().build();


        List<Attraction> AttractionCheckList = ad.attractionDao().getAllAttractions();

        if(AttractionCheckList.size() == 0)
        {
            ad.attractionDao().insert(a1);
            ad.attractionDao().insert(a2);
            ad.attractionDao().insert(a3);
            ad.attractionDao().insert(a4);
            ad.attractionDao().insert(a5);
        }

        EditText usern = (EditText) findViewById(R.id.edituser);
        String username = usern.getText().toString();
        EditText passw = (EditText) findViewById(R.id.editpassword);
        String password = passw.getText().toString();



        //User u1=new User("wonderwoman@yahoo.com","abc00021");
        //User u2=new User("johnsnow@winteriscoming.com","gameofthrones2");
        //User u3=new User("superman@kypton.com","kk11iii");


        List<User> userList = userDB.userDao().getUsers();
        users = (ArrayList<User>) userList;
        boolean findAdmin = false;
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getEmailId().equals("admin"))
            {
                findAdmin = true;
                break;
            }
        }
        if(findAdmin ==false)
        {
            userDB.userDao().insert(u4);
        }

        userList = userDB.userDao().getUsers();
        users = (ArrayList<User>) userList;

        //Toast t = Toast.makeText(getApplicationContext(), ""+users.size(), Toast.LENGTH_LONG);
        //t.show();
    }

    public void onloginbottom(View view)
    {

        EditText usern = (EditText) findViewById(R.id.edituser);
        String username = usern.getText().toString();
        EditText passw = (EditText) findViewById(R.id.editpassword);
        String password = passw.getText().toString();


        Boolean checkUserFlag = false;

        if(username.equals("") || password.equals(""))
        {
            Toast t = Toast.makeText(getApplicationContext(), "Username or Password can't be Empty!", Toast.LENGTH_LONG);
            t.show();
        }
        else
        {
            if (username.equals(u4.emailId) && password.equals(u4.passWord))
            {

                Intent i = new Intent(this, TouristActivity.class);
                checkUserFlag = true;
                CurrentLogin = "admin";
                i.putExtra("CurrentLogin", CurrentLogin);
                startActivity(i);
            }

            for (int i = 0; i < users.size(); i++)
            {
                if (username.equals(users.get(i).emailId))
                {
                    checkUserFlag = true;
                    if(!password.equals(users.get(i).passWord))
                    {
                        Toast t = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
                        t.show();
                        break;
                    }
                    else if(password.equals(users.get(i).passWord))
                    {
                        CurrentLogin = username;
                        Intent j = new Intent(this, TouristActivity.class);
                        checkUserFlag = true;
                        j.putExtra("CurrentLogin", CurrentLogin);
                        startActivity(j);
                        break;
                    }
                }
            }
            if (checkUserFlag == false)
            {

                Toast t = Toast.makeText(getApplicationContext(), "User " + username + " is not Registered !\nPlease Sign Up", Toast.LENGTH_LONG);
                t.show();
                passw.setText("");
            }
        }



    }

    public void onsignup (View view)
    {


        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }
}