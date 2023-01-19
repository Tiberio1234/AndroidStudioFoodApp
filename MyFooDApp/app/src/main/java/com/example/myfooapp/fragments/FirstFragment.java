package com.example.myfooapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfooapp.R;
import com.example.myfooapp.adapters.FeaturedHorAdapter;
import com.example.myfooapp.adapters.FeaturedVerAdapter;
import com.example.myfooapp.models.FeaturedModel;
import com.example.myfooapp.models.FeaturedVerModel;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    /////////Featured fragment horizontal RecycleView
    List<FeaturedModel> featuredHorModelList;
    RecyclerView recyclerView;
    FeaturedHorAdapter featuredHorAdapter;
    
    
    //////////////////////////////Featured Vertical RecyclerView
    List<FeaturedVerModel> featuredVerModelList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public  FirstFragment()
    {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);


        /////////Featured fragment horizontal RecycleView

        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),recyclerView.HORIZONTAL,false));
        featuredHorModelList = new ArrayList<>();
        featuredHorModelList.add(new FeaturedModel(R.drawable.sweets1,"Featured 1","Description"));
        featuredHorModelList.add(new FeaturedModel(R.drawable.breakfast2,"Featured 2","Description"));
        featuredHorModelList.add(new FeaturedModel(R.drawable.dinner3,"Featured 3","Description"));

        featuredHorAdapter = new FeaturedHorAdapter(featuredHorModelList);
        recyclerView.setAdapter(featuredHorAdapter);


        //////////////////////////////Featured Vertical RecyclerView

        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),recyclerView2.VERTICAL,false));

        featuredVerModelList = new ArrayList<>();
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.coffee3,"Featured 1", "Description 1","4.0","10:00-20:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.coffee1,"Featured 2", "Description 2","4.5","10:00-20:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.lunch1,"Featured 3", "Description 3","4.8","10:00-20:00"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.breakfast3,"Featured 4", "Description 4","4.9","10:00-20:00"));

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);
        
        

        return view;
    }
}