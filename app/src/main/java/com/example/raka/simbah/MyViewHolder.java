package com.example.raka.simbah;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RAKA on 12/18/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView Tanggal,Total,Catatan,Id,jmlKg,metode,alamat,paket;
    ItemClickListener itemClickListener;
    public MyViewHolder(View itemView) {
        super(itemView);
        Tanggal= (TextView) itemView.findViewById(R.id.tv_tanggal);
        Total= (TextView) itemView.findViewById(R.id.tv_total);
        Catatan=(TextView) itemView.findViewById(R.id.tv_catatan);
        jmlKg=(TextView)itemView.findViewById(R.id.tv_jmlkg);
        metode=(TextView)itemView.findViewById(R.id.tv_metode);
        alamat=(TextView)itemView.findViewById(R.id.tv_alamat);
        paket=(TextView)itemView.findViewById(R.id.tv_paket);

        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}