package com.example.smartpantry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditIngredientActivity extends AppCompatActivity {

    private EditText etIngredientName;
    private EditText etQuantity;
    private EditText etUnit;
    private EditText etExpiryDate;

    private DatabaseHelper databaseHelper;

    private int pantryItemId = -1;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_ingredient);

        etIngredientName = findViewById(R.id.etIngredientName);
        etQuantity = findViewById(R.id.etQuantity);
        etUnit = findViewById(R.id.etUnit);
        etExpiryDate = findViewById(R.id.etExpiryDate);

        TextView tvFormTitle = findViewById(R.id.tvFormTitle);
        Button btnSaveIngredient = findViewById(R.id.btnSaveIngredient);

        databaseHelper = new DatabaseHelper(this);

        pantryItemId = getIntent().getIntExtra(
                "pantry_item_id",
                -1
        );

        if (pantryItemId != -1) {

            isEditMode = true;

            tvFormTitle.setText("Edit Ingredient");
            btnSaveIngredient.setText("Update Ingredient");

            loadPantryItem();

        }

        btnSaveIngredient.setOnClickListener(v -> saveIngredient());
    }

    private void loadPantryItem() {

        PantryItem item =
                databaseHelper.getPantryItem(pantryItemId);

        if (item != null) {

            etIngredientName.setText(item.getName());

            etQuantity.setText(
                    String.valueOf(item.getQuantity())
            );

            etUnit.setText(item.getUnit());

            if (item.getExpiryDate() != null) {
                etExpiryDate.setText(item.getExpiryDate());
            }
        }
    }

    private void saveIngredient() {

        String name =
                etIngredientName.getText().toString().trim();

        String quantityText =
                etQuantity.getText().toString().trim();

        String unit =
                etUnit.getText().toString().trim();

        String expiryDate =
                etExpiryDate.getText().toString().trim();

        if (name.isEmpty()) {

            etIngredientName.setError(
                    "Please enter an ingredient name"
            );

            etIngredientName.requestFocus();
            return;
        }

        if (quantityText.isEmpty()) {

            etQuantity.setError(
                    "Please enter a quantity"
            );

            etQuantity.requestFocus();
            return;
        }

        if (unit.isEmpty()) {

            etUnit.setError(
                    "Please enter a unit"
            );

            etUnit.requestFocus();
            return;
        }

        double quantity;

        try {

            quantity = Double.parseDouble(quantityText);

        } catch (NumberFormatException e) {

            etQuantity.setError(
                    "Please enter a valid quantity"
            );

            etQuantity.requestFocus();
            return;
        }

        if (quantity <= 0) {

            etQuantity.setError(
                    "Quantity must be greater than zero"
            );

            etQuantity.requestFocus();
            return;
        }

        long result;

        if (isEditMode) {

            result = databaseHelper.updatePantryItem(
                    pantryItemId,
                    name,
                    quantity,
                    unit,
                    expiryDate.isEmpty() ? null : expiryDate
            );

        } else {

            result = databaseHelper.addPantryItem(
                    name,
                    quantity,
                    unit,
                    expiryDate.isEmpty() ? null : expiryDate
            );
        }

        if (result != -1) {

            String message;

            if (isEditMode) {
                message = "Ingredient updated successfully";
            } else {
                message = "Ingredient added successfully";
            }

            Toast.makeText(
                    this,
                    message,
                    Toast.LENGTH_SHORT
            ).show();

            finish();

        } else {

            Toast.makeText(
                    this,
                    "Failed to save ingredient",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}