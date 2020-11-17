package com.example.easycooking.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easycooking.models.Recipe;
import com.example.easycooking.responsitories.RecipeResponsitory;

import java.util.List;

public class RecipeViewModel {
    private RecipeResponsitory recipeResponsitory;
    private MutableLiveData<List<Recipe>> mutableLiveData;

    public RecipeViewModel() {
        recipeResponsitory = new RecipeResponsitory();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        if(mutableLiveData==null){
            mutableLiveData = recipeResponsitory.getAllRecipes();
        }
        return mutableLiveData;
    }
}
