package com.example.smartpantry;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class RecipeData {

    public static void addRecipes(SQLiteDatabase db) {

        // 1. Chicken Fried Rice
        addRecipe(db,
                "Chicken Fried Rice",
                "Cook the rice. Fry the chicken and onion. Add the rice and egg. Stir-fry until cooked.",
                new String[][]{
                        {"Chicken", "300", "g"},
                        {"Rice", "500", "g"},
                        {"Onion", "1", "piece"},
                        {"Egg", "2", "piece"}
                });

        // 2. Tomato Pasta
        addRecipe(db,
                "Tomato Pasta",
                "Cook the pasta. Fry the onion and tomatoes. Add the cooked pasta and mix well.",
                new String[][]{
                        {"Pasta", "200", "g"},
                        {"Tomato", "3", "piece"},
                        {"Onion", "1", "piece"}
                });

        // 3. Chicken Pasta
        addRecipe(db,
                "Chicken Pasta",
                "Cook the pasta. Cook the chicken and onion. Combine with the pasta and serve.",
                new String[][]{
                        {"Pasta", "200", "g"},
                        {"Chicken", "300", "g"},
                        {"Onion", "1", "piece"}
                });

        // 4. Omelette
        addRecipe(db,
                "Omelette",
                "Beat the eggs. Fry the onion and tomatoes. Add the eggs and cook until set.",
                new String[][]{
                        {"Egg", "3", "piece"},
                        {"Onion", "1", "piece"},
                        {"Tomato", "1", "piece"}
                });

        // 5. Vegetable Stir Fry
        addRecipe(db,
                "Vegetable Stir Fry",
                "Chop the vegetables. Stir-fry the onion, carrot and pepper until cooked.",
                new String[][]{
                        {"Carrot", "2", "piece"},
                        {"Onion", "1", "piece"},
                        {"Pepper", "1", "piece"}
                });

        // 6. Chicken Curry
        addRecipe(db,
                "Chicken Curry",
                "Fry the onion. Add the chicken and curry powder. Cook until the chicken is done.",
                new String[][]{
                        {"Chicken", "400", "g"},
                        {"Onion", "1", "piece"},
                        {"Curry Powder", "10", "g"}
                });

        // 7. Fried Rice
        addRecipe(db,
                "Fried Rice",
                "Fry the onion and egg. Add the cooked rice and stir-fry until heated.",
                new String[][]{
                        {"Rice", "500", "g"},
                        {"Egg", "2", "piece"},
                        {"Onion", "1", "piece"}
                });

        // 8. Tuna Pasta
        addRecipe(db,
                "Tuna Pasta",
                "Cook the pasta. Drain the tuna and mix it with the pasta and tomato.",
                new String[][]{
                        {"Pasta", "200", "g"},
                        {"Tuna", "1", "can"},
                        {"Tomato", "2", "piece"}
                });

        // 9. Egg Sandwich
        addRecipe(db,
                "Egg Sandwich",
                "Boil the eggs. Slice them and place them between slices of bread.",
                new String[][]{
                        {"Egg", "2", "piece"},
                        {"Bread", "2", "slice"}
                });

        // 10. Chicken Sandwich
        addRecipe(db,
                "Chicken Sandwich",
                "Cook the chicken. Place the chicken, tomato and lettuce between bread.",
                new String[][]{
                        {"Chicken", "200", "g"},
                        {"Bread", "2", "slice"},
                        {"Tomato", "1", "piece"},
                        {"Lettuce", "2", "leaf"}
                });

        // 11. Pancakes
        addRecipe(db,
                "Pancakes",
                "Mix the flour, milk and eggs. Cook small portions in a frying pan.",
                new String[][]{
                        {"Flour", "200", "g"},
                        {"Milk", "250", "ml"},
                        {"Egg", "2", "piece"}
                });

        // 12. French Toast
        addRecipe(db,
                "French Toast",
                "Beat the eggs and milk together. Dip the bread into the mixture and fry.",
                new String[][]{
                        {"Bread", "2", "slice"},
                        {"Egg", "2", "piece"},
                        {"Milk", "100", "ml"}
                });

        // 13. Tomato Soup
        addRecipe(db,
                "Tomato Soup",
                "Cook the tomatoes and onion until soft. Blend until smooth and serve.",
                new String[][]{
                        {"Tomato", "5", "piece"},
                        {"Onion", "1", "piece"}
                });

        // 14. Garlic Pasta
        addRecipe(db,
                "Garlic Pasta",
                "Cook the pasta. Fry the garlic in oil and mix with the cooked pasta.",
                new String[][]{
                        {"Pasta", "200", "g"},
                        {"Garlic", "2", "clove"}
                });

        // 15. Chicken Wrap
        addRecipe(db,
                "Chicken Wrap",
                "Cook the chicken. Place the chicken, lettuce and tomato inside the wrap.",
                new String[][]{
                        {"Chicken", "200", "g"},
                        {"Wrap", "2", "piece"},
                        {"Lettuce", "2", "leaf"},
                        {"Tomato", "1", "piece"}
                });

        // 16. Beef Stir Fry
        addRecipe(db,
                "Beef Stir Fry",
                "Slice the beef and vegetables. Stir-fry everything until cooked.",
                new String[][]{
                        {"Beef", "300", "g"},
                        {"Onion", "1", "piece"},
                        {"Pepper", "1", "piece"}
                });

        // 17. Beef Tacos
        addRecipe(db,
                "Beef Tacos",
                "Cook the beef with onion. Fill the taco shells and add tomato.",
                new String[][]{
                        {"Beef", "300", "g"},
                        {"Taco Shell", "4", "piece"},
                        {"Onion", "1", "piece"},
                        {"Tomato", "2", "piece"}
                });

        // 18. Tuna Sandwich
        addRecipe(db,
                "Tuna Sandwich",
                "Mix the tuna and mayonnaise. Place the mixture between slices of bread.",
                new String[][]{
                        {"Tuna", "1", "can"},
                        {"Bread", "2", "slice"},
                        {"Mayonnaise", "20", "g"}
                });

        // 19. Vegetable Omelette
        addRecipe(db,
                "Vegetable Omelette",
                "Beat the eggs. Fry the vegetables and add the eggs. Cook until set.",
                new String[][]{
                        {"Egg", "3", "piece"},
                        {"Onion", "1", "piece"},
                        {"Pepper", "1", "piece"},
                        {"Tomato", "1", "piece"}
                });

        // 20. Chicken Soup
        addRecipe(db,
                "Chicken Soup",
                "Cook the chicken with onion and carrot in water until everything is cooked.",
                new String[][]{
                        {"Chicken", "300", "g"},
                        {"Carrot", "2", "piece"},
                        {"Onion", "1", "piece"}
                });
    }

    private static void addRecipe(SQLiteDatabase db,String name,String instructions,String[][] ingredients) {

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("instructions", instructions);

        long recipeId = db.insert("recipes", null, values);

        if (recipeId != -1) {

            for (String[] ingredient : ingredients) {

                ContentValues ingredientValues = new ContentValues();
                ingredientValues.put("recipe_id", recipeId);
                ingredientValues.put("ingredient_name", ingredient[0]);
                ingredientValues.put(
                        "required_quantity",
                        Double.parseDouble(ingredient[1])
                );
                ingredientValues.put("unit", ingredient[2]);

                db.insert(
                        "recipe_ingredients",
                        null,
                        ingredientValues
                );
            }
        }
    }
}