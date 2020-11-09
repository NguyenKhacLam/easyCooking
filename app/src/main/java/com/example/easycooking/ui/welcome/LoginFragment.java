package com.example.easycooking.ui.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.easycooking.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextView signUpText;
    private ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        signUpText = getActivity().findViewById(R.id.tvSignUpNow);
        back = getActivity().findViewById(R.id.imgLogBack);

        signUpText.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        WelcomeActivity activity = (WelcomeActivity) getActivity();

        switch (v.getId()){
            case R.id.imgLogBack:
                activity.showFragment(activity.getWelcomeFragment());
                break;
            case R.id.tvSignUpNow:
                activity.showFragment(activity.getRegisterFragment());
                break;
        }
    }
}
