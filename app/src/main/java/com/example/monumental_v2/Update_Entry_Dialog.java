package com.example.monumental_v2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Update_Entry_Dialog extends AppCompatDialogFragment {

    TextView updt_title;
    TextView updt_year;
    TextView updt_author;
    TextView updt_excerpt;
    Button updt_save;
    Button delete;
    Dialog dialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_update_entry, null);


        Bundle bundle = getArguments();

        String holder_id = bundle.getString("ID", "");
        String holder_title = bundle.getString("TITLE", "");
        String holder_year = bundle.getString("YEAR", "");
        String holder_author = bundle.getString("AUTHOR", "");
        String holder_excerpt = bundle.getString("EXCERPT", "");

        updt_title = (TextView) view.findViewById(R.id.update_title);
        updt_year = (TextView) view.findViewById(R.id.update_year);
        updt_author = (TextView) view.findViewById(R.id.update_author);
        updt_excerpt = (TextView) view.findViewById(R.id.update_excerpt);
        updt_save = (Button) view.findViewById(R.id.update_button);
        delete  = (Button) view.findViewById(R.id.delete_entry_btn);

        updt_title.setText(holder_title);
        updt_year.setText(holder_year);
        updt_author.setText(holder_author);
        updt_excerpt.setText(holder_excerpt);

        updt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String setter_id = holder_id;
                String setter_title = updt_title.getText().toString().trim();
                String setter_author = updt_author.getText().toString().trim();
                String setter_year = updt_year.getText().toString().trim();
                String setter_excerpt = updt_excerpt.getText().toString().trim();

                GreatWorks_DB_Literature gwDB = new GreatWorks_DB_Literature(getContext());
                gwDB.updateData(setter_id, setter_title, setter_author, setter_year, setter_excerpt);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);

        return builder.create();
    }


}