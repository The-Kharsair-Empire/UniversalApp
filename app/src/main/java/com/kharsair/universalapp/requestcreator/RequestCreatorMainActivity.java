package com.kharsair.universalapp.requestcreator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.kharsair.universalapp.databinding.ActivityRequestCreatorMainBinding;

public class RequestCreatorMainActivity extends AppCompatActivity {

    private ActivityRequestCreatorMainBinding viewBinding;
    private RequestCreatorRequestListviewAdapter requestListviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityRequestCreatorMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        requestListviewAdapter = new RequestCreatorRequestListviewAdapter();

        setup();
    }

    private void setup() {
        viewBinding.requestCreatorAddNewRequestFloatingBtn.setOnClickListener(
                new AddNewFloatingButtonOnClickListener());

        viewBinding.requestCreatorExistingRequestListView.setAdapter(requestListviewAdapter);
        viewBinding.requestCreatorExistingRequestListView.setLayoutManager(
                new LinearLayoutManager(this));
    }
}