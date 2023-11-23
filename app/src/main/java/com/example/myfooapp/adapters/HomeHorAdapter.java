package com.example.myfooapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfooapp.R;
import com.example.myfooapp.models.DetailedDailyModel;
import com.example.myfooapp.models.HomeHorModel;
import com.example.myfooapp.models.HomeVerModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import DBconnection.Queries;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    List<DetailedDailyModel> meals = null;
    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
    Context context = null;

    boolean check=true;
    boolean select=true;
    int row_index = -1;

    public List<Integer> GetDrawablesList(int nrOfPictures, String nameOfPictures, String whereToSearch)  {

        List<Integer> drawables = new ArrayList<>();
        for(int i=1;i<=nrOfPictures;i++)
            drawables.add(context.getResources().getIdentifier(nameOfPictures+i,whereToSearch,context.getPackageName()));

        return drawables;
    }

    private void UpdateModelList(String type)
    {
        homeVerModels = new ArrayList<>();

        List<DetailedDailyModel> mealsOfType;
        List<Integer> picturesId;

        mealsOfType= meals.stream()
                .filter(meal -> type.equalsIgnoreCase(meal.getType()))
                .collect(Collectors.toList());

        picturesId = GetDrawablesList(mealsOfType.size(),type,"drawable");

        int pictureNR=0;
        for(int i=0; i<mealsOfType.size();i++) {
            mealsOfType.get(i).setImage(picturesId.get(pictureNR++));
            homeVerModels.add(new HomeVerModel(mealsOfType.get(i).getImage(),mealsOfType.get(i).getName(),mealsOfType.get(i).getTiming(),mealsOfType.get(i).getPrice()));
        }
    }


    public HomeHorAdapter(Context context,UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.context = context;
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.home_horizontal_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
        //return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        Queries queries = new Queries();
        Future<Vector<DetailedDailyModel>> meals_future;

        try {
            meals_future = queries.GetDailyMeals();

            meals = meals_future.get();
        } catch (SQLException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        if(check) {
            UpdateModelList("pizza");
            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();

                    if(position == 0)
                    {
                        UpdateModelList("pizza");

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 1)
                    {
                        UpdateModelList("burgers");
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 2)
                    {
                        UpdateModelList("fries");
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 3)
                    {
                        UpdateModelList("icecream");
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 4)
                    {
                        UpdateModelList("sandwich");
                        updateVerticalRec.callBack(position,homeVerModels);
                    }

                }
            });

            if(select)
            {
                if(position == 0)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else
            {
                if(row_index == position)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
                else
                {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardWiew);
        }
    }

}
