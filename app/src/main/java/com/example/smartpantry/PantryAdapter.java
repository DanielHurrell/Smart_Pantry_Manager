package com.example.smartpantry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.PantryViewHolder> {

    private List<PantryItem> pantryItems;
    private OnPantryItemActionListener listener;

    public interface OnPantryItemActionListener {
        void onEdit(PantryItem item);
        void onDelete(PantryItem item);
    }

    public PantryAdapter(
            List<PantryItem> pantryItems,
            OnPantryItemActionListener listener) {

        this.pantryItems = pantryItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PantryViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);

        return new PantryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull PantryViewHolder holder,
            int position) {

        PantryItem item = pantryItems.get(position);

        holder.tvIngredientName.setText(item.getName());

        String details = item.getQuantity() + " " + item.getUnit();
        holder.tvIngredientDetails.setText(details);

        if (item.getExpiryDate() == null || item.getExpiryDate().isEmpty()) {
            holder.tvExpiryDate.setText("No expiry date");
        } else {
            holder.tvExpiryDate.setText(
                    "Expires: " + item.getExpiryDate()
            );
        }

        holder.btnEdit.setOnClickListener(v -> {
            listener.onEdit(item);
        });

        holder.btnDelete.setOnClickListener(v -> {
            listener.onDelete(item);
        });
    }

    @Override
    public int getItemCount() {
        return pantryItems.size();
    }

    public static class PantryViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvIngredientName;
        TextView tvIngredientDetails;
        TextView tvExpiryDate;

        Button btnEdit;
        Button btnDelete;

        public PantryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIngredientName =
                    itemView.findViewById(R.id.tvIngredientName);

            tvIngredientDetails =
                    itemView.findViewById(R.id.tvIngredientDetails);

            tvExpiryDate =
                    itemView.findViewById(R.id.tvExpiryDate);

            btnEdit =
                    itemView.findViewById(R.id.btnEdit);

            btnDelete =
                    itemView.findViewById(R.id.btnDelete);
        }
    }
}