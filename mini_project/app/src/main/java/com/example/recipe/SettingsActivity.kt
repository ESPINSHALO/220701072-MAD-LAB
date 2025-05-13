package com.example.recipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        // Initialize switches
        val notificationsSwitch = findViewById<SwitchMaterial>(R.id.notificationsSwitch)
        val darkModeSwitch = findViewById<SwitchMaterial>(R.id.darkModeSwitch)

        // Set initial states
        notificationsSwitch.isChecked = true // Default to enabled
        darkModeSwitch.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Setup switch listeners
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Here you would typically save the notification preference
            // and update notification settings
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }
} 