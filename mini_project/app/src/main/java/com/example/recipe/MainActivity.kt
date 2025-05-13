package com.example.recipe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        // Setup category cards
        setupCategoryCards()

        // Setup bottom navigation
        setupBottomNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_add -> {
                val intent = Intent(this, AddRecipeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupCategoryCards() {
        val categories = mapOf(
            R.id.breakfastCard to "breakfast",
            R.id.lunchCard to "lunch",
            R.id.snacksCard to "snacks",
            R.id.juiceCard to "juice",
            R.id.dinnerCard to "dinner"
        )

        categories.forEach { (id, category) ->
            findViewById<MaterialCardView>(id).setOnClickListener {
                val intent = Intent(this, RecipeListActivity::class.java)
                intent.putExtra("category", category)
                startActivity(intent)
            }
        }
    }

    private fun setupBottomNavigation() {
        findViewById<BottomNavigationView>(R.id.bottomNavigation).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Already on home
                    true
                }
                R.id.navigation_feedback -> {
                    val intent = Intent(this, FeedbackActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}