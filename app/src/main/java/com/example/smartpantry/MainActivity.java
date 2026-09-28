package com.example.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements PantryAdapter.OnPantryItemActionListener {

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

        Button btnNavPantry = findViewById(R.id.btnNavPantry);
        Button btnNavRecipes = findViewById(R.id.btnNavRecipes);
        Button btnNavSettings = findViewById(R.id.btnNavSettings);

        btnNavPantry.setOnClickListener(v -> {
            // Already on Pantry screen
        });

        btnNavRecipes.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    SuggestedRecipesActivity.class
            );

            startActivity(intent);
        });

        btnNavSettings.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    SettingsActivity.class
            );

            startActivity(intent);
        });

        databaseHelper = new DatabaseHelper(this);

        recyclerPantry.setLayoutManager(
                new LinearLayoutManager(this)
        );

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

        List<PantryItem> pantryItems =
                databaseHelper.getAllPantryItems();

        if (pantryItems.isEmpty()) {

            recyclerPantry.setVisibility(View.GONE);
            tvEmptyMessage.setVisibility(View.VISIBLE);

        } else {

            recyclerPantry.setVisibility(View.VISIBLE);
            tvEmptyMessage.setVisibility(View.GONE);

            pantryAdapter = new PantryAdapter(
                    pantryItems,
                    this
            );

            recyclerPantry.setAdapter(pantryAdapter);
        }
    }

    @Override
    public void onEdit(PantryItem item) {

        Intent intent = new Intent(
                MainActivity.this,
                AddEditIngredientActivity.class
        );

        intent.putExtra("pantry_item_id", item.getId());

        startActivity(intent);
    }

    @Override
    public void onDelete(PantryItem item) {

        int rowsDeleted =
                databaseHelper.deletePantryItem(item.getId());

        if (rowsDeleted > 0) {

            Toast.makeText(
                    this,
                    "Ingredient deleted",
                    Toast.LENGTH_SHORT
            ).show();

            loadPantryItems();

        } else {

            Toast.makeText(
                    this,
                    "Failed to delete ingredient",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}