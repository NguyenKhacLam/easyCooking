package com.example.easycooking.utils;

import com.example.easycooking.models.Step;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapToObject {
    public static ArrayList<Object> hashMapToObject(ArrayList<HashMap<Object, Object>> hashMaps, Object object){
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < hashMaps.size(); i++) {
            Gson gson = new Gson();
            JsonElement jsonElement = gson.toJsonTree(hashMaps.get(i));
            Object step = gson.fromJson(jsonElement, Object.class);
            list.add(step);
        }
        return list;
    }
}
