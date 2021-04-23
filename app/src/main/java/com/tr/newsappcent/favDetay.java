package com.tr.newsappcent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class favDetay extends AppCompatActivity {

    private TextView detaytext,tarihh,yazarr,aciklamaa,kaynakk;
    private ImageView resimm,alt,yazarresim,tarhresim;
    private Button button,paylas,fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_detay);

        detaytext = findViewById(R.id.detaytext);
        resimm = findViewById(R.id.resim);
        tarihh=findViewById(R.id.tarih);
        yazarr=findViewById(R.id.yazar);
        aciklamaa=findViewById(R.id.aciklama);
        kaynakk=findViewById(R.id.kaynak);
        alt=findViewById(R.id.alt);
        yazarresim=findViewById(R.id.yazarresim);
        tarhresim=findViewById(R.id.tarihresim);
        button=findViewById(R.id.kaynak);
        paylas=findViewById(R.id.paylas);
        fav=findViewById(R.id.fav);

        Intent intentt = getIntent();
        final String baslikkk = intentt.getExtras().getString("Baslik");
        final String tarih = intentt.getExtras().getString("Tarih");
        final String yazar = intentt.getExtras().getString("Yazar");
        final String aciklama = intentt.getExtras().getString("Aciklama");
        final String resim = intentt.getExtras().getString("Resim");
        final String link = intentt.getExtras().getString("Link");



        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent= new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String sharebody=link;
                shareintent.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(shareintent,"SHARE WITH"));

            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Already in your favorite list.",Toast.LENGTH_LONG).show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent=new Intent(favDetay.this,favwebActivity.class);

                newintent.putExtra("Link",link);

                startActivity(newintent);

            }
        });



        detaytext.setText(baslikkk);
        tarihh.setText(tarih);
        yazarr.setText(yazar);
        aciklamaa.setText(aciklama);

        Picasso.with(this).load(resim).into(resimm);


    }
}