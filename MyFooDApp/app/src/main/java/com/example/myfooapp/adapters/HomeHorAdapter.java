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
import com.example.myfooapp.models.HomeHorModel;
import com.example.myfooapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check=true;
    boolean select=true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
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

        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Capriciosa", "10:00 - 23:00", "Min - $28"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Quatro Stagioni", "10:00 - 23:00", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza Casei", "10:00 - 23:00", "Min - $30"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Prosciutto e Funghi", "10:00 - 23:00", "Min - $29"));

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
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza1,"Capriciosa","10:00 - 23:00", "Min - $28"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza2,"Quatro Stagioni","10:00 - 23:00", "Min - $35"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza3,"Pizza Casei","10:00 - 23:00", "Min - $30"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza4,"Prosciutto e Funghi","10:00 - 23:00", "Min - $29"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 1)
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.burgers1,"Salsa Burger","10:00 - 23:00", "Min - $40"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burgers2,"Home Burger","10:00 - 23:00", "Min - $37"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burgers3,"Dublu Cheeseburger","10:00 - 23:00", "Min - $35"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burgers4,"Traditional Burger","10:00 - 23:00", "Min - $36"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 2)
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.fries1,"French fries with salt","10:00 - 23:00", "Min - $10"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fries2,"French fries with garlic","10:00 - 23:00", "Min - $15"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fries3,"French fries with parmesan","10:00 - 23:00", "Min - $12"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fries4,"Wedges fries","10:00 - 23:00", "Min - $10"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 3)
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.icecream1,"Nuts Ice Cream","10:00 - 23:00", "Min - $12"));
                        homeVerModels.add( new HomeVerModel(R.drawable.icecream2,"Vanilla Ice Cream","10:00 - 23:00", "Min - $10"));
                        homeVerModels.add( new HomeVerModel(R.drawable.icecream3,"Chocolate Ice Cream","10:00 - 23:00", "Min - $6"));
                        homeVerModels.add( new HomeVerModel(R.drawable.icecream4,"Oreo Ice Cream","10:00 - 23:00", "Min - $12"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position == 4)
                    {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.sandwich1,"Vegan Quesadilla","10:00 - 23:00", "Min - $30"));
                        homeVerModels.add( new HomeVerModel(R.drawable.sandwich2,"Chicken Quesadilla","10:00 - 23:00", "Min - $32"));
                        homeVerModels.add( new HomeVerModel(R.drawable.sandwich3,"Bagel with scrumble eggs, prosciutto and cheddar","10:00 - 23:00", "Min - $35"));
                        homeVerModels.add( new HomeVerModel(R.drawable.sandwich4,"Croissant with ham and vegetables","10:00 - 23:00", "Min - $35"));

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
