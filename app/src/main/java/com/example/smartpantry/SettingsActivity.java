package com.example.smartpantry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    private CheckBox checkExpiryAlerts;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        checkExpiryAlerts = findViewById(R.id.checkExpiryAlerts);

        preferences = getSharedPreferences(
                "SmartPantrySettings",
                MODE_PRIVATE
        );

        boolean expiryAlertsEnabled = preferences.getBoolean(
                "expiry_alerts",
                true
        );

        checkExpiryAlerts.setChecked(expiryAlertsEnabled);

        checkExpiryAlerts.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {

                    preferences.edit()
                            .putBoolean("expiry_alerts", isChecked)
                            .apply();
                }
        );

        Button btnNavPantry = findViewById(R.id.btnNavPantry);
        Button btnNavRecipes = findViewById(R.id.btnNavRecipes);
        Button btnNavSettings = findViewById(R.id.btnNavSettings);

        btnNavPantry.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SettingsActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
        });

        btnNavRecipes.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SettingsActivity.this,
                    SuggestedRecipesActivity.class
            );

            startActivity(intent);
        });

        btnNavSettings.setOnClickListener(v -> {
            // Already on Settings screen
        });
    }
}