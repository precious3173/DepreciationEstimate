package com.example.depreciationrateestimator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversionAdapter extends RecyclerView.Adapter<ConversionAdapter.Conversion>{
ArrayList<ConversionArray> conversionArray = new ArrayList<>();
Context context;

 public ConversionAdapter( ArrayList<ConversionArray>conversionArray, Context context){

     this.conversionArray = conversionArray;
     this.context = context;
 }

    @NonNull
    @Override
    public Conversion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversionlayout,parent, false);
        return new Conversion(view);
    }

    @Override
    public int getItemCount() {
        return conversionArray.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Conversion holder, int position) {
     ConversionArray conversionArray1 = conversionArray.get(position);

     String text = conversionArray1.getText();
     int image = conversionArray1.getImage();

     holder.text.setText(text);
     holder.image.setImageResource(image);

     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("formula", text);
             Navigation.findNavController(view).navigate(R.id.action_conversionType_to_conversionSheet, bundle);

         }
     });
    }

    public static class Conversion extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
        public Conversion(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.image);
        }
    }



}
