package com.example.pizza;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizza.beans.Produit;

public class DetailleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detaille);
        Produit produit = (Produit) getIntent().getSerializableExtra("produit");

        if (produit != null) {
            ImageView imageView = findViewById(R.id.pizzapic);
            TextView nameTextView = findViewById(R.id.pizzatitle);
            TextView ingredientsTextView = findViewById(R.id.pizzatext2);
            TextView descriptionTextView = findViewById(R.id.pizzatext1);

            imageView.setImageResource(produit.getPhoto());
            nameTextView.setText(produit.getNom());
            ingredientsTextView.setText(produit.getDetaisIngred());

            descriptionTextView.setText(produit.getDescription());
        }

    }
}