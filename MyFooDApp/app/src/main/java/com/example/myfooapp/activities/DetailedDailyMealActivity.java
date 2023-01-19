package com.example.myfooapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myfooapp.R;
import com.example.myfooapp.adapters.DetailedDailyAdapter;
import com.example.myfooapp.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if(type != null && type.equalsIgnoreCase("breakfast"))
        {
            imageView.setImageResource(R.drawable.breakfast);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast1,"Breakfast","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast2,"Breakfast","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast3,"Breakfast","description","4.4","40","10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("lunch"))
        {
            imageView.setImageResource(R.drawable.lunch);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch1,"Lunch","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch2,"Lunch","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch3,"Lunch","description","4.4","40","10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("dinner"))
        {
            imageView.setImageResource(R.drawable.dinner);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner1,"Dinner","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner2,"Dinner","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner3,"Dinner","description","4.4","40","10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("sweets"))
        {
            imageView.setImageResource(R.drawable.breakfast);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.sweets1,"Sweets","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.sweets2,"Sweets","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.sweets3,"Sweets","description","4.4","40","10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("coffee"))
        {
            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffee1,"Coffee","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffee2,"Coffee","description","4.4","40","10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffee3,"Coffee","description","4.4","40","10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();
        }






    }
}