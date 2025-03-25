package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ProfileSettingsPage : Activity() {

    private lateinit var profileImageView: ImageView
    private lateinit var bioEditText: EditText
    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null
    private val MAX_BIO_LENGTH = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings_page)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val updateButton = findViewById<Button>(R.id.update_button)
        val firstName = findViewById<EditText>(R.id.edit_firstname)
        val lastName = findViewById<EditText>(R.id.edit_lastname)
        val email = findViewById<EditText>(R.id.edit_email)
        bioEditText = findViewById(R.id.edit_bio)
        profileImageView = findViewById(R.id.edit_profilepic)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        firstName.setText(sharedPref.getString("FIRST_NAME", ""))
        lastName.setText(sharedPref.getString("LAST_NAME", ""))
        email.setText(sharedPref.getString("EMAIL", ""))
        bioEditText.setText(sharedPref.getString("BIO", ""))

        val imagePath = sharedPref.getString("PROFILE_IMAGE", null)
        if (!imagePath.isNullOrEmpty()) {
            profileImageView.setImageURI(Uri.fromFile(File(imagePath)))
        }

        bioEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.length > MAX_BIO_LENGTH) {
                    bioEditText.error = "Bio cannot exceed 200 characters"
                    bioEditText.setText(s.subSequence(0, MAX_BIO_LENGTH)) // Trim excess
                    bioEditText.setSelection(MAX_BIO_LENGTH) // Move cursor to end
                }
            }
        })

        profileImageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        updateButton.setOnClickListener {
            val newName = "${firstName.text} ${lastName.text}".trim()
            val newEmail = email.text.toString()
            val newBio = bioEditText.text.toString()

            if (newBio.length > MAX_BIO_LENGTH) {
                Toast.makeText(this, "Bio must be under 200 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            with(sharedPref.edit()) {
                putString("FIRST_NAME", firstName.text.toString())
                putString("LAST_NAME", lastName.text.toString())
                putString("NAME", newName)
                putString("EMAIL", newEmail)
                putString("BIO", newBio)
                apply()
            }

            val resultIntent = Intent().apply {
                putExtra("NAME", newName)
                putExtra("EMAIL", newEmail)
                putExtra("BIO", newBio)
                if (selectedImageUri != null) {
                    putExtra("PROFILE_IMAGE_URI", selectedImageUri.toString())
                }
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        backButton.setOnClickListener { finish() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            if (selectedImageUri != null) {
                profileImageView.setImageURI(selectedImageUri)
                profileImageView.scaleType = ImageView.ScaleType.CENTER_CROP
                saveImageToStorage(selectedImageUri!!)
            }
        }
    }

    private fun saveImageToStorage(imageUri: Uri) {
        val file = File(getExternalFilesDir(null), "profile_pic.jpg")

        try {
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            outputStream.flush()
            outputStream.close()

            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("PROFILE_IMAGE", file.absolutePath)
                apply()
            }

            selectedImageUri = Uri.fromFile(file)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
