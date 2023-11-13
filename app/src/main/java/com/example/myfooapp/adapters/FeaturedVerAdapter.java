package com.example.myfooapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfooapp.R;
import com.example.myfooapp.models.FeaturedVerModel;

import java.util.List;

public class FeaturedVerAdapter extends RecyclerView.Adapter<FeaturedVerAdapter.ViewHolder> {

    List<FeaturedVerModel> list;

    public FeaturedVerAdapter(List<FeaturedVerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FeaturedVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.featured_ver_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new  ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,description,rating,timing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           imageView = itemView.findViewById(R.id.featured_ver_item);
           name = itemView.findViewById(R.id.featured_ver_name);
           description = itemView.findViewById(R.id.featured_ver_des);
           rating = itemView.findViewById(R.id.featured_ver_rating);
           timing = itemView.findViewById(R.id.featured_ver_timing);

        }
    }
}
