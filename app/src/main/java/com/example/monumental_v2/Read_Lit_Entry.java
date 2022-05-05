package com.example.monumental_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Read_Lit_Entry extends AppCompatActivity {

    Button update_btn;
    Button delete_btn;

    String n_id;
    String n_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_read_lit_entry);

        n_id = getIntent().getStringExtra("ID");
        n_title = getIntent().getStringExtra("TITLE");
        String n_year = getIntent().getStringExtra("YEAR");
        String n_author = getIntent().getStringExtra("AUTHOR");
        String n_excerpt = getIntent().getStringExtra("EXCERPT");

        TextView id = findViewById(R.id.view_title);
        TextView title = findViewById(R.id.view_title);
        TextView year = findViewById(R.id.view_year);
        TextView author = findViewById(R.id.view_author);
        TextView excerpt = findViewById(R.id.view_excerpt);

        id.setText(n_id);
        title.setText(n_title);
        year.setText(n_year);
        author.setText(n_author);
        excerpt.setText(n_excerpt);

        update_btn = findViewById(R.id.update_details_btn);
        delete_btn = findViewById(R.id.delete_entry_btn);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update_Entry_Dialog update_entry_dialog = new Update_Entry_Dialog();

                Bundle bundle = new Bundle();

                bundle.putString("ID", n_id);
                bundle.putString("TITLE", n_title);
                bundle.putString("YEAR", n_year);
                bundle.putString("AUTHOR", n_author);
                bundle.putString("EXCERPT", n_excerpt);

                update_entry_dialog.setArguments(bundle);

                update_entry_dialog.show(getSupportFragmentManager(), "UpdateInfo");

            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void confirmDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + n_title + "?");
        builder.setMessage("Are you sure you want to delete " + n_title + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                GreatWorks_DB_Literature gwDB = new GreatWorks_DB_Literature(Read_Lit_Entry.this);
                gwDB.deleteItem(n_id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}