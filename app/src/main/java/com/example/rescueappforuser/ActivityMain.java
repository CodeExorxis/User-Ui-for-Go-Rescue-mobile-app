package com.example.rescueappforuser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rescueappforuser.databinding.ActivityMainBinding;
import com.example.rescueappforuser.databinding.NoInternetBinding;

public class ActivityMain extends AppCompatActivity {

    ActivityMainBinding root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());
    }
}
