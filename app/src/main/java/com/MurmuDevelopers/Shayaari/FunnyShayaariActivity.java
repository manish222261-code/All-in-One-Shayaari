package com.MurmuDevelopers.Shayaari;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FunnyShayaariActivity extends AppCompatActivity {

    private String json = "";
    private final String funny = "";

    private  ArrayList<HashMap<String, Object>> map = new ArrayList<>();

    private final Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funny_shayaari);

        AppBarLayout _app_bar = findViewById(R.id._app_bar);
        CoordinatorLayout _coordinator = findViewById(R.id._coordinator);
        Toolbar _toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });
        LinearLayout linear1 = findViewById(R.id.linear1);
        ScrollView vscroll1 = findViewById(R.id.vscroll1);
        RecyclerView recyclerview1 = findViewById(R.id.recyclerview1);

        setTitle("Funny Shayaari");
        try {
            java.io.InputStream inputstream1 = getAssets().open("dosti.json");
            int size = inputstream1.available();
            byte[] buffer = new byte[size];
            inputstream1.read(buffer);
            inputstream1.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception ignored) {
        }
        map = new Gson().fromJson(json, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
        recyclerview1.setAdapter(new Recyclerview1Adapter(map));
        recyclerview1.setLayoutManager(new LinearLayoutManager(this));


    }


        public class Recyclerview1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

            ArrayList<HashMap<String, Object>> data;

            public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> arr) {
                data = arr;
        }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = getLayoutInflater();
                @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.shayaari, null);
                RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                v.setLayoutParams(lp);
                return new ViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
                View view = holder.itemView;

                final LinearLayout linear1 = view.findViewById(R.id.linear1);
                final androidx.cardview.widget.CardView cardview1 = view.findViewById(R.id.cardview1);
                final TextView textview1 = view.findViewById(R.id.textview1);

                textview1.setText(Objects.requireNonNull(map.get((int) position).get("Uname")).toString());
                cardview1.setCardBackgroundColor(0xFFF0F1A5);
                cardview1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View _view) {
                        intent.putExtra("key", Objects.requireNonNull(map.get((int) position).get("Uname")).toString());
                        intent.setClass(getApplicationContext(), ShowShayaariActivity.class);
                        startActivity(intent);
                     }
                });
            }


            @Override
            public int getItemCount() {
                return data.size();
            }

            public class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(View v) {
                    super(v);
                }
            }
        }

    }