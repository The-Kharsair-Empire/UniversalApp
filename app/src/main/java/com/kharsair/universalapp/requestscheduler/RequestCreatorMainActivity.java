package com.kharsair.universalapp.requestscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kharsair.universalapp.databinding.ActivityRequestCreatorMainBinding;

public class RequestCreatorMainActivity extends AppCompatActivity {

    private ActivityRequestCreatorMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityRequestCreatorMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());


        viewBinding.requestCreatorAddNewRequestFloatingBtn.init(this);
    }
}