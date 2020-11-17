package com.example.easycooking.ui.recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.easycooking.R;

public class RecipeDetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        setUpToolBar();
        initViews();
    }

    private void setUpToolBar() {
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("Bánh giò");
        setSupportActionBar(toolbar);
        if (toolbar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {

    }
}