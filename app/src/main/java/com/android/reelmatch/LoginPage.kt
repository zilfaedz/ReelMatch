package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class LoginPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedEmail = sharedPref.getString("EMAIL", null)
        val savedPassword = sharedPref.getString("PASSWORD", null)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        val editEmail: EditText = findViewById(R.id.email_edit)
        val editPassword: EditText = findViewById(R.id.edit_password)
        val buttonLogin: Button = findViewById(R.id.login_button)
        val togglePassword: ImageView = findViewById(R.id.password_toggle)

        val customTypeface = ResourcesCompat.getFont(this, R.font.roboto_condensed)
        editPassword.typeface = customTypeface

        intent.getStringExtra("EMAIL")?.let { editEmail.setText(it) }
        intent.getStringExtra("PASSWORD")?.let { editPassword.setText(it) }

        var isPasswordVisible = false
        togglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                editPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.opened_eye)
            } else {
                editPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.closed_eye)
            }
            editPassword.typeface = customTypeface
            editPassword.setSelection(editPassword.text.length)
        }

        if (isLoggedIn) {
            startActivity(Intent(this, DashboardPage::class.java))
            finish()
            return
        }

        buttonLogin.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email or Password cannot be empty.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                with(sharedPref.edit()) {
                    putBoolean("isLoggedIn", true)
                    apply()
                }
                startActivity(Intent(this, DashboardPage::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password.", Toast.LENGTH_SHORT).show()
            }
        }

        val signupButton: Button = findViewById(R.id.signup_button)
        signupButton.setOnClickListener {
            val intent = Intent(this, SignupPage::class.java)
            startActivity(intent)
        }
    }
}