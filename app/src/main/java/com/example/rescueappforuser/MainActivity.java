package com.example.rescueappforuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int Splash_delay = 2000;
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        new Handler().postDelayed(() -> {
            setContentView(R.layout.log_in_page);


            username = findViewById(R.id.edtUsername);
            password = findViewById(R.id.edtPassword);
            btnLogin = findViewById(R.id.btn_login);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userText = username.getText().toString().trim();
                    String passText = password.getText().toString().trim();

                    if (userText.isEmpty()) {
                        username.setError("Input Username");
                        username.requestFocus();
                    } else if (passText.isEmpty()) {
                        password.setError("Input Password");
                        password.requestFocus();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }, Splash_delay);
    }
}