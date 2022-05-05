package com.example.monumental_v2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.monumental_v2.ui.main.SectionsPagerAdapter;
import com.example.monumental_v2.databinding.ActivityGreatworksBinding;

import java.util.ArrayList;

public class GreatWorks extends AppCompatActivity{

    private ActivityGreatworksBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGreatworksBinding.inflate(getLayoutInflater());
        setTitle("GREAT WORKS");
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;
        FloatingActionButton refresh = binding.refreshBtn;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectentry();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh = new Intent(GreatWorks.this, GreatWorks.class);
                startActivity(refresh);
            }
        });

    }

    private void selectentry() {
        Select_Entry_Dialog select_entry_dialog = new Select_Entry_Dialog();
        select_entry_dialog.show(getSupportFragmentManager(), "Select");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater bar_menu_inflater = getMenuInflater();
        bar_menu_inflater.inflate(R.menu.gw_menu, menu);
        return true;
    }

}