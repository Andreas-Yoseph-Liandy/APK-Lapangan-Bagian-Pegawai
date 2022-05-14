package com.example.vibprojectmobile.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vibprojectmobile.Model.ModelBamboo;
import com.example.vibprojectmobile.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterBamboo extends RecyclerView.Adapter<AdapterBamboo.HolderBamboo>{
    private List<ModelBamboo> mBamboo;
    private Activity activityBamboo;
    DatabaseReference vibDatabase = FirebaseDatabase.getInstance().getReference();

    public AdapterBamboo(List<ModelBamboo> mBamboo, Activity activityBamboo){
        this.mBamboo = mBamboo;
        this.activityBamboo = activityBamboo;
    }

    @NonNull
    @Override
    public AdapterBamboo.HolderBamboo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItemBamboo = inflater.inflate(R.layout.bamboo_tampilan_card, parent, false);
        return new AdapterBamboo.HolderBamboo(viewItemBamboo);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBamboo.HolderBamboo holder, int position) {
        final ModelBamboo dataBamboo = mBamboo.get(position);
        holder.nama_pengirimBamboo.setText("Nama Pengirim : "+dataBamboo.getNamaPengirimBamboo());
        holder.tanggal_kirimBamboo.setText("Tanggal Kirim :"+dataBamboo.getTanggalKirimBamboo());
        holder.pembayaranBamboo.setText("Pembayaran :"+dataBamboo.getPembayaranBamboo());
        holder.cleaningBamboo.setText("Cleaning :"+dataBamboo.getCleaningBamboo());
        holder.jenis_bamboo.setText("Jenis Bamboo :"+dataBamboo.getJenisBamboo());
        holder.catatanBamboo.setText("Catatan :"+dataBamboo.getCatatanBamboo());

    }

    @Override
    public int getItemCount() {
        return mBamboo.size();
    }

    public class HolderBamboo extends RecyclerView.ViewHolder {
        TextView nama_pengirimBamboo, tanggal_kirimBamboo, pembayaranBamboo, cleaningBamboo, jenis_bamboo, catatanBamboo;
        CardView cardViewBamboo;
        public HolderBamboo(@NonNull View itemView) {
            super(itemView);
            nama_pengirimBamboo = itemView.findViewById(R.id.nama_pengirimBamboo);
            tanggal_kirimBamboo = itemView.findViewById(R.id.tanggal_kirimBamboo);
            pembayaranBamboo = itemView.findViewById(R.id.pembayaranBamboo);
            cleaningBamboo= itemView.findViewById(R.id.cleaningBamboo);
            jenis_bamboo = itemView.findViewById(R.id.jenis_bamboo);
            catatanBamboo = itemView.findViewById(R.id.catatanBamboo);

            cardViewBamboo = itemView.findViewById(R.id.cardViewBamboo);
        }
    }
}
