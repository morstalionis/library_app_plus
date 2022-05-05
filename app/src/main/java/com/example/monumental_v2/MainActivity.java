package com.example.monumental_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton wonder_btn;
    ImageButton people_btn;
    ImageButton art_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wonder_btn = findViewById(R.id.wonder_btn);
        wonder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class x = Wonders.class;
                openimage_view(x);
            }
        });

        people_btn = findViewById(R.id.people_btn);
        people_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class x = People.class;
                openimage_view(x);
            }
        });

        art_btn = findViewById(R.id.art_btn);
        art_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class x = GreatWorks.class;
                openimage_view(x);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater bar_menu_inflater = getMenuInflater();
        bar_menu_inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.preferences:
                Class x = Preferences.class;
                openimage_view(x);
        }
        return super.onOptionsItemSelected(item);
    }

    public void openimage_view(Class x){
        Intent activity_intent = new Intent(this, x);
        startActivity(activity_intent);
    }

}