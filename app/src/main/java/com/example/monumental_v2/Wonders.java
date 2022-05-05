package com.example.monumental_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Wonders extends AppCompatActivity implements Onclick_Interface {

    ArrayList<Wonders_Model> wondersModels = new ArrayList<>();

    int[] wonderImages = {R.drawable.wonder_01, R.drawable.wonder_02, R.drawable.wonder_03, R.drawable.wonder_04, R.drawable.wonder_05, R.drawable.wonder_06, R.drawable.wonder_07, R.drawable.wonder_08, R.drawable.wonder_09, R.drawable.wonder_10, R.drawable.wonder_11, R.drawable.wonder_12, R.drawable.wonder_13, R.drawable.wonder_14, R.drawable.wonder_15, R.drawable.wonder_16, R.drawable.wonder_17, R.drawable.wonder_18, R.drawable.wonder_19, R.drawable.wonder_20, R.drawable.wonder_21, R.drawable.wonder_22, R.drawable.wonder_23, R.drawable.wonder_24, R.drawable.wonder_25, R.drawable.wonder_26, R.drawable.wonder_27, R.drawable.wonder_28, R.drawable.wonder_29, R.drawable.wonder_30, R.drawable.wonder_31, R.drawable.wonder_32, R.drawable.wonder_33, R.drawable.wonder_34};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        RecyclerView recyclerview = findViewById(R.id.wonder_cycler);

        setWondersModels();

        WonderAdapter adapter = new WonderAdapter(this, wondersModels, this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setWondersModels(){
        String[] wonderNames = getResources().getStringArray(R.array.world_wonders);
        String[] wonder_quotes = getResources().getStringArray(R.array.world_wonders_quote);
        String[] wonder_details = getResources().getStringArray(R.array.world_wonders_desc);

        for (int i = 0; i < wonderNames.length; i++) {
            wondersModels.add(new Wonders_Model(wonderNames[i], wonder_details[i], wonder_quotes[i],  wonderImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Wonders.this, Wonder_Viewer.class);

        intent.putExtra("NAME", wondersModels.get(position).getWondersName());
        intent.putExtra("QUOTE", wondersModels.get(position).getWonder_quotes());
        intent.putExtra("DESC", wondersModels.get(position).getWonder_details());
        intent.putExtra("IMAGE", wondersModels.get(position).getWonderImage());

        startActivity(intent);
    }
}