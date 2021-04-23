package com.tr.newsappcent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class favAdapter extends RecyclerView.Adapter<favAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<String> resimlist,basliklist,iceriklist,tarihlist,yazarlist,linklist;

    public favAdapter(Context mcontext, ArrayList<String> resimlist, ArrayList<String> basliklist, ArrayList<String> iceriklist, ArrayList<String> tarihlist, ArrayList<String> yazarlist,ArrayList<String> linklist) {
        this.mcontext = mcontext;
        this.resimlist = resimlist;
        this.basliklist = basliklist;
        this.iceriklist = iceriklist;
        this.tarihlist = tarihlist;
        this.yazarlist = yazarlist;
        this.linklist = linklist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView resim,alt,resimyazar,resimtarih;
        TextView baslik,icerik,tarih,kaynak;
        CardView cardhaber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resim=itemView.findViewById(R.id.resim);
            baslik=itemView.findViewById(R.id.baslik);
            icerik=itemView.findViewById(R.id.icerik);
            tarih=itemView.findViewById(R.id.tarih);
            alt=itemView.findViewById(R.id.alt);
            cardhaber=itemView.findViewById(R.id.cardhaber);

            resimyazar=itemView.findViewById(R.id.resimyazar);
            resimtarih=itemView.findViewById(R.id.resimtarih);
            kaynak=itemView.findViewById(R.id.kaynak);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_news,parent,false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull favAdapter.ViewHolder holder, int position) {

        final String baslik = basliklist.get(position);
        holder.baslik.setText(baslik);
        final String icerik = iceriklist.get(position);
        holder.icerik.setText(icerik);
        final String tarih = tarihlist.get(position);
        holder.tarih.setText(tarih);
        final String yazar = yazarlist.get(position);
        holder.kaynak.setText(yazar);

        final String link = linklist.get(position);



        final String imagelink= resimlist.get(position);
        Picasso.with(mcontext).load(imagelink).into(holder.resim);

        holder.cardhaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,favDetay.class);
                intent.putExtra("Baslik",baslik);
                intent.putExtra("Resim",imagelink);
                intent.putExtra("Tarih",tarih);
                intent.putExtra("Yazar",yazar);
                intent.putExtra("Aciklama",icerik);
                intent.putExtra("Link",link);

                mcontext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return basliklist.size();
    }


}
