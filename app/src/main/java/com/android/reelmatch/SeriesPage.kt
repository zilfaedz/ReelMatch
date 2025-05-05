package com.android.reelmatch

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeriesPage : Activity() {

    private var selectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_page)

        val btnForYou: Button = findViewById(R.id.btn_foryou)
        val btnPopular: Button = findViewById(R.id.btn_popular)
        val btnDocumentaries: Button = findViewById(R.id.btn_documentaries)
        val btnAnime: Button = findViewById(R.id.btn_anime)
        val btnAction: Button = findViewById(R.id.btn_action)
        val btnSeries: Button = findViewById(R.id.btn_series)
        val btnRomance: Button = findViewById(R.id.btn_romance)
        val btnHorror: Button = findViewById(R.id.btn_horror)
        val btnFamily: Button = findViewById(R.id.btn_family)
        val btnScifi: Button = findViewById(R.id.btn_scifi)
        val btnMystery: Button = findViewById(R.id.btn_mystery)

        val allButtons = listOf(
            btnForYou, btnPopular, btnDocumentaries, btnAnime, btnAction,
            btnSeries, btnRomance, btnHorror, btnFamily, btnScifi, btnMystery
        )

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

            // Navigate to the corresponding page based on the button clicked
            when (v.id) {
                R.id.btn_foryou -> startActivity(Intent(this, DashboardPage::class.java))
                R.id.btn_popular -> startActivity(Intent(this, PopularPage::class.java))
                R.id.btn_documentaries -> startActivity(Intent(this, DocumentaryPage::class.java))
                R.id.btn_anime -> startActivity(Intent(this, AnimePage::class.java))
                R.id.btn_action -> startActivity(Intent(this, ActionPage::class.java))
                R.id.btn_series -> startActivity(Intent(this, SeriesPage::class.java))
                R.id.btn_romance -> startActivity(Intent(this, RomancePage::class.java))
                R.id.btn_horror -> startActivity(Intent(this, HorrorPage::class.java))
                R.id.btn_family -> startActivity(Intent(this, FamilyPage::class.java))
                R.id.btn_scifi -> startActivity(Intent(this, ScifiPage::class.java)) // Current page
                R.id.btn_mystery -> startActivity(Intent(this, MysteryPage::class.java))
            }
        }

        allButtons.forEach {
            it.setOnClickListener(buttonClickListener)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val movieList = listOf(
            Movie(
                title = "Breaking Bad",
                imageResId = R.drawable.breaking_bad,
                rating = 9.5f,
                description = "A high school chemistry teacher turned methamphetamine producer partners with a former student.",
                yearReleased = "2008",
                director = "Vince Gilligan",
                cast = listOf("Bryan Cranston", "Aaron Paul")
            ),
            Movie(
                title = "Game of Thrones",
                imageResId = R.drawable.game_of_thrones,
                rating = 9.2f,
                description = "Nine noble families fight for control over the lands of Westeros while an ancient enemy returns.",
                yearReleased = "2011",
                director = "David Benioff, D.B. Weiss",
                cast = listOf("Emilia Clarke", "Kit Harington", "Peter Dinklage")
            ),
            Movie(
                title = "Stranger Things",
                imageResId = R.drawable.stranger_things,
                rating = 8.7f,
                description = "A group of kids in a small town uncover secret government experiments and supernatural forces.",
                yearReleased = "2016",
                director = "The Duffer Brothers",
                cast = listOf("Millie Bobby Brown", "Finn Wolfhard", "Winona Ryder")
            ),
            Movie(
                title = "The Crown",
                imageResId = R.drawable.the_crown,
                rating = 8.7f,
                description = "A chronicle of Queen Elizabeth II's reign and the events that shaped the second half of the 20th century.",
                yearReleased = "2016",
                director = "Peter Morgan",
                cast = listOf("Claire Foy", "Olivia Colman", "Imelda Staunton")
            ),
            Movie(
                title = "The Mandalorian",
                imageResId = R.drawable.the_mandalorian,
                rating = 8.7f,
                description = "A lone bounty hunter in the outer reaches of the galaxy protects a mysterious child known as Grogu.",
                yearReleased = "2019",
                director = "Jon Favreau",
                cast = listOf("Pedro Pascal", "Gina Carano")
            ),
            Movie(
                title = "Queen's Gambit",
                imageResId = R.drawable.queens_gambit,
                rating = 8.6f,
                description = "An orphaned chess prodigy's rise to fame while battling addiction.",
                yearReleased = "2020",
                director = "Scott Frank",
                cast = listOf("Anya Taylor-Joy", "Marielle Heller")
            ),
            Movie(
                title = "Chernobyl",
                imageResId = R.drawable.chernobyl,
                rating = 9.4f,
                description = "A dramatization of the events surrounding the 1986 nuclear disaster in the Soviet Union.",
                yearReleased = "2019",
                director = "Johan Renck",
                cast = listOf("Jared Harris", "Stellan Skarsgård")
            ),
            Movie(
                title = "The Office",
                imageResId = R.drawable.the_office,
                rating = 9.0f,
                description = "A mockumentary on a group of typical office workers, where the workday consists of ego clashes and tedium.",
                yearReleased = "2005",
                director = "Greg Daniels",
                cast = listOf("Steve Carell", "Rainn Wilson", "John Krasinski")
            ),
            Movie(
                title = "Friends",
                imageResId = R.drawable.friends,
                rating = 8.9f,
                description = "Follows the personal and professional lives of six friends living in Manhattan.",
                yearReleased = "1994",
                director = "David Crane, Marta Kauffman",
                cast = listOf("Jennifer Aniston", "Courteney Cox", "Matthew Perry")
            ),
            Movie(
                title = "The Witcher",
                imageResId = R.drawable.the_witcher,
                rating = 8.2f,
                description = "Geralt of Rivia, a mutated monster-hunter for hire, struggles to find his place in a world of beasts and men.",
                yearReleased = "2019",
                director = "Lauren Schmidt Hissrich",
                cast = listOf("Henry Cavill", "Anya Chalotra", "Freya Allan")
            ),
            Movie(
                title = "Money Heist",
                imageResId = R.drawable.money_heist,
                rating = 8.3f,
                description = "A criminal mastermind known as the Professor plans the biggest heist in recorded history.",
                yearReleased = "2017",
                director = "Álex Pina",
                cast = listOf("Úrsula Corberó", "Álvaro Morte")
            ),
            Movie(
                title = "The Boys",
                imageResId = R.drawable.the_boys,
                rating = 8.7f,
                description = "A group of vigilantes set out to take down corrupt superheroes who abuse their powers.",
                yearReleased = "2019",
                director = "Eric Kripke",
                cast = listOf("Karl Urban", "Jack Quaid")
            ),
            Movie(
                title = "Narcos",
                imageResId = R.drawable.narcos,
                rating = 8.8f,
                description = "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.",
                yearReleased = "2015",
                director = "Chris Brancato, Carlo Bernard, Doug Miro",
                cast = listOf("Wagner Moura", "Pedro Pascal")
            )
            //Movie("",R.drawable.,10f)
        )

//        val adapter = MovieAdapter(movieList)
//        recyclerView.adapter = adapter
//        recyclerView.adapter = MovieAdapter(movieList)

        val adapter = MovieAdapter(movieList) { selectedMovie ->
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("title", selectedMovie.title)
            intent.putExtra("imageResId", selectedMovie.imageResId)   // use consistent key
            intent.putExtra("rating", selectedMovie.rating)
            intent.putExtra("description", selectedMovie.description)
            intent.putExtra("yearReleased", selectedMovie.yearReleased)
            intent.putExtra("director", selectedMovie.director)
            intent.putStringArrayListExtra("cast", ArrayList(selectedMovie.cast))
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}
