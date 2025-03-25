package com.android.reelmatch

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardPage : Activity() {

    private var selectedButton: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_page)

        val profile: Button = findViewById(R.id.profile)
        val settings: Button = findViewById(R.id.settings)
        val developer: Button = findViewById(R.id.developers)

        profile.setOnClickListener {
            startActivity(Intent(this, ProfilePage::class.java))
        }

        settings.setOnClickListener {
            startActivity(Intent(this, SettingsPage::class.java))
        }

        developer.setOnClickListener {
            startActivity(Intent(this, DevelopersPage::class.java))
        }

        val btnForYou: Button = findViewById(R.id.btn_foryou)
        val btnPopular: Button = findViewById(R.id.btn_popular)
        val btnMovies: Button = findViewById(R.id.btn_movies)
        val btnDocumentaries: Button = findViewById(R.id.btn_documentaries)
        val btnAnime: Button = findViewById(R.id.btn_anime)

        val allButtons = listOf(btnForYou, btnPopular, btnMovies, btnDocumentaries, btnAnime)

        selectedButton = btnForYou
        selectedButton?.apply {
            isSelected = true
            setTypeface(null, Typeface.BOLD)
            refreshDrawableState()
        }

        val buttonClickListener = View.OnClickListener { v ->
            selectedButton?.apply {
                isSelected = false
                setTypeface(null, Typeface.NORMAL)
                refreshDrawableState()
            }

            selectedButton = v as Button
            selectedButton?.apply {
                isSelected = true
                setTypeface(null, Typeface.BOLD)
                refreshDrawableState()
            }
        }

        allButtons.forEach {
            it.setBackgroundResource(R.drawable.button_selector)
            it.setOnClickListener(buttonClickListener)
        }
    }
}