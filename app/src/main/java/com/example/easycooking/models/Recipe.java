package com.example.easycooking.models;

import java.util.ArrayList;

public class Recipe {
    private String id;
    private String foodName;
    private String foodImageUrl;
    private float foodRating;
    private int foodDuration;
    private String description;
    private String createdAt;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Step> steps;

    public Recipe() {
    }

    public Recipe(String id, String foodName, String foodImageUrl, float foodRating, int foodDuration) {
        this.id = id;
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
        this.foodRating = foodRating;
        this.foodDuration = foodDuration;
    }

    public Recipe(String id, String foodName, String foodImageUrl, float foodRating, int foodDuration, String description, String createdAt, ArrayList<Ingredient> ingredients, ArrayList<Step> steps) {
        this.id = id;
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
        this.foodRating = foodRating;
        this.foodDuration = foodDuration;
        this.description = description;
        this.createdAt = createdAt;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public int getFoodDuration() {
        return foodDuration;
    }

    public void setFoodDuration(int foodDuration) {
        this.foodDuration = foodDuration;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public void setFoodImageUrl(String foodImageUrl) {
        this.foodImageUrl = foodImageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }
}
