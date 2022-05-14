package com.example.vibprojectmobile.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vibprojectmobile.R;
import com.example.vibprojectmobile.Tampilan.BambooTampilan;
import com.example.vibprojectmobile.Tampilan.HotelTampilan;
import com.example.vibprojectmobile.Tampilan.VillaTampilan;

public class HomeActivity extends AppCompatActivity {
    private Button buttonVilla,buttonHotel, buttonBamboo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //OnClick Button Villa di Home Screen
        buttonVilla = findViewById(R.id.buttonVilla);
        buttonVilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukaButtonVilla();
            }
        });

        //OnClick Button Hotel di Home Screen
        buttonHotel = findViewById(R.id.buttonHotel);
        buttonHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukaButtonHotel();
            }
        });

        //OnClick Button Bamboo di Home Screen
        buttonBamboo = findViewById(R.id.buttonBamboo);
        buttonBamboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukaButtonBamboo();
            }
        });





    }

    //Fungsi Button Villa
    public void bukaButtonVilla(){
        Intent bukaVilla = new Intent(this, VillaTampilan.class);
        startActivity(bukaVilla);
    }

    //Fungsi Button Hotel
    public void bukaButtonHotel(){
        Intent bukaHotel = new Intent(this, HotelTampilan.class);
        startActivity(bukaHotel);
    }

    //Fungsi Button Bamboo
    public void bukaButtonBamboo(){
        Intent bukaBamboo = new Intent(this, BambooTampilan.class);
        startActivity(bukaBamboo);
    }




}