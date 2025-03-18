package com.android.reelmatch

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView

class DevelopersPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developers_page)

        val facebookSalonga: Button = findViewById(R.id.facebook_salonga)
        val instagramSalonga: Button = findViewById(R.id.instagram_salonga)

        val facebookQuirante: Button = findViewById(R.id.facebook_quirante)
        val instagramQuirante: Button = findViewById(R.id.instagram_quirante)
        val backButton : Button = findViewById(R.id.back_button)
        val homeButtom : Button = findViewById(R.id.home_button)
        val bottomView : View = findViewById(R.id.bottom_view)

        facebookSalonga.setOnClickListener { openUrl("https://web.facebook.com/andre.salonga") }
        instagramSalonga.setOnClickListener { openUrl("https://www.instagram.com/andre.salonga") }
        facebookQuirante.setOnClickListener { openUrl("https://web.facebook.com/zilfaedz.quirante") }
        instagramQuirante.setOnClickListener { openUrl("https://www.instagram.com/zilfaedz/") }
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }

        homeButtom.setOnClickListener {
            val intent = Intent(this, DashboardPage::class.java)
            startActivity(intent)
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
