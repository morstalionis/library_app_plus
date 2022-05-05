package com.example.monumental_v2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Add_Entry_Dialog extends AppCompatDialogFragment {

    Button save_button;
    EditText edit_title, edit_author, edit_year, edit_excerpt;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_entry, null);

        builder.setView(view);

        edit_title = view.findViewById(R.id.update_title);
        edit_author = view.findViewById(R.id.update_author);
        edit_year = view.findViewById(R.id.update_year);
        edit_excerpt = view.findViewById(R.id.update_excerpt);

        save_button = view.findViewById(R.id.update_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GreatWorks_DB_Literature mydb = new GreatWorks_DB_Literature(getContext());
                mydb.addlit(edit_title.getText().toString().trim(), edit_author.getText().toString().trim(), edit_year.getText().toString().trim(), edit_excerpt.getText().toString().trim());
                dismiss();
            }
        });

        return builder.create();
    }
}
