package com.example.letscipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private ArrayList<Recipe> items = new ArrayList<>();

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder viewHolder, int position) {
        Recipe item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getImgUrl())
                .into(viewHolder.ivRecipe);

        viewHolder.dishName.setText(item.getDishName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Recipe> recipes){
        this.items = recipes;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivRecipe;
        TextView dishName;

        ViewHolder(View itemView){
            super(itemView);

            ivRecipe = itemView.findViewById(R.id.iv_item_recipe);
            dishName = itemView.findViewById(R.id.item_recipe_title);
        }
    }
}
