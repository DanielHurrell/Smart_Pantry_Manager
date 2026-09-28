package com.example.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.widget.Button;

public class SuggestedRecipesActivity extends AppCompatActivity
        implements RecipeAdapter.OnRecipeClickListener {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerRecipes;
    private TextView tvNoRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);

        databaseHelper = new DatabaseHelper(this);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        tvNoRecipes = findViewById(R.id.tvNoRecipes);

        Button btnNavPantry = findViewById(R.id.btnNavPantry);
        Button btnNavRecipes = findViewById(R.id.btnNavRecipes);
        Button btnNavSettings = findViewById(R.id.btnNavSettings);

        btnNavPantry.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SuggestedRecipesActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
        });

        btnNavRecipes.setOnClickListener(v -> {
            // Already on Recipes screen
        });

        btnNavSettings.setOnClickListener(v -> {
            Intent intent = new Intent(
                    SuggestedRecipesActivity.this,
                    SettingsActivity.class
            );

            startActivity(intent);
        });

        recyclerRecipes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        loadSuggestedRecipes();
    }

    private void loadSuggestedRecipes() {

        List<Recipe> allRecipes = databaseHelper.getAllRecipes();
        List<PantryItem> pantryItems =
                databaseHelper.getAllPantryItems();

        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            List<RecipeIngredient> ingredients =
                    databaseHelper.getRecipeIngredients(recipe.getId());

            if (RecipeMatcher.canMakeRecipe(
                    recipe,
                    ingredients,
                    pantryItems)) {

                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {

            tvNoRecipes.setVisibility(TextView.VISIBLE);
            recyclerRecipes.setVisibility(RecyclerView.GONE);

        } else {

            tvNoRecipes.setVisibility(TextView.GONE);
            recyclerRecipes.setVisibility(RecyclerView.VISIBLE);

            RecipeAdapter adapter =
                    new RecipeAdapter(matchingRecipes, this);

            recyclerRecipes.setAdapter(adapter);
        }
    }

    @Override
    public void onRecipeClick(Recipe recipe) {

        Intent intent = new Intent(
                this,
                RecipeDetailActivity.class
        );

        intent.putExtra("recipe_id", recipe.getId());

        startActivity(intent);
    }
}