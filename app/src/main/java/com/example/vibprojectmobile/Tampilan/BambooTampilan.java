package com.example.vibprojectmobile.Tampilan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vibprojectmobile.Adapter.AdapterBamboo;
import com.example.vibprojectmobile.Form.FormBamboo;
import com.example.vibprojectmobile.Model.ModelBamboo;
import com.example.vibprojectmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BambooTampilan extends AppCompatActivity {
    FloatingActionButton button_plusBamboo;
    AdapterBamboo adapterLaporanBamboo;
    DatabaseReference vibDtabaseBamboo = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelBamboo> listBamboo;
    RecyclerView tampil_dataBamboo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bamboo_tampilan);

        //Ini buat orang lapangan menambah data (+)
        button_plusBamboo = findViewById(R.id.button_plusBamboo);
        button_plusBamboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BambooTampilan.this, FormBamboo.class));
            }
        });
        tampil_dataBamboo = findViewById(R.id.tampil_dataBamboo);
        RecyclerView.LayoutManager layoutBamboo =  new LinearLayoutManager(this);
        tampil_dataBamboo.setLayoutManager(layoutBamboo);
        tampil_dataBamboo.setItemAnimator(new DefaultItemAnimator());

        tampil_dataBamboo();
    }
    private void tampil_dataBamboo(){
        vibDtabaseBamboo.child("Laporan Bamboo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listBamboo = new ArrayList<>();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    ModelBamboo bamboo =  item.getValue(ModelBamboo.class);
                    bamboo.setKunciBamboo(item.getKey());
                    listBamboo.add(bamboo);
                }
                adapterLaporanBamboo = new AdapterBamboo(listBamboo, BambooTampilan.this);
                tampil_dataBamboo.setAdapter(adapterLaporanBamboo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}