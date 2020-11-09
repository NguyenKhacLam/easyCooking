package com.example.easycooking.ui.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.easycooking.R;

public class WelcomeActivity extends AppCompatActivity {
    LoginFragment loginFragment = new LoginFragment();
    RegisterFragment registerFragment = new RegisterFragment();
    WelcomeFragment welcomeFragment = new WelcomeFragment();

    public WelcomeFragment getWelcomeFragment() {
        return welcomeFragment;
    }

    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    public RegisterFragment getRegisterFragment() {
        return registerFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(welcomeFragment);
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}