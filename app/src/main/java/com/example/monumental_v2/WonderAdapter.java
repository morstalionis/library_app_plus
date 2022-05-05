package com.example.monumental_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WonderAdapter extends RecyclerView.Adapter<WonderAdapter.MyViewHolder> {

    private final Onclick_Interface wonderInterface;

    Context context;
    ArrayList<Wonders_Model> wondersModels;

    public WonderAdapter(Context context, ArrayList<Wonders_Model> wondersModels, Onclick_Interface wonderInterface){
        this.context = context;
        this.wondersModels = wondersModels;
        this.wonderInterface = wonderInterface;
    }

    @NonNull
    @Override
    public WonderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wonder_items, parent, false);
        return new  WonderAdapter.MyViewHolder(view, wonderInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull WonderAdapter.MyViewHolder holder, int position) {

        holder.txtview.setText(wondersModels.get(position).getWondersName());
        holder.imgview.setImageResource(wondersModels.get(position).getWonderImage());

    }

    @Override
    public int getItemCount() {
        return wondersModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgview;
        TextView txtview;

        public MyViewHolder(@NonNull View itemView, Onclick_Interface wonderInterface) {
            super(itemView);

            imgview = itemView.findViewById(R.id.imageView);
            txtview = itemView.findViewById(R.id.wonder_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (wonderInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            wonderInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
