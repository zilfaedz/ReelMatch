package com.android.reelmatch

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignupPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val editFirstName: EditText = findViewById(R.id.firstname)
        val editLastName: EditText = findViewById(R.id.lastname)
        val editEmail: EditText = findViewById(R.id.email_edit)
        val editPassword: EditText = findViewById(R.id.edit_password)
        val editConfirmPassword: EditText = findViewById(R.id.edit_confirmpassword)
        val signUpButton: Button = findViewById(R.id.signup_button)

        val ruleLength: TextView = findViewById(R.id.rule_length)
        val ruleUpper: TextView = findViewById(R.id.rule_uppercase)
        val ruleSpecial: TextView = findViewById(R.id.rule_special)
        val ruleNumber: TextView = findViewById(R.id.rule_number)

        editPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val input = s.toString()

                ruleLength.setTextColor(
                    if (input.length >= 8) Color.parseColor("#0e452c") else Color.parseColor("#BFFFFFFF")
                )

                ruleUpper.setTextColor(
                    if (input.any { it.isUpperCase() }) Color.parseColor("#0e452c") else Color.parseColor("#BFFFFFFF")
                )

                ruleSpecial.setTextColor(
                    if (input.any { "!@#\$%^&*()-_=+{}[]|:;\"'<>,.?/".contains(it) }) Color.parseColor("#0e452c")
                    else Color.parseColor("#BFFFFFFF")
                )

                ruleNumber.setTextColor(
                    if (input.any { it.isDigit() }) Color.parseColor("#0e452c") else Color.parseColor("#BFFFFFFF")
                )
            }
        })

        signUpButton.setOnClickListener {
            val firstName = editFirstName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()
            val confirmPassword = editConfirmPassword.text.toString().trim()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isValidPassword(password)) {
                Toast.makeText(this, "Password must be at least 8 characters, include one uppercase letter, one special character, and one number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("NAME", "$firstName $lastName")
                putString("EMAIL", email)
                putString("PASSWORD", password)
                putBoolean("isLoggedIn", false)
                apply()
            }

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginPage::class.java)
            intent.putExtra("EMAIL", email)
            intent.putExtra("PASSWORD", password)
            startActivity(intent)
            finish()
        }

        val signinButton: Button = findViewById(R.id.signin_button)
        signinButton.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val regex = Regex("^(?=.*[A-Z])(?=.*[!@#\$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d).{8,}$")
        return password.matches(regex)
    }
}
