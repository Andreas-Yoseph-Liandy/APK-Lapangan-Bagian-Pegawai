package com.example.vibprojectmobile.Model;

public class ModelVilla {
    private String namaPengirim, tanggalKirim, pembayaran, cleaning, jenisVilla, catatan, kunci;


    public ModelVilla(){

    }

    public ModelVilla(String namaPengirim, String tanggalKirim, String pembayaran, String cleaning, String jenisVilla, String catatan) {
        this.namaPengirim = namaPengirim;
        this.tanggalKirim = tanggalKirim;
        this.pembayaran = pembayaran;
        this.cleaning = cleaning;
        this.jenisVilla = jenisVilla;
        this.catatan = catatan;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getTanggalKirim() {
        return tanggalKirim;
    }

    public void setTanggalKirim(String tanggalKirim) {
        this.tanggalKirim = tanggalKirim;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    public String getJenisVilla() {
        return jenisVilla;
    }

    public void setJenisVilla(String jenisVilla) {
        this.jenisVilla = jenisVilla;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

}
