package com.example.raka.simbah;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAKA on 12/17/2017.
 */

public class AdapterHistory extends RecyclerView.Adapter<MyViewHolder>{

    Context c;
    ArrayList<TampilPesan> spacecrafts;
    public AdapterHistory(Context c, ArrayList<TampilPesan> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(c).inflate(R.layout.recycleview_history,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final  TampilPesan s=spacecrafts.get(position);
        holder.paket.setText(s.getPaket());
        holder.jmlKg.setText(s.getJumlahKg());
        holder.Total.setText(s.getHargaTotal());
        holder.Tanggal.setText(s.getTanggal());
        holder.alamat.setText(s.getAlamat());
        holder.Catatan.setText(s.getCatatan());
        holder.metode.setText(s.getMetodeBayar());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(s.getPaket(),s.getJumlahKg(),s.getHargaTotal(),s.getTanggal(),s.getAlamat(),s.getCatatan(),s.getMetodeBayar());
            }
        });
    }



    public int getItemCount() {
        return spacecrafts.size();
    }
    //OPEN DETAIL ACTIVITY
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,DetailPesanan.class);
        i.putExtra("paket",details[0]);
        i.putExtra("jumlahKg",details[1]);
        i.putExtra("Total",details[2]);
        i.putExtra("Tanggal",details[3]);
        i.putExtra("Alamat",details[4]);
        i.putExtra("Catatan",details[5]);
        i.putExtra("metodeBayar",details[6]);

        c.startActivity(i);
    }

}

