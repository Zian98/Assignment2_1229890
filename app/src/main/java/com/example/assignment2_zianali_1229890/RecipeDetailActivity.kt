package com.example.assignment2_zianali_1229890

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val recipeName = intent.getStringExtra("RECIPE_NAME")
        val recipeDetailTextView: TextView = findViewById(R.id.recipe_detail_text_view)
        recipeDetailTextView.text = recipeName ?: "No Recipe Details Available"

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }
    }
}
