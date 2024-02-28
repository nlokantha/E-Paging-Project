package com.example.e_pagingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.e_pagingproject.fragments.MainFragment;
import com.example.e_pagingproject.fragments.UsersFragment;
import com.example.e_pagingproject.models.User;

public class MainActivity extends AppCompatActivity implements MainFragment.MainListener {

    BluetoothAdapter bluetoothAdapter;
    public static final int REQUEST_ENABLE_BT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Device doesn't support Bluetooth !!! ", Toast.LENGTH_SHORT).show();
        }
//        if (!bluetoothAdapter.isEnabled()) {
//            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                    ActivityCompat.requestPermissions(getParent(),new String[]{Manifest.permission.BLUETOOTH},100);
//                }
//            }
//            startActivity(enableBtIntent);
//        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new MainFragment())
                .commit();
    }

    @Override
    public void gotoUserFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void updateBoard() {

    }

    @Override
    public void saveUser(User user) {

    }
}