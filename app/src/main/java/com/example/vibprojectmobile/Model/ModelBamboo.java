package com.example.vibprojectmobile.Model;

public class ModelBamboo {
    private String namaPengirimBamboo, tanggalKirimBamboo, pembayaranBamboo, cleaningBamboo, jenisBamboo, catatanBamboo, kunciBamboo;

    public ModelBamboo(){

    }

    public ModelBamboo(String namaPengirimBamboo, String tanggalKirimBamboo, String pembayaranBamboo, String cleaningBamboo, String jenisBamboo, String catatanBamboo) {
        this.namaPengirimBamboo = namaPengirimBamboo;
        this.tanggalKirimBamboo = tanggalKirimBamboo;
        this.pembayaranBamboo = pembayaranBamboo;
        this.cleaningBamboo = cleaningBamboo;
        this.jenisBamboo = jenisBamboo;
        this.catatanBamboo = catatanBamboo;
    }

    public String getNamaPengirimBamboo() {
        return namaPengirimBamboo;
    }

    public void setNamaPengirimBamboo(String namaPengirimBamboo) {
        this.namaPengirimBamboo = namaPengirimBamboo;
    }

    public String getTanggalKirimBamboo() {
        return tanggalKirimBamboo;
    }

    public void setTanggalKirimBamboo(String tanggalKirimBamboo) {
        this.tanggalKirimBamboo = tanggalKirimBamboo;
    }

    public String getPembayaranBamboo() {
        return pembayaranBamboo;
    }

    public void setPembayaranBamboo(String pembayaranBamboo) {
        this.pembayaranBamboo = pembayaranBamboo;
    }

    public String getCleaningBamboo() {
        return cleaningBamboo;
    }

    public void setCleaningBamboo(String cleaningBamboo) {
        this.cleaningBamboo = cleaningBamboo;
    }

    public String getJenisBamboo() {
        return jenisBamboo;
    }

    public void setJenisBamboo(String jenisBamboo) {
        this.jenisBamboo = jenisBamboo;
    }

    public String getCatatanBamboo() {
        return catatanBamboo;
    }

    public void setCatatanBamboo(String catatanBamboo) {
        this.catatanBamboo = catatanBamboo;
    }

    public String getKunciBamboo() {
        return kunciBamboo;
    }

    public void setKunciBamboo(String kunciBamboo) {
        this.kunciBamboo = kunciBamboo;
    }
}
