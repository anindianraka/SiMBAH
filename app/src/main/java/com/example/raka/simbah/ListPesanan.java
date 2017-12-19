package com.example.raka.simbah;

/**
 * Created by RAKA on 12/15/2017.
 */

public class ListPesanan {
    private String Paket,JumlahKg,Catatan,Tanggal,Alamat,MetodeBayar,HargaTotal,Id;

    public ListPesanan(){

    }

    public ListPesanan(String paket, String jumlahKg, String catatan, String tanggal, String alamat, String metodeBayar, String hargaTotal,String id) {
        Paket = paket;
        JumlahKg = jumlahKg;
        Catatan = catatan;
        Tanggal = tanggal;
        Alamat = alamat;
        MetodeBayar = metodeBayar;
        HargaTotal = hargaTotal;
        Id=id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPaket(String paket) {
        Paket = paket;
    }

    public void setJumlahKg(String jumlahKg) {
        JumlahKg = jumlahKg;
    }

    public void setCatatan(String catatan) {
        Catatan = catatan;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public void setMetodeBayar(String metodeBayar) {
        MetodeBayar = metodeBayar;
    }

    public void setHargaTotal(String hargaTotal) {
        HargaTotal = hargaTotal;
    }

    public String getPaket() {
        return Paket;
    }

    public String getJumlahKg() {
        return JumlahKg;
    }

    public String getCatatan() {
        return Catatan;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getMetodeBayar() {
        return MetodeBayar;
    }

    public String getHargaTotal() {
        return HargaTotal;
    }
}
