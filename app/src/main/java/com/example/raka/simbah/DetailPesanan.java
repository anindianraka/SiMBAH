package com.example.raka.simbah;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailPesanan extends AppCompatActivity {

    TextView total,tanggal,JmlKg,Metode,catatan,Alamat,id,pakett;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);
        total= (TextView) findViewById(R.id.tv_jml);
        tanggal = (TextView) findViewById(R.id.tv_tgl);
        catatan = (TextView)findViewById(R.id.tv_ctt);
        JmlKg=(TextView)findViewById(R.id.textView5);
        Metode=(TextView)findViewById(R.id.tv_metode);
        Alamat=(TextView)findViewById(R.id.tv_alamat);
        pakett=(TextView)findViewById(R.id.tv_paket);

        //Menerima Intent
        Intent i=this.getIntent();

        //Menerima Data
        String Paket=i.getExtras().getString("paket");
        String jmlkg=i.getExtras().getString("jumlahKg");
        String ttl=i.getExtras().getString("Total");
        String tgl=i.getExtras().getString("Tanggal");
        String alamat=i.getExtras().getString("Alamat");
        String ctt = i.getExtras().getString("Catatan");
        String metode=i.getExtras().getString("metodeBayar");

        pakett.setText(Paket);
        JmlKg.setText(jmlkg);
        total.setText(ttl);
        tanggal.setText(tgl);
        Alamat.setText(alamat);
        catatan.setText(ctt);
        Metode.setText(metode);


    }
}

