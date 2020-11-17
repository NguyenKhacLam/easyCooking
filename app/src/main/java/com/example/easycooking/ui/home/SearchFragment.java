package com.example.easycooking.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycooking.R;
import com.example.easycooking.adapters.CategoryAdapter;
import com.example.easycooking.models.Category;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        loadData();
    }

    private void loadData() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("jashdas","Breakfast","https://www.clipartmax.com/png/middle/138-1388698_breakfast-brunch-food-nutrition-breakfast-vector-png.png","#F9E196"));
        categories.add(new Category("jasdadshdas","Asia","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR6ywtC-Udmc-KxKqANSZM6fW8LGmdRB5FjKw&usqp=CAU","#D1AFDE"));
        categories.add(new Category("dasfer","Quick Food","https://i.dlpng.com/static/png/6497647_preview.png","#7DD9BE"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categoryAdapter.setData(categories);
    }

    private void initViews() {
        recyclerView = getActivity().findViewById(R.id.rcSearch);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        categoryAdapter = new CategoryAdapter(getLayoutInflater());
        recyclerView.setAdapter(categoryAdapter);
    }
}
