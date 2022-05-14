package com.example.vibprojectmobile.Model;

public class ModelHotel {
    private String namaPengirimHotel, tanggalKirimHotel, pembayaranHotel, cleaningHotel, jenisHotel, catatanHotel, kunciHotel;


    public ModelHotel(){

    }

    public ModelHotel(String namaPengirimHotel, String tanggalKirimHotel, String pembayaranHotel, String cleaningHotel, String jenisHotel, String catatanHotel) {
        this.namaPengirimHotel = namaPengirimHotel;
        this.tanggalKirimHotel = tanggalKirimHotel;
        this.pembayaranHotel = pembayaranHotel;
        this.cleaningHotel = cleaningHotel;
        this.jenisHotel = jenisHotel;
        this.catatanHotel = catatanHotel;
    }

    public String getNamaPengirimHotel() {
        return namaPengirimHotel;
    }

    public void setNamaPengirimHotel(String namaPengirimHotel) {
        this.namaPengirimHotel = namaPengirimHotel;
    }

    public String getTanggalKirimHotel() {
        return tanggalKirimHotel;
    }

    public void setTanggalKirimHotel(String tanggalKirimHotel) {
        this.tanggalKirimHotel = tanggalKirimHotel;
    }

    public String getPembayaranHotel() {
        return pembayaranHotel;
    }

    public void setPembayaranHotel(String pembayaranHotel) {
        this.pembayaranHotel = pembayaranHotel;
    }

    public String getCleaningHotel() {
        return cleaningHotel;
    }

    public void setCleaningHotel(String cleaningHotel) {
        this.cleaningHotel = cleaningHotel;
    }

    public String getJenisHotel() {
        return jenisHotel;
    }

    public void setJenisHotel(String jenisHotel) {
        this.jenisHotel = jenisHotel;
    }

    public String getCatatanHotel() {
        return catatanHotel;
    }

    public void setCatatanHotel(String catatanHotel) {
        this.catatanHotel = catatanHotel;
    }

    public String getKunciHotel() {
        return kunciHotel;
    }

    public void setKunciHotel(String kunciHotel) {
        this.kunciHotel = kunciHotel;
    }
}
