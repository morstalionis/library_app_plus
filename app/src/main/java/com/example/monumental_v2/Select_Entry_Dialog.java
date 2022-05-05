package com.example.monumental_v2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Select_Entry_Dialog extends AppCompatDialogFragment {

    ImageButton add_art;
    ImageButton add_literature;
    ImageButton add_music;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_select_entry, null);

        builder.setView(view);

        final AlertDialog select_entry_dialog = builder.create();

        add_art = view.findViewById(R.id.add_art_btn);
        add_literature = view.findViewById(R.id.add_literature_btn);
        add_music = view.findViewById(R.id.add_music_btn);

        add_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArtDialog();
            }
        });

        add_literature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                openLitDialog();
            }
        });

        add_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMusicDialog();
            }
        });

        return builder.create();
    }

    private void openArtDialog() {

    }

    private void openLitDialog() {
        Add_Entry_Dialog add_entry_dialog = new Add_Entry_Dialog();
        add_entry_dialog.show(getParentFragmentManager(), "Add Literature Dialog");
    }

    private void openMusicDialog() {

    }
}
