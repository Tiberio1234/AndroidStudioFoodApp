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
import java.util.stream.Collectors;

import DBconnection.Queries;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;
    List<DetailedDailyModel> meals = null;

    public List<Integer> getDrawablesList(int nrOfPictures, String nameOfPictures, String whereToSearch)  {

        List<Integer> drawables = new ArrayList<>();
        for(int i=1;i<=nrOfPictures;i++)
            drawables.add(getResources().getIdentifier(nameOfPictures+i,whereToSearch,getPackageName()));

        return drawables;
    }

    private void UpdateModelList(String type)
    {
        List<DetailedDailyModel> mealsOfType;
        List<Integer> picturesId;

        mealsOfType= meals.stream()
                .filter(meal -> type.equalsIgnoreCase(meal.getType()))
                .collect(Collectors.toList());

        picturesId = getDrawablesList(mealsOfType.size(),type,"drawable");

        int pictureNR=0;
        for(int i=0; i<mealsOfType.size();i++) {
            mealsOfType.get(i).setImage(picturesId.get(pictureNR++));
            detailedDailyModelList.add(mealsOfType.get(i));
        }
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

        //TODO: refactorizare Queries
        Queries queries = new Queries();
        Future<Vector<DetailedDailyModel>> meals_future;

        try {
            meals_future = queries.GetDailyMeals();

            meals = meals_future.get();
        } catch (SQLException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        if(type != null && type.equalsIgnoreCase("breakfast")  )
        {
            imageView.setImageResource(R.drawable.breakfast);
            UpdateModelList("breakfast");
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("lunch"))
        {
            imageView.setImageResource(R.drawable.lunch);
            UpdateModelList("lunch");
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("dinner"))
        {
            imageView.setImageResource(R.drawable.dinner);
            UpdateModelList("dinner");
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("sweets"))
        {
            imageView.setImageResource(R.drawable.breakfast);
            UpdateModelList("sweets");
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("coffee"))
        {
            imageView.setImageResource(R.drawable.sweets);
            UpdateModelList("coffee");
            dailyAdapter.notifyDataSetChanged();
        }






    }
}