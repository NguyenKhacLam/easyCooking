package com.example.easycooking.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.easycooking.R;
import com.example.easycooking.models.Recipe;

import java.util.ArrayList;

public class NewRecipeAdapter extends RecyclerView.Adapter<NewRecipeAdapter.HolderFood> {

    private LayoutInflater layoutInflater;
    private ArrayList<Recipe> data;
    private OnClickFoodListener listener;

    public NewRecipeAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setListener(OnClickFoodListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Recipe> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderFood onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recipe, parent, false);
        return new HolderFood(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFood holder, int position) {
        final Recipe recipe = data.get(position);
        holder.bindView(recipe);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickFood(recipe);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onClickLongFood(recipe);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class HolderFood extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name, rate, duration;

        public HolderFood(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recipeImage);
            name = itemView.findViewById(R.id.recipeName);
            rate = itemView.findViewById(R.id.recipeRating);
            duration = itemView.findViewById(R.id.recipeDuration);
        }

        private void bindView(Recipe recipe) {
            name.setText(recipe.getFoodName());
            rate.setText(recipe.getFoodRating() + "");
            duration.setText(recipe.getFoodDuration() + " min");
            Glide.with(imageView).load(recipe.getFoodImageUrl()).into(imageView);
        }
    }

    public interface OnClickFoodListener {
        void onClickFood(Recipe recipe);

        void onClickLongFood(Recipe recipe);
    }

}
