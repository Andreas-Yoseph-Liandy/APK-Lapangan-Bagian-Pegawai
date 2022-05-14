package com.example.vibprojectmobile.Tampilan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.vibprojectmobile.Adapter.AdapterVila;
import com.example.vibprojectmobile.Form.FormVilla;
import com.example.vibprojectmobile.Model.ModelVilla;
import com.example.vibprojectmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VillaTampilan extends AppCompatActivity {
    FloatingActionButton button_plus;
    AdapterVila adapterLaporan;
    DatabaseReference vibDtabase = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelVilla> listVilla;
    RecyclerView tampil_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.villa_tampilan);


        //Ini buat orang lapangan menambah data (+)
        button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VillaTampilan.this, FormVilla.class));
            }
        });
        tampil_data = findViewById(R.id.tampil_data);
        RecyclerView.LayoutManager layoutVila = new LinearLayoutManager(this);
        tampil_data.setLayoutManager(layoutVila);
        tampil_data.setItemAnimator(new DefaultItemAnimator());

        tampil_data();

    }

    private void tampil_data() {
        vibDtabase.child("Laporan Vila").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listVilla = new ArrayList<>();
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    ModelVilla vilaStandard = item.getValue(ModelVilla.class);
                    vilaStandard.setKunci(item.getKey());
                    listVilla.add(vilaStandard);
                }
                adapterLaporan = new AdapterVila(listVilla, VillaTampilan.this);
                tampil_data.setAdapter(adapterLaporan);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

