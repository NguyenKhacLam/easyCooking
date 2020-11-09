package com.example.easycooking.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycooking.R;
import com.example.easycooking.adapters.FoodAdapter;
import com.example.easycooking.models.Food;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView foodRecyclerView;
    private FoodAdapter foodAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
        loadRecommendFoods();
    }

    private void loadRecommendFoods(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("ashgdads", "Cơm rang", "https://image-us.eva.vn/upload/1-2019/images/2019-01-12/khi-lam-com-rang-trung-chien-trung-hay-com-truoc-dam-bao-90-van-lam-sai-cach-4ebbbc7e51db4ecfac32ddcf9bda4a0a-1547258436-664-width1024height682.jpeg"));
        foods.add(new Food("dfgdfg", "Bánh cuốn", "https://image-us.eva.vn/upload/3-2018/images/2018-07-12/banh-cuon-trang-chao-1531380999-627-width640height480.jpg"));
        foods.add(new Food("ggergdfg", "Thịt kho tàu", "https://image-us.eva.vn/upload/2-2019/images/2019-06-06/3-cach-lam-thit-kho-ngon-dam-da-voi-cach-che-bien-don-gian-thit-kho-8-1559804849-809-width600height389.jpg"));
        foodAdapter.setData(foods);
    }

    private void initViews() {
        foodRecyclerView = getActivity().findViewById(R.id.rcRecommend);

        foodAdapter = new FoodAdapter(getLayoutInflater());
        foodRecyclerView.setAdapter(foodAdapter);
    }
}
