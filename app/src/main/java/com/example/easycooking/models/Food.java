package com.example.easycooking.models;

public class Food {
    private String id;
    private String foodName;
    private String foodImageUrl;

    public Food() {
    }

    public Food(String id, String foodName, String foodImageUrl) {
        this.id = id;
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
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
