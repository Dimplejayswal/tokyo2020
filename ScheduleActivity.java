package com.example.tokyo2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {

    String CurrentLogin;
    String Channel_id;
    boolean upComingEvent = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getSupportActionBar().setTitle("ScheduleActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CurrentLogin = getIntent().getStringExtra("CurrentLogin");
        createNotificationChannel();


    }
    public void scheduleonclick(View view){

        WebView webView=(WebView)findViewById(R.id.webview);
        webView.loadUrl("https://tokyo2020.org/en/schedule/");
    }

    public void setdate(int year, int month, int dayofMonth) {

        if(dayofMonth==22 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200722-schedule");
            upComingEvent  =true;

        }
        else if(dayofMonth==23 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200723-schedule");
            upComingEvent  =true;
        }

        else if(dayofMonth==24 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200724-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==25 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200725-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==26 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200726-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==27 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200727-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==28 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200728-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==29 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200729-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==30 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200730-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==31 && (month+1) == 7 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200731-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==1 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200801-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==2 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200802-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==3 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200803-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==4 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200804-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==5 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200805-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==6 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200806-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==7 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200807-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==8 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200808-schedule");
            upComingEvent  =true;
        }
        else if(dayofMonth==9 && (month+1) == 8 && year==2020){
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("https://tokyo2020.org/en/schedule/20200809-schedule");
            upComingEvent  =true;
        }

        else {
            WebView webView=(WebView)findViewById(R.id.webview);
            webView.loadUrl("about:blank");
            Toast.makeText(getApplicationContext(),"Sorry,No events on that day",Toast.LENGTH_SHORT).show();
        }


        Intent intent = new Intent(this, ScheduleActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_id)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Tokyo 2020 Notification")
                //.setContentText("Upcoming Events")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(Channel_id)
                .setAutoCancel(true);

        if(upComingEvent == true)
        {
            builder.setContentText("Upcoimg Event");
        }
        if (upComingEvent == false)
        {
            builder.setContentText("No event on this day");
        }

        int notificationid=0;

        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(this);
        notificationManager.notify(notificationid,builder.build());
    }

    public void datebuttonpressed(View view) {
        upComingEvent = false;
        DialogFragment datepicker=new DatePickerFragment();
        datepicker.show(getSupportFragmentManager(),"datePicker");
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(), TouristActivity.class);
        i.putExtra("CurrentLogin",CurrentLogin);
        startActivityForResult(i, 0);
        return true;
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "";
            String description = "";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(Channel_id, name, importance);
            channel.setDescription(description);

        }
    }
}
