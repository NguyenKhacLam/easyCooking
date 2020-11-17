package com.example.easycooking.dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class FbDatabase {
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public static FirebaseFirestore getDb(){
        return db;
    }

    public static FirebaseUser getUser(){
        return user;
    }

    public static void setDbUser(FirebaseUser user){
        FbDatabase.user = user;
    }
}
