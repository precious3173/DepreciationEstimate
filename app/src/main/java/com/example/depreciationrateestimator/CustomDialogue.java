package com.example.depreciationrateestimator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomDialogue extends AppCompatDialogFragment {
DatePicker picker;
String date;
CapitalizationDate capitalizationDate;
    
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        
        View view = layoutInflater.inflate(R.layout.custom_layout, null);

        picker = view.findViewById(R.id.datePicker);
        
        builder.setView(view).setTitle("Set Capitalization Date").setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                
            }
        }).setPositiveButton("SET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                int month  = picker.getMonth();
                int year = picker.getYear();
                int day = picker.getDayOfMonth();
                date = (month + 1) + "/" + day + "/" + year;
                capitalizationDate.capitalizateDat(date);

            }
        });
        
        return builder.create();
    }

    public interface CapitalizationDate {
        void capitalizateDat (String date);
    }
}
