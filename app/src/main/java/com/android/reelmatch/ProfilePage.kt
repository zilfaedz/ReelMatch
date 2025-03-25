package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ProfilePage : Activity() {
    private lateinit var nameText: TextView
    private lateinit var emailText: TextView
    private lateinit var bioText: TextView
    private lateinit var editButton: Button
    private lateinit var backButton: Button
    private lateinit var profileImage: ImageView

    companion object {
        const val REQUEST_EDIT_PROFILE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        nameText = findViewById(R.id.name_text)
        emailText = findViewById(R.id.email_text)
        bioText = findViewById(R.id.profile_bio)
        editButton = findViewById(R.id.edit_button)
        backButton = findViewById(R.id.back_button)
        profileImage = findViewById(R.id.profile_icon)


        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        nameText.text = sharedPref.getString("NAME", "")
        emailText.text = sharedPref.getString("EMAIL", "")
        bioText.text = sharedPref.getString("BIO", "")

        editButton.setOnClickListener {
            val intent = Intent(this, ProfileSettingsPage::class.java)
            intent.putExtra("NAME", nameText.text.toString())
            intent.putExtra("EMAIL", emailText.text.toString())
            intent.putExtra("BIO", bioText.text.toString())
            startActivityForResult(intent, REQUEST_EDIT_PROFILE)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_EDIT_PROFILE && resultCode == RESULT_OK && data != null) {
            val newName = data.getStringExtra("NAME")
            val newEmail = data.getStringExtra("EMAIL")
            val newBio = data.getStringExtra("BIO")
            val newProfileImageUri = data.getStringExtra("PROFILE_IMAGE_URI")

            nameText.text = newName ?: ""
            emailText.text = newEmail ?: ""
            bioText.text = newBio ?: ""

            if (!newProfileImageUri.isNullOrEmpty()) {
                val imageUri = Uri.parse(newProfileImageUri)
                profileImage.setImageURI(imageUri)

                val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE).edit()
                sharedPref.putString("PROFILE_IMAGE", newProfileImageUri)
                sharedPref.apply()
            }
        }
    }
}
