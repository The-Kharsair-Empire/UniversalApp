package com.kharsair.universalapp.requestscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kharsair.universalapp.R;
import com.kharsair.universalapp.databinding.ActivityRequestSchedulerMainBinding;

public class RequestSchedulerMainActivity extends AppCompatActivity {

    private ActivityRequestSchedulerMainBinding viewBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityRequestSchedulerMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }
}