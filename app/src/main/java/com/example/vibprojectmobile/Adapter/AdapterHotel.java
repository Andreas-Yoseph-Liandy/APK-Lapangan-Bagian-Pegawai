package com.example.vibprojectmobile.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vibprojectmobile.Model.ModelHotel;
import com.example.vibprojectmobile.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterHotel extends RecyclerView.Adapter<AdapterHotel.HolderHotel>{
    private List<ModelHotel> mHotel;
    private Activity activityHotel;
    DatabaseReference vibDatabase = FirebaseDatabase.getInstance().getReference();


    public AdapterHotel(List<ModelHotel> mHotel, Activity activityHotel){
        this.mHotel = mHotel;
        this.activityHotel = activityHotel;
    }


    @NonNull
    @Override
    public AdapterHotel.HolderHotel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItemHotel = inflater.inflate(R.layout.hotel_tampilan_card, parent, false);
        return new HolderHotel(viewItemHotel);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHotel.HolderHotel holder, int position) {
        final ModelHotel dataHotel = mHotel.get(position);
        holder.nama_pengirimHotel.setText("Nama Pengirim : "+dataHotel.getNamaPengirimHotel());
        holder.tanggal_kirimHotel.setText("Tanggal Kirim :"+dataHotel.getTanggalKirimHotel());
        holder.pembayaranHotel.setText("Pembayaran :"+dataHotel.getPembayaranHotel());
        holder.cleaningHotel.setText("Cleaning :"+dataHotel.getCleaningHotel());
        holder.jenis_hotel.setText("Jenis Hotel :"+dataHotel.getJenisHotel());
        holder.catatanHotel.setText("Catatan :"+dataHotel.getCatatanHotel());
    }

    @Override
    public int getItemCount() {
        return mHotel.size();
    }

    public class HolderHotel extends RecyclerView.ViewHolder {
        TextView nama_pengirimHotel, tanggal_kirimHotel, pembayaranHotel, cleaningHotel, jenis_hotel, catatanHotel;
        CardView cardViewHotel;
        public HolderHotel(@NonNull View itemView) {
            super(itemView);
            nama_pengirimHotel = itemView.findViewById(R.id.nama_pengirimHotel);
            tanggal_kirimHotel = itemView.findViewById(R.id.tanggal_kirimHotel);
            pembayaranHotel = itemView.findViewById(R.id.pembayaranHotel);
            cleaningHotel = itemView.findViewById(R.id.cleaningHotel);
            jenis_hotel = itemView.findViewById(R.id.jenis_hotel);
            catatanHotel = itemView.findViewById(R.id.catatanHotel);

            cardViewHotel = itemView.findViewById(R.id.cardViewHotel);
        }
    }
}
