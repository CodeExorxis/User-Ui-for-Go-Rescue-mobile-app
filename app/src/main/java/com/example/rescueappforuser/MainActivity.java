package com.example.rescueappforuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rescueappforuser.databinding.ActivityMainBinding;
import com.example.rescueappforuser.databinding.OnetimepasswordactivityBinding;
import com.example.rescueappforuser.databinding.SignUpPageBinding;
import com.example.rescueappforuser.databinding.SplashScreenActivityBinding;

public class MainActivity extends AppCompatActivity {

    private static final int Splash_delay = 2000;
    private ActivityMainBinding root;
    private OnetimepasswordactivityBinding binding;
    private SplashScreenActivityBinding splashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        splashBinding = SplashScreenActivityBinding.inflate(getLayoutInflater());
        setContentView(splashBinding.getRoot());


        new Handler().postDelayed(() -> {
            root = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(root.getRoot());

            root.btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userText = root.edtUsername.getText().toString().trim();
                    String passText = root.edtPassword.getText().toString().trim();

                    if (userText.isEmpty()) {
                        root.edtUsername.setError("Input Username");
                        root.edtUsername.requestFocus();
                    } else if (passText.isEmpty()) {
                        root.edtPassword.setError("Input Password");
                        root.edtPassword.requestFocus();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            root.txtSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });
        }, Splash_delay);
    }
}