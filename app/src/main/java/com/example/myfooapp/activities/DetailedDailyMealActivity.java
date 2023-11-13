package com.example.myfooapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myfooapp.R;
import com.example.myfooapp.adapters.DetailedDailyAdapter;
import com.example.myfooapp.models.DetailedDailyModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import DBconnection.Queries;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    public List<Integer> getDrawablesList(int nrOfPictures, String nameOfPictures, String whereToSearch)  {

        List<Integer> drawables = new ArrayList<>();
        for(int i=1;i<=nrOfPictures;i++)
            drawables.add(getResources().getIdentifier("breakfast"+i,"drawable",getPackageName()));

        return drawables;
    }

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

        List<Integer> picturesId;
        long numberOfPictures;
        //TODO: refactorizare Queries
        Queries queries = new Queries();
        Future<Vector<DetailedDailyModel>> meals_future;
        Vector<DetailedDailyModel> meals = null;
        try {
            meals_future = queries.GetDailyMeals();

            meals = meals_future.get();
        } catch (SQLException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        if(type != null && type.equalsIgnoreCase("breakfast")  )
        {
            imageView.setImageResource(R.drawable.breakfast);
            numberOfPictures= meals.stream()
                    .filter(meal -> "breakfast".equalsIgnoreCase(meal.getType()))
                    .count();
            picturesId = getDrawablesList((int)numberOfPictures,"breakfast","drawable");

            for(int i=0; i<picturesId.size();i++)
            {
                meals.elementAt(i).setImage(picturesId.get(i));
                detailedDailyModelList.add(meals.elementAt(i));
            }
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