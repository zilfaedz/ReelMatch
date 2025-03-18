package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.reelmatch.LoginPage

class SettingsPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_page)

        val profileButton: Button = findViewById(R.id.profile)
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        val profileIconButton: Button = findViewById(R.id.settings_profileicon)
        profileIconButton.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }

        val toProfilePage: Button = findViewById(R.id.toProfile_button)
        toProfilePage.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        val aboutTheTeam: Button = findViewById(R.id.about_the_team)
        aboutTheTeam.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }

        val aboutTheTeamIcon: Button = findViewById(R.id.settings_teamicon)
        aboutTheTeamIcon.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }

        val toDevelopersPage: Button = findViewById(R.id.toDevelopers_button)
        toDevelopersPage.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }

        val confirmationPopup: LinearLayout = findViewById(R.id.log_out_confirmation)
        val logOut: Button = findViewById(R.id.log_out)
        val noButton: Button = findViewById(R.id.no_button)
        val yesButton: Button = findViewById(R.id.yes_button)
        confirmationPopup.elevation = 10f

        logOut.setOnClickListener {
            confirmationPopup.visibility = View.VISIBLE
        }

        noButton.setOnClickListener {
            confirmationPopup.visibility = View.GONE
        }

        yesButton.setOnClickListener {
            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)

            finish()
            Toast.makeText(this, "Successfully Logged out.", Toast.LENGTH_LONG).show()
            return@setOnClickListener
        }

    }
}