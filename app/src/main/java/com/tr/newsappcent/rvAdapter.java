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

import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder> {

    private Context mcontext;
    List<Articles> articles;

    public rvAdapter(Context mcontext, List<Articles> articles) {
        this.mcontext = mcontext;
        this.articles = articles;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Articles x = articles.get(position);
        holder.baslik.setText(x.getTitle());
        holder.tarih.setText(x.getPublishedAt());
        holder.icerik.setText(x.getDescription());

        holder.kaynak.setText(x.getAuthor());


        final String imagelink= x.getUrlToImage();
        Picasso.with(mcontext).load(imagelink).into(holder.resim);

        final String baslik = x.getTitle();
        final String tarih = x.getPublishedAt();
        final String yazar = x.getAuthor();
        final String link = x.getUrl();
        final String aciklama = x.getContent();


        holder.cardhaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,newsDetay.class);
                intent.putExtra("Baslik",baslik);
                intent.putExtra("Resim",imagelink);
                intent.putExtra("Tarih",tarih);
                intent.putExtra("Yazar",yazar);
                intent.putExtra("Link",link);
                intent.putExtra("Aciklama",aciklama);

                mcontext.startActivity(intent);


            }
        });





    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


}
