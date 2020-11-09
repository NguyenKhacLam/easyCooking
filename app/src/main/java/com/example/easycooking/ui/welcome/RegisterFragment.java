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

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private TextView loginNowText;
    private ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
    }

    private void initViews() {
        loginNowText = getActivity().findViewById(R.id.tvLoginNow);
        back = getActivity().findViewById(R.id.imgResBack);

        loginNowText.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        WelcomeActivity activity = (WelcomeActivity) getActivity();
        switch (v.getId()){
            case R.id.imgResBack:
                activity.showFragment(activity.getWelcomeFragment());
                break;
            case R.id.tvLoginNow:
                activity.showFragment(activity.getLoginFragment());
                break;
        }
    }
}
