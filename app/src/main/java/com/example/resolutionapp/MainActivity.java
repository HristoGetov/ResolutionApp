package com.example.resolutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        TextView textView = findViewById(R.id.size);
        textView.setText("Resolution: \n" + "Height: " + height + "\n Width: " + width);
        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setUpdateFrom(UpdateFrom.GITHUB);
        appUpdater.setGitHubUserAndRepo("hristogetov","ResolutionApp")
                .setDisplay(Display.DIALOG).setCancelable(false)
                .start();
       // Log.e("Resolution", "Height: " + height + ", Width: " + width);
        Toast.makeText(this,"Resolution: " + "Height: " + height + ", Width: " + width, Toast.LENGTH_LONG).show();
        Toast.makeText(this,"This is a message for new release! ", Toast.LENGTH_LONG).show();

    }
}