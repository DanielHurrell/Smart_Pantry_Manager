package com.example.smartpantry;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private TextView tvRecipeDetailName;
    private TextView tvRecipeIngredients;
    private TextView tvRecipeInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        databaseHelper = new DatabaseHelper(this);

        tvRecipeDetailName = findViewById(R.id.tvRecipeDetailName);
        tvRecipeIngredients = findViewById(R.id.tvRecipeIngredients);
        tvRecipeInstructions = findViewById(R.id.tvRecipeInstructions);

        int recipeId = getIntent().getIntExtra("recipe_id", -1);

        if (recipeId != -1) {
            loadRecipe(recipeId);
        }
    }

    private void loadRecipe(int recipeId) {

        Recipe recipe = databaseHelper.getRecipe(recipeId);

        if (recipe == null) {
            return;
        }

        tvRecipeDetailName.setText(recipe.getName());
        tvRecipeInstructions.setText(recipe.getInstructions());

        List<RecipeIngredient> ingredients =
                databaseHelper.getRecipeIngredients(recipeId);

        StringBuilder ingredientText = new StringBuilder();

        for (RecipeIngredient ingredient : ingredients) {

            ingredientText.append("• ")
                    .append(ingredient.getIngredientName())
                    .append(" - ")
                    .append(ingredient.getRequiredQuantity())
                    .append(" ")
                    .append(ingredient.getUnit())
                    .append("\n");
        }

        tvRecipeIngredients.setText(ingredientText.toString());
    }
}