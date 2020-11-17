package com.example.easycooking.adapters;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.easycooking.R;
import com.example.easycooking.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.HolderCategory> {

    private LayoutInflater layoutInflater;
    private ArrayList<Category> data;
    private OnClickFoodListener listener;

    public CategoryAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setListener(OnClickFoodListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Category> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_category, parent, false);
        return new HolderCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCategory holder, int position) {
        final Category category = data.get(position);
        holder.bindView(category);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickFood(category);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onClickLongFood(category);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class HolderCategory extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private TextView textView;
        private ImageView imageView;

        public HolderCategory(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layoutCate);
            textView = itemView.findViewById(R.id.tvNameCate);
            imageView = itemView.findViewById(R.id.imgCate);
        }

        private void bindView(Category category) {
            layout.setBackgroundColor(Color.parseColor(category.getColor()));
            textView.setText(category.getName());
            Glide.with(imageView).load(category.getImageUrl()).into(imageView);
        }
    }

    public interface OnClickFoodListener {
        void onClickFood(Category category);

        void onClickLongFood(Category category);
    }

}
