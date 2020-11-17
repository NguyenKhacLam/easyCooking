package com.example.easycooking.responsitories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.easycooking.models.Ingredient;
import com.example.easycooking.models.Recipe;
import com.example.easycooking.models.Step;
import com.example.easycooking.utils.HashMapToObject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeResponsitory {
    private static final String TAG = "RecipeResponsitory";
    final MutableLiveData<List<Recipe>> mutableLiveData = new MutableLiveData<>();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MutableLiveData<List<Recipe>> getAllRecipes(){
        db.collection("recipes").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            ArrayList<Recipe> recipes = new ArrayList<>();
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
                                Recipe recipe = new Recipe();

                                recipe.setId(snapshot.getId());
                                recipe.setFoodName(snapshot.get("name").toString());
                                recipe.setDescription(snapshot.get("description").toString());
                                recipe.setFoodImageUrl(snapshot.get("imageUrl").toString());
                                recipe.setCreatedAt(snapshot.get("createdAt").toString());
                                recipe.setFoodRating(Float.parseFloat(snapshot.get("rating").toString()));
                                recipe.setFoodDuration(Integer.parseInt(snapshot.get("duration").toString()));

                                ArrayList<HashMap<Object,Object>> ingredientsHashMaps = (ArrayList<HashMap<Object, Object>>) snapshot.get("ingredients");
                                ArrayList<Ingredient> ingredients = new ArrayList<>();
                                for (int i = 0; i < ingredientsHashMaps.size(); i++) {
                                    Gson gson = new Gson();
                                    JsonElement jsonElement = gson.toJsonTree(ingredientsHashMaps.get(i));
                                    Ingredient subTask = gson.fromJson(jsonElement, Ingredient.class);
                                    ingredients.add(subTask);
                                }
                                recipe.setIngredients(ingredients);

                                ArrayList<HashMap<Object,Object>> stepsHashMaps = (ArrayList<HashMap<Object, Object>>) snapshot.get("steps");
                                ArrayList<Step> steps = new ArrayList<>();
                                for (int i = 0; i < ingredientsHashMaps.size(); i++) {
                                    Gson gson = new Gson();
                                    JsonElement jsonElement = gson.toJsonTree(stepsHashMaps.get(i));
                                    Step step = gson.fromJson(jsonElement, Step.class);
                                    steps.add(step);
                                }
//                                HashMapToObject.hashMapToObject(stepsHashMaps);
                                recipe.setIngredients(ingredients);

                                recipes.add(recipe);
                            }
                            Log.d(TAG, "onComplete: " + recipes.size());
                            mutableLiveData.setValue(recipes);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: " + e.getMessage());
                    }
                });

        return mutableLiveData;
    }
}
