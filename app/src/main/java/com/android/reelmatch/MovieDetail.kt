package com.android.reelmatch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.imageview.ShapeableImageView

class MovieDetail : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // Retrieve data from Intent
        val title = intent.getStringExtra("title")
        val imageResId = intent.getIntExtra("imageResId", 0)
        val rating = intent.getFloatExtra("rating", 0.0f)
        val description = intent.getStringExtra("description")
        val yearReleased = intent.getStringExtra("yearReleased")
        val director = intent.getStringExtra("director")
        val cast = intent.getStringArrayListExtra("cast")

        // Ensure you are using the correct view types
        val titleTextView: TextView = findViewById(R.id.movie_title)
        val imageView: ShapeableImageView = findViewById(R.id.movie_image)
        val ratingTextView: TextView = findViewById(R.id.rating)
        val descriptionTextView: TextView = findViewById(R.id.movie_description)
        val yearTextView: TextView = findViewById(R.id.movie_year)
        val directorTextView: TextView = findViewById(R.id.movie_director)
        val castContainer: LinearLayout = findViewById(R.id.cast_container)
        val backBtn: Button = findViewById(R.id.back_button)

        backBtn.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }

        // Set the values to the views
        titleTextView.text = title
        imageView.setImageResource(imageResId)
        ratingTextView.text = rating.toString()
        descriptionTextView.text = description
        yearTextView.text = yearReleased
        directorTextView.text = director

        // Clear previous cast views if any
        castContainer.removeAllViews()

        // Load custom font
        val typeface = ResourcesCompat.getFont(this, R.font.roboto_condensed)

        // Dynamically add cast members
        cast?.forEach { castMember ->
            val castTextView = TextView(this) // Create a new instance for each cast member
            castTextView.text = castMember
            castTextView.setTextColor(ContextCompat.getColor(this, R.color.white)) // Set text color
            castTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f) // Set text size
            castTextView.typeface = typeface // Set custom font
            castContainer.addView(castTextView) // Add the new TextView to the container
        }
    }
}