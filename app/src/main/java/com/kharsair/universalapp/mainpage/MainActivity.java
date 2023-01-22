package com.kharsair.universalapp.mainpage;

import android.Manifest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.kharsair.universalapp.databinding.ActivityMainBinding;
import com.kharsair.universalapp.requestscheduler.RequestSchedulerMainActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;
    private MainActivityListviewFunctionPickerAdapter functionPickerListviewAdapter;

    private static final FunctionPickerMenuItemHolder[] functionPickerMenuItems = {
            new FunctionPickerMenuItemHolder("Request Scheduler", RequestSchedulerMainActivity.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        functionPickerListviewAdapter = new MainActivityListviewFunctionPickerAdapter(
                this,
                functionPickerMenuItems
        );

        if (!hasAllPermissions()) {
            requestPermissions(requestedPermissions, PERMISSION_REQUEST_CODE);
        } else {
            proceedAfterPermissionsGranted();
        }

    }


    private void proceedAfterPermissionsGranted() {
        viewBinding.activityMainListviewAppFunctionPicker.setAdapter(functionPickerListviewAdapter);
    }


    private static final String[] requestedPermissions = {
            Manifest.permission.INTERNET
    };

    private static final int PERMISSION_REQUEST_CODE = 100;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (checkGrantResult(permissions, grantResults))
                proceedAfterPermissionsGranted();
        }
    }

    private boolean checkGrantResult(String[] permissions, int[] grantResults) {

        for (int i = 0; i < permissions.length; i ++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Required permission not granted: " + permissions[i], Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private boolean hasAllPermissions() {
        for (String permission: requestedPermissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }
}