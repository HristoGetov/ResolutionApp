package com.example.resolutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.Duration;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("hristogetov","ResolutionApp")
                .setDisplay(Display.SNACKBAR);//.setDuration(Duration.NORMAL);
        appUpdater.setTitleOnUpdateAvailable("Update available")
                .setContentOnUpdateAvailable("Check out the latest version available of my app!")
                .setTitleOnUpdateNotAvailable("Update not available")
                .setContentOnUpdateNotAvailable("No update available. Check for updates again later!")
                .setButtonUpdate("Update now?")
                .setIcon(R.drawable.ic_launcher_foreground) // Notification icon
                .setCancelable(false);
        appUpdater.start();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        TextView textView = findViewById(R.id.size);
        textView.setText("Resolution: \n" + "Height: " + height + "\n Width: " + width);
        TextView releaseView = findViewById(R.id.new_release);
        releaseView.setText("Version 1.2");
       // Log.e("Resolution", "Height: " + height + ", Width: " + width);
//        Toast.makeText(this,"Resolution: " + "Height: " + height + ", Width: " + width, Toast.LENGTH_LONG).show();
//        Toast.makeText(this,"This is a message for new release! ", Toast.LENGTH_LONG).show();
//        Toast.makeText(this,"This is a message for new release version 1.2! ", Toast.LENGTH_LONG).show();


    }
}