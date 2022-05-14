package com.example.vibprojectmobile.LoadingScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.vibprojectmobile.Home.HomeActivity;
import com.example.vibprojectmobile.R;

public class MainActivityLoadingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_loading_screen);


        //Ini Code buat loading screen dikasi waktu 1 detik
     final Handler handler = new Handler();
     handler.postDelayed(new Runnable() {
         @Override
         public void run() {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
         }
     },1000);
    }

}