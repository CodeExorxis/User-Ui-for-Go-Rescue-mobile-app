package com.example.rescueappforuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rescueappforuser.databinding.ActivityMainBinding;
import com.example.rescueappforuser.databinding.HomeActivityBinding;
import com.example.rescueappforuser.databinding.NoInternetBinding;
import com.example.rescueappforuser.databinding.OnetimepasswordactivityBinding;
import com.example.rescueappforuser.databinding.SignUpPageBinding;
import com.example.rescueappforuser.databinding.SplashScreenActivityBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    HomeActivityBinding root;
    String selectedMedicalCondition = "";
    String selectedVehicularCondition = "";
    String selectedDisasterCondition = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = HomeActivityBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        //Navigation drawer side menu
        root.icMenu.setOnClickListener(v -> {
            if (root.sideMenuLayout.getVisibility() == View.GONE) {
                root.sideMenuLayout.setVisibility(View.VISIBLE);
            } else {
                root.sideMenuLayout.setVisibility(View.GONE);
            }
        });
        root.icMenu.setOnClickListener(v -> {
            if (root.sideMenuLayout.getVisibility() == View.GONE) {
                root.sideMenuLayout.setVisibility(View.VISIBLE);
                root.overlayView.setVisibility(View.VISIBLE);
            } else {
                root.sideMenuLayout.setVisibility(View.GONE);
                root.overlayView.setVisibility(View.GONE);
            }
        });
        // Hide menu when clicking the overlay
        root.overlayView.setOnClickListener(v -> {
            root.sideMenuLayout.setVisibility(View.GONE);
            root.overlayView.setVisibility(View.GONE);
        });


        // Show emergency categories
        root.emReport.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.VISIBLE);
            root.emReport.setVisibility(View.GONE);
            root.emHotLine.setVisibility(View.GONE);
        });

        // When Medical is selected
        root.btnMedical.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.medicalOptionsLayout.setVisibility(View.VISIBLE);
        });

        // When Vehicular is selected
        root.btnVehicular.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.vehicularOptionsLayout.setVisibility(View.VISIBLE);
        });

        // When Disaster is selected
        root.btnDisaster.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.disasterOptionsLayout.setVisibility(View.VISIBLE);
        });

        // --- This is for medical assistance options ---
        root.btnHeartAttack.setOnClickListener(v -> {
            selectedMedicalCondition = "Heart Attack";
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            root.btnHeartAttack.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.btnHighFever.setOnClickListener(v -> {
            selectedMedicalCondition = "High Fever";
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            root.btnHighFever.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.edtOtherMedical.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                selectedMedicalCondition = "";
                resetMedicalButtons();
            }
        });

        root.btnSubmitMedical.setOnClickListener(v -> {
            String otherInput = root.edtOtherMedical.getText().toString().trim();
            if (!otherInput.isEmpty()) {
                selectedMedicalCondition = otherInput;
            }

            if (selectedMedicalCondition.isEmpty()) {
                Toast.makeText(this, "Please select or enter a medical condition.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedMedicalCondition, Toast.LENGTH_SHORT).show();
            root.medicalOptionsLayout.setVisibility(View.GONE);
            root.emReport.setVisibility(View.VISIBLE);
            root.emHotLine.setVisibility(View.VISIBLE);
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            selectedMedicalCondition = "";
        });

        // --- This is vehicular options ---
        root.btnOneCasualty.setOnClickListener(v -> {
            selectedVehicularCondition = "One Casualty";
            resetVehicularButtons();
            root.btnOneCasualty.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.btnMultipleCasualty.setOnClickListener(v -> {
            selectedVehicularCondition = "Multiple Casualty";
            resetVehicularButtons();
            root.btnMultipleCasualty.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.btnSubmitVehicular.setOnClickListener(v -> {
            if (selectedVehicularCondition.isEmpty()) {
                Toast.makeText(this, "Please select a vehicular condition.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedVehicularCondition, Toast.LENGTH_SHORT).show();
            root.vehicularOptionsLayout.setVisibility(View.GONE);
            root.emReport.setVisibility(View.VISIBLE);
            root.emHotLine.setVisibility(View.VISIBLE);
            resetVehicularButtons();
            selectedVehicularCondition = "";
        });

        // ---This is for disaster options ---
        root.btnEarthquake.setOnClickListener(v -> {
            selectedDisasterCondition = "Earthquake";
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            root.btnEarthquake.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.btnTyphoon.setOnClickListener(v -> {
            selectedDisasterCondition = "Typhoon";
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            root.btnTyphoon.setBackgroundResource(R.drawable.flat_button_bg_selected);
        });

        root.edtOtherDisaster.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                selectedDisasterCondition = "";
                resetDisasterButtons();
            }
        });

        root.btnSubmitDisaster.setOnClickListener(v -> {
            String otherInput = root.edtOtherDisaster.getText().toString().trim();
            if (!otherInput.isEmpty()) {
                selectedDisasterCondition = otherInput;
            }

            if (selectedDisasterCondition.isEmpty()) {
                Toast.makeText(this, "Please select or enter a disaster type.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedDisasterCondition, Toast.LENGTH_SHORT).show();
            root.disasterOptionsLayout.setVisibility(View.GONE);
            root.emReport.setVisibility(View.VISIBLE);
            root.emHotLine.setVisibility(View.VISIBLE);
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            selectedDisasterCondition = "";
        });
        // Show emergency number categories
        root.emHotLine.setOnClickListener(v -> {
            root.EmergencyNumOptionsLayout.setVisibility(View.VISIBLE);
            root.emReport.setVisibility(View.GONE);
            root.emHotLine.setVisibility(View.GONE);
        });
        // This method of SMS will redirect to the SMS outside the system
        root.btnGlobeSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09773289562"));  // Replace with real hotline number
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });

        root.btnSmartSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09395131408"));  // Replace with real hotline number
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });
    }

    private void resetMedicalButtons() {
        root.btnHeartAttack.setBackgroundResource(R.drawable.flat_button_bg);
        root.btnHighFever.setBackgroundResource(R.drawable.flat_button_bg);
    }

    private void resetVehicularButtons() {
        root.btnOneCasualty.setBackgroundResource(R.drawable.flat_button_bg);
        root.btnMultipleCasualty.setBackgroundResource(R.drawable.flat_button_bg);
    }

    private void resetDisasterButtons() {
        root.btnEarthquake.setBackgroundResource(R.drawable.flat_button_bg);
        root.btnTyphoon.setBackgroundResource(R.drawable.flat_button_bg);
    }
}