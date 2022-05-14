package com.example.vibprojectmobile.Tampilan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vibprojectmobile.Adapter.AdapterHotel;
import com.example.vibprojectmobile.Form.FormHotel;
import com.example.vibprojectmobile.Model.ModelHotel;
import com.example.vibprojectmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HotelTampilan extends AppCompatActivity {
    FloatingActionButton button_plusHotel;
    AdapterHotel adapterLaporanHotel;
    DatabaseReference vibDtabaseHotel = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelHotel> listHotel;
    RecyclerView tampil_dataHotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_tampilan);


        //Ini buat orang lapangan menambah data (+)
        button_plusHotel = findViewById(R.id.button_plusHotel);
        button_plusHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelTampilan.this, FormHotel.class));
            }
        });
        tampil_dataHotel = findViewById(R.id.tampil_dataHotel);
        RecyclerView.LayoutManager layoutHotel =  new LinearLayoutManager(this);
        tampil_dataHotel.setLayoutManager(layoutHotel);
        tampil_dataHotel.setItemAnimator(new DefaultItemAnimator());

        tampil_dataHotel();
    }

    private void tampil_dataHotel(){
        vibDtabaseHotel.child("Laporan Hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listHotel = new ArrayList<>();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    ModelHotel hotel =  item.getValue(ModelHotel.class);
                    hotel.setKunciHotel(item.getKey());
                    listHotel.add(hotel);
                }
                adapterLaporanHotel = new AdapterHotel(listHotel, HotelTampilan.this);
                tampil_dataHotel.setAdapter(adapterLaporanHotel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}