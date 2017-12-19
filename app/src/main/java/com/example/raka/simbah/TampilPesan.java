package com.example.raka.simbah;

/**
 * Created by RAKA on 12/15/2017.
 */

public class  TampilPesan {
    private String tanggal,hargaTotal,Id,jumlahKg,metodeBayar,catatan,alamat,paket;

    public TampilPesan(String tanggal, String hargaTotal, String id, String jumlahKg, String metodeBayar, String catatan, String alamat, String paket) {
        this.tanggal = tanggal;
        this.hargaTotal = hargaTotal;
        Id = id;
        this.jumlahKg = jumlahKg;
        this.metodeBayar = metodeBayar;
        this.catatan = catatan;
        this.alamat = alamat;
        this.paket = paket;
    }


    public TampilPesan() {
    }

    public String getPaket() {
        return paket;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getHargaTotal() {
        return hargaTotal;
    }

    public String getId() {
        return Id;
    }

    public String getJumlahKg() {
        return jumlahKg;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public String getCatatan() {
        return catatan;
    }

    public String getAlamat() {
        return alamat;
    }
}
