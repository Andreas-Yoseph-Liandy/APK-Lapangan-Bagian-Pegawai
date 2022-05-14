package com.example.vibprojectmobile.Form;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.example.vibprojectmobile.Model.ModelVilla;
import com.example.vibprojectmobile.R;
import com.example.vibprojectmobile.Tampilan.VillaTampilan;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FormVilla extends AppCompatActivity {
    EditText form_namaPengirim, form_tanggalKirim, form_pembayaran, form_cleaning, form_jenisVilla, form_catatan;
    Button button_tambahLaporan;
    DatabaseReference vibDatabase = FirebaseDatabase.getInstance().getReference();
    int counter = 0;
    ModelVilla mVilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_villa);

        //Inisiasi Form
        form_namaPengirim = findViewById(R.id.form_namaPengirim);
        form_tanggalKirim = findViewById(R.id.form_tanggalKirim);
        form_pembayaran = findViewById(R.id.form_pembayaran);
        form_cleaning = findViewById(R.id.form_cleaning);
        form_jenisVilla = findViewById(R.id.form_jenisVilla);
        form_catatan = findViewById(R.id.form_catatan);

        //Inisiasi Button
        button_tambahLaporan = findViewById(R.id.button_tambahLaporan);

        button_tambahLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNamaPengirim = form_namaPengirim.getText().toString();
                String getTanggalKirim = form_tanggalKirim.getText().toString();
                String getPembayaran = form_pembayaran.getText().toString();
                String getCleaning = form_cleaning.getText().toString();
                String getJenisVilla = form_jenisVilla.getText().toString();
                String getCatatan = form_catatan.getText().toString();

                if (getNamaPengirim.isEmpty()) {
                    form_namaPengirim.setText("Nama Pengirim Harus Diisi!");
                } else if (getTanggalKirim.isEmpty()) {
                    form_tanggalKirim.setText("Tanggal Kirim Harus Diisi!");
                } else if (getPembayaran.isEmpty()) {
                    form_pembayaran.setText("Pembayaran Harus Diisi!");
                } else if (getCleaning.isEmpty()) {
                    form_cleaning.setText("Cleaning harus Diisi!");
                } else if (getJenisVilla.isEmpty()) {
                    form_jenisVilla.setText("Jenis Vila Harus Diisi!");
                } else if (getCatatan.isEmpty()) {
                    form_catatan.setText("Catatan Harus Diisi!");
                }
                else {
                    vibDatabase.child("Laporan Vila").push().setValue(new ModelVilla(getNamaPengirim, getTanggalKirim, getPembayaran, getCleaning, getJenisVilla, getCatatan)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(FormVilla.this, "Laporan Berhasil dikirim!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(FormVilla.this, VillaTampilan.class));
                            notification();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FormVilla.this, "Laporan Gagal dikirim!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });
    }

        //Notification Vila
       private void notification(){
           if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
               NotificationChannel channel = new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);
               NotificationManager manager = getSystemService(NotificationManager.class);
               manager.createNotificationChannel(channel);
           }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n").setContentText("Villa Istana Bunga").setSmallIcon(R.drawable.ic_iconvila).setAutoCancel(true).setContentText("Data Vila Berhasil dikirim");
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(999, builder.build());
       }
}







