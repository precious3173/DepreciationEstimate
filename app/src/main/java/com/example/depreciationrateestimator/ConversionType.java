package com.example.depreciationrateestimator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ConversionType extends Fragment  {

ConversionAdapter conversionAdapter;
ArrayList<ConversionArray>arraylist;
RecyclerView recyclerView;
NavController navController;


@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    navController = NavHostFragment.findNavController(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_conversion_type, container, false);

     recyclerView = view.findViewById(R.id.recyclerView);
    arraylist = new ArrayList<>();

    arraylist.add(new ConversionArray("Straight-Line", R.drawable.ic_baseline_house_siding_24));
    arraylist.add(new ConversionArray("Sum-of-the-years'-digits", R.drawable.ic_baseline_computer_24));
        arraylist.add(new ConversionArray("Declining Balance", R.drawable.ic_baseline_directions_car_24));
    arraylist.add(new ConversionArray("Units of Production", R.drawable.ic_baseline_construction_24));

     conversionAdapter = new ConversionAdapter(arraylist, getContext());

    recyclerView.setAdapter(conversionAdapter);
     return view;
    }


}