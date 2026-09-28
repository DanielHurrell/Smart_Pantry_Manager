package com.example.smartpantry;

import java.util.List;

public class RecipeMatcher {

    public static boolean canMakeRecipe(
            Recipe recipe,
            List<RecipeIngredient> ingredients,
            List<PantryItem> pantryItems) {

        for (RecipeIngredient required : ingredients) {

            boolean ingredientFound = false;

            for (PantryItem pantryItem : pantryItems) {

                String pantryName = normaliseName(pantryItem.getName());
                String requiredName = normaliseName(required.getIngredientName());

                if (pantryName.equals(requiredName)) {

                    if (normaliseUnit(pantryItem.getUnit())
                            .equals(normaliseUnit(required.getUnit()))) {

                        if (pantryItem.getQuantity()
                                >= required.getRequiredQuantity()) {

                            ingredientFound = true;
                            break;
                        }
                    }
                }
            }

            if (!ingredientFound) {
                return false;
            }
        }

        return true;
    }

    private static String normaliseName(String name) {

        name = name.toLowerCase().trim();

        if (name.endsWith("ies")) {
            name = name.substring(0, name.length() - 3) + "y";
        } else if (name.endsWith("oes")) {
            name = name.substring(0, name.length() - 2);
        } else if (name.endsWith("es")) {
            name = name.substring(0, name.length() - 2);
        } else if (name.endsWith("s")) {
            name = name.substring(0, name.length() - 1);
        }

        return name;
    }

    private static String normaliseUnit(String unit) {

        unit = unit.toLowerCase().trim();

        switch (unit) {
            case "grams":
            case "gram":
                return "g";

            case "kilograms":
            case "kilogram":
                return "kg";

            case "millilitres":
            case "milliliters":
            case "millilitre":
            case "milliliter":
                return "ml";

            case "litres":
            case "liters":
            case "litre":
            case "liter":
                return "l";

            case "pieces":
            case "pcs":
                return "piece";

            case "slices":
                return "slice";

            case "cloves":
                return "clove";

            case "cans":
                return "can";

            case "leaves":
                return "leaf";

            default:
                return unit;
        }
    }
}