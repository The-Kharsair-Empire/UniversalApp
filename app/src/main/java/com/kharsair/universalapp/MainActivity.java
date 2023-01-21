package com.kharsair.universalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.kharsair.universalapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }


    private static final String[] RequestedPermissions = {

    };

    private static final int PERMISSION_REQUEST_CODE = 100;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (hasPermission()) {

            }
        }
    }

    private boolean hasPermission() {
        if (RequestedPermissions != null) {
            for (String permission: RequestedPermissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "App requires permission: " + permission, Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }

        return true;
    }
}