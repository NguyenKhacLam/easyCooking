package com.example.easycooking.ui.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.easycooking.R;

public class WelcomeFragment extends Fragment implements View.OnClickListener {
    private Button loginWelBtn, registerWelBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
    }

    private void initViews() {
        loginWelBtn = getActivity().findViewById(R.id.loginWelcomeBtn);
        registerWelBtn = getActivity().findViewById(R.id.registerWelcomeBtn);

        loginWelBtn.setOnClickListener(this);
        registerWelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginWelcomeBtn:
                WelcomeActivity activity = (WelcomeActivity) getActivity();
                activity.showFragment(activity.getLoginFragment());
                break;
            case R.id.registerWelcomeBtn:
                WelcomeActivity activity1 = (WelcomeActivity) getActivity();
                activity1.showFragment(activity1.getRegisterFragment());
                break;
        }
    }
}
