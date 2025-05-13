package com.example.recipe

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        // Initialize views
        val recipeNameEditText = findViewById<TextInputEditText>(R.id.recipeNameEditText)
        val categoryAutoComplete = findViewById<AutoCompleteTextView>(R.id.categoryAutoComplete)
        val cookingTimeEditText = findViewById<TextInputEditText>(R.id.cookingTimeEditText)
        val ingredientsEditText = findViewById<TextInputEditText>(R.id.ingredientsEditText)
        val instructionsEditText = findViewById<TextInputEditText>(R.id.instructionsEditText)
        val saveButton = findViewById<MaterialButton>(R.id.saveButton)

        // Setup category dropdown
        val categories = arrayOf("Breakfast", "Lunch", "Dinner", "Snacks", "Juice")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, categories)
        categoryAutoComplete.setAdapter(adapter)

        saveButton.setOnClickListener {
            val recipeName = recipeNameEditText.text.toString()
            val category = categoryAutoComplete.text.toString()
            val cookingTime = cookingTimeEditText.text.toString()
            val ingredients = ingredientsEditText.text.toString()
            val instructions = instructionsEditText.text.toString()

            if (recipeName.isEmpty() || category.isEmpty() || cookingTime.isEmpty() || 
                ingredients.isEmpty() || instructions.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Here you would typically save the recipe to a database
            Toast.makeText(this, "Recipe saved successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
} 