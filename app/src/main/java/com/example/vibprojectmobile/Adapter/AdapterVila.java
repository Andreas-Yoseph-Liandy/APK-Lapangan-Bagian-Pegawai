package com.example.vibprojectmobile.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vibprojectmobile.Model.ModelVilla;
import com.example.vibprojectmobile.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterVila extends RecyclerView.Adapter<AdapterVila.HolderVilla> {
    private List<ModelVilla> mVilla;
    private Activity activityVilla;
    DatabaseReference vibDatabase = FirebaseDatabase.getInstance().getReference();


    public AdapterVila(List<ModelVilla> mVilla, Activity activityVilla){
        this.mVilla = mVilla;
        this.activityVilla = activityVilla;
    }


    @NonNull
    @Override
    public HolderVilla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.villa_tampilan_card, parent, false);
        return new HolderVilla(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderVilla holder, int position) {
        final ModelVilla dataVilla = mVilla.get(position);
        holder.nama_pengirim.setText("Nama Pengirim : "+dataVilla.getNamaPengirim());
        holder.tanggal_kirim.setText("Tanggal Kirim :"+dataVilla.getTanggalKirim());
        holder.pembayaran.setText("Pembayaran :"+dataVilla.getPembayaran());
        holder.cleaning.setText("Cleaning :"+dataVilla.getCleaning());
        holder.jenis_vila.setText("Jenis Vila :"+dataVilla.getJenisVilla());
        holder.catatan.setText("Catatan :"+dataVilla.getCatatan());

    }

    @Override
    public int getItemCount() {
        return mVilla.size();
    }

    public class HolderVilla extends RecyclerView.ViewHolder {
        TextView nama_pengirim, tanggal_kirim, pembayaran, cleaning, jenis_vila, catatan;
        CardView cardViewVilla;
        public HolderVilla(@NonNull View itemView) {
            super(itemView);
            nama_pengirim = itemView.findViewById(R.id.nama_pengirim);
            tanggal_kirim = itemView.findViewById(R.id.tanggal_kirim);
            pembayaran = itemView.findViewById(R.id.pembayaran);
            cleaning = itemView.findViewById(R.id.cleaning);
            jenis_vila = itemView.findViewById(R.id.jenis_vila);
            catatan = itemView.findViewById(R.id.catatan);

            cardViewVilla = itemView.findViewById(R.id.cardViewVilla);

        }
    }
}
