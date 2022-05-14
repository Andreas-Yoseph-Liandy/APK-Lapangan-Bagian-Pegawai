package com.example.vibprojectmobile.Form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vibprojectmobile.Tampilan.BambooTampilan;
import com.example.vibprojectmobile.Model.ModelBamboo;
import com.example.vibprojectmobile.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormBamboo extends AppCompatActivity {
    EditText form_namaPengirimBamboo, form_tanggalKirimBamboo, form_pembayaranBamboo, form_cleaningBamboo, form_jenisBamboo, form_catatanBamboo;
    Button button_tambahLaporanBamboo;
    DatabaseReference vibDatabaseBamboo= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_bamboo);

        //Inisiasi Form
        form_namaPengirimBamboo = findViewById(R.id.form_namaPengirimBamboo);
        form_tanggalKirimBamboo = findViewById(R.id.form_tanggalKirimBamboo);
        form_pembayaranBamboo = findViewById(R.id.form_pembayaranBamboo);
        form_cleaningBamboo = findViewById(R.id.form_cleaningBamboo);
        form_jenisBamboo = findViewById(R.id.form_jenisBamboo);
        form_catatanBamboo = findViewById(R.id.form_catatanBamboo);

        //Inisiasi Button
        button_tambahLaporanBamboo = findViewById(R.id.button_tambahLaporanBamboo);

        button_tambahLaporanBamboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNamaPengirimBamboo = form_namaPengirimBamboo.getText().toString();
                String getTanggalKirimBamboo = form_tanggalKirimBamboo.getText().toString();
                String getPembayaranBamboo = form_pembayaranBamboo.getText().toString();
                String getCleaningBamboo = form_cleaningBamboo.getText().toString();
                String getJenisBamboo = form_jenisBamboo.getText().toString();
                String getCatatanBamboo = form_catatanBamboo.getText().toString();

                if(getNamaPengirimBamboo.isEmpty()){
                    form_namaPengirimBamboo.setText("Nama Pengirim Harus Diisi!");
                }
                else if(getTanggalKirimBamboo.isEmpty()){
                    form_tanggalKirimBamboo.setText("Tanggal Kirim Harus Diisi!");
                }
                else if(getPembayaranBamboo.isEmpty()){
                    form_pembayaranBamboo.setText("Pembayaran Harus Diisi!");
                }
                else if(getCleaningBamboo.isEmpty()){
                    form_cleaningBamboo.setText("Cleaning harus Diisi!");
                }
                else if(getJenisBamboo.isEmpty()){
                    form_jenisBamboo.setText("Jenis Bamboo Harus Diisi!");
                }
                else if(getCatatanBamboo.isEmpty()){
                    form_catatanBamboo.setText("Catatan Harus Diisi!");
                }

                else{
                    vibDatabaseBamboo.child("Laporan Bamboo").push().setValue(new ModelBamboo(getNamaPengirimBamboo, getTanggalKirimBamboo, getPembayaranBamboo, getCleaningBamboo, getJenisBamboo, getCatatanBamboo)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(FormBamboo.this, "Laporan Berhasil dikirim!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(FormBamboo.this, BambooTampilan.class));
                            notification();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FormBamboo.this, "Laporan Gagal dikirim!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
    //Notification Bamboo
    private void notification(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n").setContentText("Villa Istana Bunga").setSmallIcon(R.drawable.ic_iconvila).setAutoCancel(true).setContentText("Data Bamboo Berhasil dikirim!");
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }
}