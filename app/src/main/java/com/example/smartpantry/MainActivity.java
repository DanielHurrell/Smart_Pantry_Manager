package com.example.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPantry;
    private TextView tvEmptyMessage;
    private DatabaseHelper databaseHelper;
    private PantryAdapter pantryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPantry = findViewById(R.id.recyclerPantry);
        tvEmptyMessage = findViewById(R.id.tvEmptyMessage);

        Button btnAddIngredient = findViewById(R.id.btnAddIngredient);

        databaseHelper = new DatabaseHelper(this);

        recyclerPantry.setLayoutManager(new LinearLayoutManager(this));

        btnAddIngredient.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AddEditIngredientActivity.class
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadPantryItems();
    }

    private void loadPantryItems() {

        List<PantryItem> pantryItems = databaseHelper.getAllPantryItems();

        if (pantryItems.isEmpty()) {

            recyclerPantry.setVisibility(View.GONE);
            tvEmptyMessage.setVisibility(View.VISIBLE);

        } else {

            recyclerPantry.setVisibility(View.VISIBLE);
            tvEmptyMessage.setVisibility(View.GONE);

            pantryAdapter = new PantryAdapter(pantryItems);
            recyclerPantry.setAdapter(pantryAdapter);
        }
    }
}