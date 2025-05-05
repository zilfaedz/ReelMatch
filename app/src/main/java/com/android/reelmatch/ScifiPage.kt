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

class ScifiPage : Activity() {

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
                title = "Blade Runner 2049",
                imageResId = R.drawable.blade_runner,
                rating = 8.0f,
                description = "A young blade runner's discovery of a long-buried secret leads him to track down former blade runner Rick Deckard.",
                yearReleased = "2017",
                director = "Denis Villeneuve",
                cast = listOf("Ryan Gosling", "Harrison Ford", "Ana de Armas")
            ),
            Movie(
                title = "Dune",
                imageResId = R.drawable.dune,
                rating = 8.1f,
                description = "A noble family becomes embroiled in a war for control over the galaxy's most valuable asset while its heir becomes troubled by visions of a dark future.",
                yearReleased = "2021",
                director = "Denis Villeneuve",
                cast = listOf("Timothée Chalamet", "Zendaya", "Oscar Isaac")
            ),
            Movie(
                title = "Arrival",
                imageResId = R.drawable.arrival,
                rating = 7.9f,
                description = "A linguist is recruited by the military to assist in translating alien communications.",
                yearReleased = "2016",
                director = "Denis Villeneuve",
                cast = listOf("Amy Adams", "Jeremy Renner", "Forest Whitaker")
            ),
            Movie(
                title = "Ex Machina",
                imageResId = R.drawable.ex_machina,
                rating = 7.7f,
                description = "A young programmer is selected to participate in a groundbreaking experiment in synthetic intelligence by evaluating the human qualities of a highly advanced humanoid A.I.",
                yearReleased = "2014",
                director = "Alex Garland",
                cast = listOf("Alicia Vikander", "Domhnall Gleeson", "Oscar Isaac")
            ),
            Movie(
                title = "Edge of Tomorrow",
                imageResId = R.drawable.edge_of_tomorrow,
                rating = 7.9f,
                description = "A public relations officer is caught in a time loop during a war with an alien race, forcing him to relive his death over and over again.",
                yearReleased = "2014",
                director = "Doug Liman",
                cast = listOf("Tom Cruise", "Emily Blunt", "Bill Paxton")
            ),
            Movie(
                title = "Interstellar",
                imageResId = R.drawable.interstellar,
                rating = 9.0f,
                description = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                yearReleased = "2014",
                director = "Christopher Nolan",
                cast = listOf("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain")
            ),
            Movie(
                title = "Avatar",
                imageResId = R.drawable.avatar,
                rating = 7.9f,
                description = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                yearReleased = "2009",
                director = "James Cameron",
                cast = listOf("Sam Worthington", "Zoe Saldana", "Sigourney Weaver")
            ),
            Movie(
                title = "Avatar: The Way of Water",
                imageResId = R.drawable.avatar2,
                rating = 7.8f,
                description = "Jake Sully and Neytiri have formed a family and are doing everything to stay together. However, they must leave their home and explore the regions of Pandora.",
                yearReleased = "2022",
                director = "James Cameron",
                cast = listOf("Sam Worthington", "Zoe Saldana", "Sigourney Weaver")
            ),
            Movie(
                title = "I Am Legend",
                imageResId = R.drawable.i_am_legend,
                rating = 7.2f,
                description = "A scientist is the last man on Earth, but he is not alone as he must battle nocturnal mutants in a post-apocalyptic world.",
                yearReleased = "2007",
                director = "Francis Lawrence",
                cast = listOf("Will Smith", "Alice Braga", "Charlie Tahan")
            ),
            Movie(
                title = "Oblivion",
                imageResId = R.drawable.oblivion,
                rating = 7.0f,
                description = "A drone repairman stationed on an abandoned Earth begins to question his mission and his reality when he encounters a mysterious woman.",
                yearReleased = "2013",
                director = "Joseph Kosinski",
                cast = listOf("Tom Cruise", "Morgan Freeman", "Olga Kurylenko")
            ),
            Movie(
                title = "The Fifth Element",
                imageResId = R.drawable.fifth_element,
                rating = 7.6f,
                description = "In the future, a cab driver becomes the unlikely hero who must save the world from a cosmic force of evil.",
                yearReleased = "1997",
                director = "Luc Besson",
                cast = listOf("Bruce Willis", "Milla Jovovich", "Gary Oldman")
            ),
            Movie(
                title = "Minority Report",
                imageResId = R.drawable.minority_report,
                rating = 7.6f,
                description = "In a future where crimes are prevented before they happen, a detective is accused of a crime he has yet to commit.",
                yearReleased = "2002",
                director = "Steven Spielberg",
                cast = listOf("Tom Cruise", "Colin Farrell", "Samantha Morton")
            ),
            Movie(
                title = "District 9",
                imageResId = R.drawable.district9,
                rating = 7.9f,
                description = "An extraterrestrial race forced to live in slum-like conditions on Earth suddenly finds a kindred spirit in a government agent who is exposed to their biotechnology.",
                yearReleased = "2009",
                director = "Neill Blomkamp",
                cast = listOf("Sharlto Copley", "David James", "Jason Cope")
            ),
            Movie(
                title = "Star Trek",
                imageResId = R.drawable.star_trek,
                rating = 7.9f,
                description = "The brash James T. Kirk tries to live up to his father’s legacy with the help of a talented crew of officers, led by Captain Spock.",
                yearReleased = "2009",
                director = "J.J. Abrams",
                cast = listOf("Chris Pine", "Zachary Quinto", "Leonard Nimoy")
            ),
            Movie(
                title = "Tenet",
                imageResId = R.drawable.tenet,
                rating = 7.3f,
                description = "Armed with only one word—Tenet—and fighting for the survival of the world, a protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                yearReleased = "2020",
                director = "Christopher Nolan",
                cast = listOf("John David Washington", "Robert Pattinson", "Elizabeth Debicki")
            ),
            Movie(
                title = "Moon",
                imageResId = R.drawable.moon,
                rating = 7.8f,
                description = "Astronaut Sam Bell has a quintessentially solitary assignment on the moon, where his only companion is a robot named GERTY. As his three-year stint nears its conclusion, Sam begins to question his reality.",
                yearReleased = "2009",
                director = "Duncan Jones",
                cast = listOf("Sam Rockwell", "Kevin Spacey", "Dominique McElligott")
            ),
            Movie(
                title = "Her",
                imageResId = R.drawable.her,
                rating = 8.0f,
                description = "In a future where technology has evolved beyond human relationships, a lonely man develops an unusual relationship with an operating system designed to meet his every need.",
                yearReleased = "2013",
                director = "Spike Jonze",
                cast = listOf("Joaquin Phoenix", "Amy Adams", "Scarlett Johansson")
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
