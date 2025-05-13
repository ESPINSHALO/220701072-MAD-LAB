package com.example.recipe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        // Initialize views
        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val feedbackEditText = findViewById<TextInputEditText>(R.id.feedbackEditText)
        val submitButton = findViewById<MaterialButton>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val feedback = feedbackEditText.text.toString()

            if (name.isEmpty() || email.isEmpty() || feedback.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!email.contains("@")) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Here you would typically send the feedback to a server
            Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
} 