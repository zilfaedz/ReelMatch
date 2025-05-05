package com.android.reelmatch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MovieDetail : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val title = intent.getStringExtra("title")
        val imageResId = intent.getIntExtra("image", 0)
        val rating = intent.getFloatExtra("rating", 0.0f)

        val imageView: ImageView = findViewById(R.id.movie_image)
        val titleView: TextView = findViewById(R.id.movie_title)
        val ratingView: TextView = findViewById(R.id.rating)
        val backButton: Button = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }

        imageView.setImageResource(imageResId)
        titleView.text = title
        ratingView.text = "Rating: $rating"
    }
}