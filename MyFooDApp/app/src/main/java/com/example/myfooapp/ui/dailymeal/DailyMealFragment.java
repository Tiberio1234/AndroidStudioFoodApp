package com.example.myfooapp.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfooapp.adapters.DailyMealAdapter;
import com.example.myfooapp.databinding.DailyMealFragmentBinding;
import com.example.myfooapp.models.DailyMealModel;
import com.example.myfooapp.R;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

    private DailyMealFragmentBinding binding;

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = DailyMealFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","30% OFF", "Best breakfast ever","breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch,"Lunch","20% OFF", "Healthy lunch","lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner,"Dinner","15% OFF", "Light dinner","dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"Sweets","30% OFF", "Sweet just like you","sweets"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffee,"Coffee","50% OFF", "Hot coffee","coffee"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}