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

class PopularPage : Activity() {

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
            //popular
            Movie(
                title = "Mad Max: Fury Road",
                imageResId = R.drawable.mad_max_fury_road,
                rating = 8.1f,
                description = "In a post-apocalyptic wasteland, Max helps a rebellious woman escape a tyrant.",
                yearReleased = "2015",
                director = "George Miller",
                cast = listOf("Tom Hardy", "Charlize Theron")
            ),

            Movie(
                title = "John Wick",
                imageResId = R.drawable.john_wick,
                rating = 7.4f,
                description = "An ex-hitman comes out of retirement to track down the gangsters that killed his dog.",
                yearReleased = "2014",
                director = "Chad Stahelski",
                cast = listOf("Keanu Reeves", "Michael Nyqvist")
            ),

            Movie(
                title = "Die Hard",
                imageResId = R.drawable.die_hard,
                rating = 8.2f,
                description = "An NYPD officer tries to save his wife and others taken hostage during a Christmas party.",
                yearReleased = "1988",
                director = "John McTiernan",
                cast = listOf("Bruce Willis", "Alan Rickman")
            ),

            Movie(
                title = "The Bourne Identity",
                imageResId = R.drawable.bourne_identity,
                rating = 7.9f,
                description = "A man with amnesia races to discover his true identity amidst a covert conspiracy.",
                yearReleased = "2002",
                director = "Doug Liman",
                cast = listOf("Matt Damon", "Franka Potente")
            ),

            Movie(
                title = "Gladiator",
                imageResId = R.drawable.gladiator,
                rating = 8.5f,
                description = "A betrayed Roman general seeks revenge against the corrupt emperor who murdered his family.",
                yearReleased = "2000",
                director = "Ridley Scott",
                cast = listOf("Russell Crowe", "Joaquin Phoenix")
            ),

            Movie(
                title = "The Dark Knight",
                imageResId = R.drawable.dark_knight,
                rating = 9.0f,
                description = "Batman faces off against the Joker, a criminal mastermind who seeks to destroy Gotham.",
                yearReleased = "2008",
                director = "Christopher Nolan",
                cast = listOf("Christian Bale", "Heath Ledger")
            ),

            Movie(
                title = "Inception",
                imageResId = R.drawable.inception,
                rating = 8.8f,
                description = "A thief who steals corporate secrets through dreams is given a chance to erase his past.",
                yearReleased = "2010",
                director = "Christopher Nolan",
                cast = listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")
            ),

            Movie(
                title = "The Matrix",
                imageResId = R.drawable.the_matrix,
                rating = 8.7f,
                description = "A hacker discovers the world is a simulation and joins a rebellion against its controllers.",
                yearReleased = "1999",
                director = "Lana Wachowski, Lilly Wachowski",
                cast = listOf("Keanu Reeves", "Laurence Fishburne")
            ),

            Movie(
                title = "Casino Royale",
                imageResId = R.drawable.casino_royale,
                rating = 8.0f,
                description = "James Bond's first mission as 007 leads him to a high-stakes poker game in Montenegro.",
                yearReleased = "2006",
                director = "Martin Campbell",
                cast = listOf("Daniel Craig", "Eva Green")
            ),

            Movie(
                title = "Skyfall",
                imageResId = R.drawable.skyfall,
                rating = 7.8f,
                description = "James Bond's loyalty to M is tested as her past comes back to haunt her.",
                yearReleased = "2012",
                director = "Sam Mendes",
                cast = listOf("Daniel Craig", "Judi Dench")
            ),

            Movie(
                title = "Mission: Impossible - Fallout",
                imageResId = R.drawable.mission_impossible_fallout,
                rating = 7.7f,
                description = "Ethan Hunt and his team race against time after a mission goes wrong.",
                yearReleased = "2018",
                director = "Christopher McQuarrie",
                cast = listOf("Tom Cruise", "Henry Cavill")
            ),

            Movie(
                title = "The Avengers: Endgame",
                imageResId = R.drawable.avengers,
                rating = 8.0f,
                description = "The Avengers assemble once more to undo Thanos' destruction and restore balance.",
                yearReleased = "2019",
                director = "Anthony Russo, Joe Russo",
                cast = listOf("Robert Downey Jr.", "Chris Evans", "Scarlett Johansson")
            ),

            Movie(
                title = "Spider-Man: No Way Home",
                imageResId = R.drawable.spiderman_no_way_home,
                rating = 8.3f,
                description = "Peter Parker seeks help from Doctor Strange when his identity is revealed to the world.",
                yearReleased = "2021",
                director = "Jon Watts",
                cast = listOf("Tom Holland", "Zendaya", "Benedict Cumberbatch")
            ),

            Movie(
                title = "Black Panther",
                imageResId = R.drawable.black_panther,
                rating = 7.3f,
                description = "T'Challa returns home to Wakanda to take his place as king and face a powerful adversary.",
                yearReleased = "2018",
                director = "Ryan Coogler",
                cast = listOf("Chadwick Boseman", "Michael B. Jordan")
            ),

            Movie(
                title = "Wonder Woman",
                imageResId = R.drawable.wonder_woman,
                rating = 7.4f,
                description = "Diana, princess of the Amazons, discovers her full powers during World War I.",
                yearReleased = "2017",
                director = "Patty Jenkins",
                cast = listOf("Gal Gadot", "Chris Pine")
            ),
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
