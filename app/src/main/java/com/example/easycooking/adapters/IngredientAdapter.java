package com.example.easycooking.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycooking.models.Ingredient;
import com.example.easycooking.R;


import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.HolderIngredient> {

    private LayoutInflater layoutInflater;
    private ArrayList<Ingredient> data;

    public IngredientAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setData(ArrayList<Ingredient> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderIngredient onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_ingredient, parent, false);
        return new HolderIngredient(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderIngredient holder, int position) {
        final Ingredient ingredient = data.get(position);
        holder.bindView(ingredient);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class HolderIngredient extends RecyclerView.ViewHolder {
        private TextView name, quantity;

        public HolderIngredient(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recipeIngredientName);
            quantity = itemView.findViewById(R.id.recipeIngredientQuantity);
        }

        private void bindView(Ingredient ingredient) {
            name.setText(ingredient.getName());
            quantity.setText(ingredient.getQuantity() + ingredient.getUnit());
        }
    }
}
