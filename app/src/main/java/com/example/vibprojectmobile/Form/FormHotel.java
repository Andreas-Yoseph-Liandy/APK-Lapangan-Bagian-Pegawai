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

import com.example.vibprojectmobile.Tampilan.HotelTampilan;
import com.example.vibprojectmobile.Model.ModelHotel;
import com.example.vibprojectmobile.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormHotel extends AppCompatActivity {
    EditText form_namaPengirimHotel, form_tanggalKirimHotel, form_pembayaranHotel, form_cleaningHotel, form_jenisHotel, form_catatanHotel;
    Button button_tambahLaporanHotel;
    DatabaseReference vibDatabaseHotel = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_hotel);

        //Inisiasi Form
        form_namaPengirimHotel = findViewById(R.id.form_namaPengirimHotel);
        form_tanggalKirimHotel = findViewById(R.id.form_tanggalKirimHotel);
        form_pembayaranHotel = findViewById(R.id.form_pembayaranHotel);
        form_cleaningHotel = findViewById(R.id.form_cleaningHotel);
        form_jenisHotel = findViewById(R.id.form_jenisHotel);
        form_catatanHotel = findViewById(R.id.form_catatanHotel);

        //Inisiasi Button
        button_tambahLaporanHotel = findViewById(R.id.button_tambahLaporanHotel);

        button_tambahLaporanHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNamaPengirimHotel = form_namaPengirimHotel.getText().toString();
                String getTanggalKirimHotel = form_tanggalKirimHotel.getText().toString();
                String getPembayaranHotel = form_pembayaranHotel.getText().toString();
                String getCleaningHotel = form_cleaningHotel.getText().toString();
                String getJenisHotel = form_jenisHotel.getText().toString();
                String getCatatanHotel = form_catatanHotel.getText().toString();

                if(getNamaPengirimHotel.isEmpty()){
                    form_namaPengirimHotel.setText("Nama Pengirim Harus Diisi!");
                }
                else if(getTanggalKirimHotel.isEmpty()){
                    form_tanggalKirimHotel.setText("Tanggal Kirim Harus Diisi!");
                }
                else if(getPembayaranHotel.isEmpty()){
                    form_pembayaranHotel.setText("Pembayaran Harus Diisi!");
                }
                else if(getCleaningHotel.isEmpty()){
                    form_cleaningHotel.setText("Cleaning harus Diisi!");
                }
                else if(getJenisHotel.isEmpty()){
                    form_jenisHotel.setText("Jenis Hotel Harus Diisi!");
                }
                else if(getCatatanHotel.isEmpty()){
                    form_catatanHotel.setText("Catatan Harus Diisi!");
                }

                else{
                    vibDatabaseHotel.child("Laporan Hotel").push().setValue(new ModelHotel(getNamaPengirimHotel, getTanggalKirimHotel, getPembayaranHotel, getCleaningHotel, getJenisHotel, getCatatanHotel)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(FormHotel.this, "Laporan Berhasil dikirim!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(FormHotel.this, HotelTampilan.class));
                            notification();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FormHotel.this, "Laporan Gagal dikirim!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
    //Notification Hotel
    private void notification(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n").setContentText("Villa Istana Bunga").setSmallIcon(R.drawable.ic_iconvila).setAutoCancel(true).setContentText("Data Hotel Berhasil dikirim!");
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }
}