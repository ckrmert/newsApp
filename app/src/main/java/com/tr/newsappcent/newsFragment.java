package com.tr.newsappcent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newsFragment extends Fragment {

    private RecyclerView rv;
    private Button button;
    private TextView title;
    private EditText edittext;
    private rvAdapter adapter;
    List<Articles> articles = new ArrayList<>();
    final String API_KEY = "be5010a50fcd4f0bb07b15ac3e68a8ef";
    final String keyy="besiktas";
    final String pagee="1";



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_haber,container,false);



        rv = view.findViewById(R.id.rv);
        button= view.findViewById(R.id.button);
        edittext=view.findViewById(R.id.edittext);
        title=view.findViewById(R.id.title);


        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        retrieveJson(keyy,pagee,API_KEY,"besiktas");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edittext.getText().toString().equals("")){

                    retrieveJson(keyy,pagee,API_KEY,edittext.getText().toString());
                }
                else{
                    retrieveJson(keyy,pagee,API_KEY,"");
                }
            }
        });





        return view;

}

public void retrieveJson(String key,String page,String apikey,String query){

        Call<headline> call;

        if (!edittext.getText().toString().equals("")){
            call = apiClient.getInstance().getApi().getSearched(query,apikey);
        }else{

            call = apiClient.getInstance().getApi().getHeadlines(key,page,apikey);
        }


    call.enqueue(new Callback<headline>() {
        @Override
        public void onResponse(Call<headline> call, Response<headline> response) {
            if (response.isSuccessful() && response.body().getArticles() != null){
                articles.clear();
                articles = response.body().getArticles();
                adapter=new rvAdapter(getContext(),articles);
                rv.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<headline> call, Throwable t) {

        }
    });
}

}
