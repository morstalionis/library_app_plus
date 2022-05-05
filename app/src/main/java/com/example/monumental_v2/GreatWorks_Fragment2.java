package com.example.monumental_v2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monumental_v2.databinding.ActivityGreatworksBinding;

import java.util.ArrayList;

public class GreatWorks_Fragment2 extends Fragment implements Onclick_Interface {

    GreatWorksAdapter greatWorksAdapter;
    GreatWorks_DB_Literature gwdb;
    RecyclerView recyclerView;
    ArrayList<String> book_id, book_title, book_author, book_year, book_excerpt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.activity_greatworks_frag2, container, false);

        recyclerView = view.findViewById(R.id.litcycler);

        gwdb = new GreatWorks_DB_Literature(getContext());
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_year = new ArrayList<>();
        book_excerpt = new ArrayList<>();

        greatWorksAdapter = new GreatWorksAdapter(getContext(), book_id, book_title, book_author, book_year, book_excerpt, this);

        storedata();

        recyclerView.setAdapter(greatWorksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    void storedata(){
        Cursor cursor = gwdb.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No Entries", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_year.add(cursor.getString(3));
                book_excerpt.add(cursor.getString(4));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), Read_Lit_Entry.class);

        intent.putExtra("ID", book_id.get(position));
        intent.putExtra("TITLE", book_title.get(position));
        intent.putExtra("AUTHOR", book_author.get(position));
        intent.putExtra("YEAR", book_year.get(position));
        intent.putExtra("EXCERPT", book_excerpt.get(position));

        startActivity(intent);

    }



}
