package com.tr.newsappcent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class favsFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<String> basliklar,icerikler,resimler,yazarlar,tarihler,linkler;
    private favAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private TextView baslikfav;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_favs, container, false);

        rv=view.findViewById(R.id.rv);
        baslikfav=view.findViewById(R.id.baslikfav);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("favoriler");



        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));

        basliklar = new ArrayList<>();
        icerikler = new ArrayList<>();
        resimler = new ArrayList<>();
        yazarlar = new ArrayList<>();
        tarihler = new ArrayList<>();
        linkler = new ArrayList<>();






        adapter = new favAdapter(view.getContext(),resimler,basliklar,icerikler,tarihler,yazarlar,linkler);
        rv.setAdapter(adapter);


       Haberbaslat();




        return view;
    }
    public void Haberbaslat(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    basliklar.clear();
                    icerikler.clear();
                    resimler.clear();
                    yazarlar.clear();
                    tarihler.clear();
                    linkler.clear();

                    for (DataSnapshot d:dataSnapshot.getChildren()){

                    favClass f1 = d.getValue(favClass.class);

                    resimler.add(f1.getResim());
                    basliklar.add(f1.getBaslik());
                    icerikler.add(f1.getIcerik());
                    yazarlar.add(f1.getYazar());
                    tarihler.add(f1.getTarih());
                    linkler.add(f1.getLink());



                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });}
}