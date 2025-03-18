package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ProfilePage : Activity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var bioTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var bioEditText: EditText
    private lateinit var editButton: Button
    private lateinit var updateButton: Button

    private val PREFSNAME = "UserPrefs"
    private val KEYNAME = "NAME"
    private val KEYEMAIL = "EMAIL"
    private val KEYBIO = "BIO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        nameTextView = findViewById(R.id.name_text)
        emailTextView = findViewById(R.id.email_text)
        bioTextView = findViewById(R.id.profile_bio)

        nameEditText = findViewById(R.id.name_edit)
        emailEditText = findViewById(R.id.email_edit)
        bioEditText = findViewById(R.id.bio_edit)

        editButton = findViewById(R.id.edit_button)
        updateButton = findViewById(R.id.update_button)

        loadProfileData()

        editButton.setOnClickListener {
            enableEditing()
        }

        updateButton.setOnClickListener {
            saveChanges()
        }

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }
    }

    private fun enableEditing() {
        nameEditText.setText(nameTextView.text)
        emailEditText.setText(emailTextView.text)
        bioEditText.setText(bioTextView.text)

        nameTextView.visibility = View.GONE
        emailTextView.visibility = View.GONE
        bioTextView.visibility = View.GONE

        nameEditText.visibility = View.VISIBLE
        emailEditText.visibility = View.VISIBLE
        bioEditText.visibility = View.VISIBLE

        editButton.visibility = View.GONE
        updateButton.visibility = View.VISIBLE
    }

    private fun saveChanges() {
        nameTextView.text = nameEditText.text.toString()
        emailTextView.text = emailEditText.text.toString()
        bioTextView.text = bioEditText.text.toString()

        saveProfileData()

        nameTextView.visibility = View.VISIBLE
        emailTextView.visibility = View.VISIBLE
        bioTextView.visibility = View.VISIBLE

        nameEditText.visibility = View.GONE
        emailEditText.visibility = View.GONE
        bioEditText.visibility = View.GONE

        editButton.visibility = View.VISIBLE
        updateButton.visibility = View.GONE
    }

    private fun saveProfileData() {
        val sharedPreferences = getSharedPreferences(PREFSNAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString(KEYNAME, nameTextView.text.toString())
            putString(KEYEMAIL, emailTextView.text.toString())
            putString(KEYBIO, bioTextView.text.toString())
            apply()
        }
    }

    private fun loadProfileData() {
        val sharedPreferences = getSharedPreferences(PREFSNAME, Context.MODE_PRIVATE)

        nameTextView.text = sharedPreferences.getString(KEYNAME, "Your Name")
        emailTextView.text = sharedPreferences.getString(KEYEMAIL, "your.email@example.com")
    }
}
