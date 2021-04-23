package com.tr.newsappcent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navi;
    private Fragment tempfragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi=findViewById(R.id.navi);







        getSupportFragmentManager().beginTransaction().add(R.id.fragmenttutucu,new newsFragment()).commit();

        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bir){
                    tempfragment = new newsFragment();
                }

                if (item.getItemId() == R.id.iki){
                    tempfragment = new favsFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmenttutucu,tempfragment).commit();
                return true;
            }
        });
    }


}
