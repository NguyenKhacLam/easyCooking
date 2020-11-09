package com.example.easycooking.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.easycooking.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private HomeFragment homeFragment = new HomeFragment();
    private FavoriteFragment favoriteFragment = new FavoriteFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private UserFragment userFragment = new UserFragment();

    private BottomNavigationView bottomNavigationView;

    public HomeFragment getHomeFragment() {
        return homeFragment;
    }

    public FavoriteFragment getFavoriteFragment() {
        return favoriteFragment;
    }

    public SearchFragment getSearchFragment() {
        return searchFragment;
    }

    public UserFragment getUserFragment() {
        return userFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showFragment(homeFragment);
        initViews();
    }

    private void initViews() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.homeFragmentContainer, homeFragment);
        transaction.add(R.id.homeFragmentContainer, userFragment);
        transaction.add(R.id.homeFragmentContainer, searchFragment);
        transaction.add(R.id.homeFragmentContainer, favoriteFragment);
        transaction.commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out);
//        transaction.replace(R.id.homeFragmentContainer, fragment);
        transaction.hide(homeFragment);
        transaction.hide(favoriteFragment);
        transaction.hide(userFragment);
        transaction.hide(searchFragment);
        transaction.show(fragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navHome:
                showFragment(homeFragment);
                item.setChecked(true);
                break;
            case R.id.navFavorite:
                showFragment(favoriteFragment);
                item.setChecked(true);
                break;
            case R.id.navSearch:
                showFragment(searchFragment);
                item.setChecked(true);
                break;
            case R.id.navUser:
                showFragment(userFragment);
                item.setChecked(true);
                break;
        }
        return false;
    }
}