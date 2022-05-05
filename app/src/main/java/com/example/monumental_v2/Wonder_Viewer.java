package com.example.monumental_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Wonder_Viewer extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_wonder_viewer);

        String name = getIntent().getStringExtra("NAME");
        String quote = getIntent().getStringExtra("QUOTE");
        String desc = getIntent().getStringExtra("DESC");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView more_name = findViewById(R.id.more_name);
        TextView more_quote = findViewById(R.id.more_quote);
        TextView more_detail = findViewById(R.id.more_detail);
        ImageView more_image = findViewById(R.id.more_image);

        more_name.setText(name);
        more_quote.setText(quote);
        more_detail.setText(desc);
        more_image.setImageResource(image);

    }
}