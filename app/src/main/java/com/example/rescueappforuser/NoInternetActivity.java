package com.example.rescueappforuser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rescueappforuser.databinding.HomeActivityBinding;
import com.example.rescueappforuser.databinding.NoInternetBinding;

public class NoInternetActivity extends AppCompatActivity{

    NoInternetBinding root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = NoInternetBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());



        // This method of SMS will redirect to the SMS outside the system
        root.btnSmsSmart.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09395131408"));  // Replace with real hotline number
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });

        root.btnSmsGlobe.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09773289562"));  // Replace with real hotline number
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });

    }
}
