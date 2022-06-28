package com.example.depreciationrateestimator;

import android.app.Dialog;
import android.content.Context;
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
import androidx.fragment.app.DialogFragment;

public class CustomDialogue extends DialogFragment {
DatePicker picker;
public CapitalizationDate capitalizationDate;



    @NonNull    @Override
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
                String date = (month + 1) + "/" + day + "/" + year;
                capitalizationDate.capitalize(date);

            }
        });
        
        return builder.create();
    }
  /*  @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
       try{ capitalizationDate = (CapitalizationDate) context;}
       catch (ClassCastException e) {
           throw new ClassCastException(getActivity().toString() + "Implement dialog");
       }

    } */

}
