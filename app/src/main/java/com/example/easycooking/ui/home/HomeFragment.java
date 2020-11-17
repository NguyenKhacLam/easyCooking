package com.example.easycooking.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycooking.R;
import com.example.easycooking.adapters.CategoryAdapter;
import com.example.easycooking.adapters.FoodAdapter;
import com.example.easycooking.adapters.NewRecipeAdapter;
import com.example.easycooking.models.Category;
import com.example.easycooking.models.Recipe;
import com.example.easycooking.viewModels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private RecyclerView foodRecyclerView, newRecipeRecyclerView, categoryRecyclerView;
    private FoodAdapter foodAdapter;
    private NewRecipeAdapter newRecipeAdapter;
    private CategoryAdapter categoryAdapter;

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
        loadCategories();

        RecipeViewModel recipeViewModel = new RecipeViewModel();
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                Log.d(TAG, "onChanged: " + recipes.size());
            }
        });
    }

    private void loadCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("jashdas","Breakfast","https://www.clipartmax.com/png/middle/138-1388698_breakfast-brunch-food-nutrition-breakfast-vector-png.png","#F9E196"));
        categories.add(new Category("jasdadshdas","Asia","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR6ywtC-Udmc-KxKqANSZM6fW8LGmdRB5FjKw&usqp=CAU","#D1AFDE"));
        categories.add(new Category("dasfer","Quick Food","https://i.dlpng.com/static/png/6497647_preview.png","#7DD9BE"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categories.add(new Category("asdefw","Dinner","https://p7.hiclipart.com/preview/617/651/586/sausage-breakfast-bacon-omelette-cartoon-breakfast-vector.jpg","#D3BA93"));
        categoryAdapter.setData(categories);
    }

    private void loadRecommendFoods(){
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("ashgdads", "Cơm rang", "https://image-us.eva.vn/upload/1-2019/images/2019-01-12/khi-lam-com-rang-trung-chien-trung-hay-com-truoc-dam-bao-90-van-lam-sai-cach-4ebbbc7e51db4ecfac32ddcf9bda4a0a-1547258436-664-width1024height682.jpeg", 4.8f, 25));
        recipes.add(new Recipe("dfgdfg", "Bánh cuốn", "https://image-us.eva.vn/upload/3-2018/images/2018-07-12/banh-cuon-trang-chao-1531380999-627-width640height480.jpg", 4f, 25));
        recipes.add(new Recipe("ggergdfg", "Thịt kho tàu", "https://image-us.eva.vn/upload/2-2019/images/2019-06-06/3-cach-lam-thit-kho-ngon-dam-da-voi-cach-che-bien-don-gian-thit-kho-8-1559804849-809-width600height389.jpg", 4.8f, 25));
        foodAdapter.setData(recipes);
        newRecipeAdapter.setData(recipes);
    }

    private void initViews() {
        // Recommend
        foodRecyclerView = getActivity().findViewById(R.id.rcRecommend);

        foodAdapter = new FoodAdapter(getLayoutInflater());
        foodRecyclerView.setAdapter(foodAdapter);

        // New recipe
        newRecipeRecyclerView = getActivity().findViewById(R.id.rcNewRecipe);

        newRecipeAdapter = new NewRecipeAdapter(getLayoutInflater());
        newRecipeRecyclerView.setAdapter(newRecipeAdapter);

        // Categories
        categoryRecyclerView = getActivity().findViewById(R.id.rcCategory);

        categoryAdapter = new CategoryAdapter(getLayoutInflater());
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
}
