package com.example.easycooking.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.easycooking.models.Recipe;
import com.example.easycooking.R;


import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.HolderFood> {

    private LayoutInflater layoutInflater;
    private ArrayList<Recipe> data;
    private OnClickFoodListener listener;

    public FoodAdapter(LayoutInflater layoutInflater) {
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
        View view = layoutInflater.inflate(R.layout.item_recommend, parent, false);
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
        private TextView textView, rating;

        public HolderFood(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recommendImg);
            textView = itemView.findViewById(R.id.tvRecommendName);
            rating = itemView.findViewById(R.id.tvRecommendRating);
        }

        private void bindView(Recipe recipe) {
            textView.setText(recipe.getFoodName());
            rating.setText(recipe.getFoodRating() + "");
            Glide.with(imageView).load(recipe.getFoodImageUrl()).into(imageView);
        }
    }

    public interface OnClickFoodListener {
        void onClickFood(Recipe recipe);

        void onClickLongFood(Recipe recipe);
    }

}
