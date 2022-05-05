package com.example.monumental_v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GreatWorksAdapter extends RecyclerView.Adapter<GreatWorksAdapter.MyViewHolder> {

    private final Onclick_Interface greatworksinterface;

    Context context;
    Activity activity;
    ArrayList book_id, book_title, book_author, book_year, book_excerpt;

    GreatWorksAdapter(Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author, ArrayList book_year, ArrayList book_excerpt, Onclick_Interface greatworksinterface){

        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_year = book_year;
        this.book_excerpt = book_excerpt;
        this.greatworksinterface = greatworksinterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater gwLiteratureInflater = LayoutInflater.from(context);
        View view = gwLiteratureInflater.inflate(R.layout.greatworks_items, parent, false);
        return new MyViewHolder(view, greatworksinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_year_txt.setText(String.valueOf(book_year.get(position)));

    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_txt, book_title_txt, book_author_txt, book_year_txt, book_excerpt_txt;

        public MyViewHolder(@NonNull View itemView, Onclick_Interface greatworksinterface) {
            super(itemView);

            //book_id_txt = itemView.findViewById(R.id.entry_id);
            book_title_txt = itemView.findViewById(R.id.entry_title);
            book_author_txt = itemView.findViewById(R.id.entry_author);
            book_year_txt = itemView.findViewById(R.id.entry_year);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (greatworksinterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            greatworksinterface.onItemClick(pos);
                        }
                    }
                }
            });


        }
    }
}
