package com.android.reelmatch

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DashboardPage : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_page)

        val profile : Button = findViewById(R.id.profile)
        val settings : Button = findViewById(R.id.settings)
        val developer : Button = findViewById(R.id.developers)

        profile.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        settings.setOnClickListener {
            val intent = Intent(this, SettingsPage::class.java)
            startActivity(intent)
        }

        developer.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }

    }
}
