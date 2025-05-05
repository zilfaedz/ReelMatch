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

class DocumentaryPage : Activity() {

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
                title = "13th",
                imageResId = R.drawable.thirteenth,
                rating = 8.2f,
                description = "An in-depth look at the U.S. prison system and how it reveals the nation's history of racial inequality.",
                yearReleased = "2016",
                director = "Ava DuVernay",
                cast = listOf("Ava DuVernay", "Jelani Cobb", "Angela Davis")
            ),
            Movie(
                title = "Won’t You Be My Neighbor?",
                imageResId = R.drawable.wont_you_be_my_neighbor,
                rating = 8.4f,
                description = "A documentary about Fred Rogers and the philosophy behind 'Mister Rogers' Neighborhood'.",
                yearReleased = "2018",
                director = "Morgan Neville",
                cast = listOf("Fred Rogers", "Joanne Rogers", "John Rogers")
            ),
            Movie(
                title = "Free Solo",
                imageResId = R.drawable.free_solo,
                rating = 8.4f,
                description = "Follows rock climber Alex Honnold as he attempts to conquer the first free solo climb of El Capitan.",
                yearReleased = "2018",
                director = "Elizabeth Chai Vasarhelyi & Jimmy Chin",
                cast = listOf("Alex Honnold", "Tommy Caldwell", "Jimmy Chin")
            ),
            Movie(
                title = "The Social Dilemma",
                imageResId = R.drawable.the_social_dilemma,
                rating = 7.6f,
                description = "Explores the dangerous human impact of social networking, with tech experts sounding the alarm.",
                yearReleased = "2020",
                director = "Jeff Orlowski",
                cast = listOf("Tristan Harris", "Jeff Seibert", "Bailey Richardson")
            ),
            Movie(
                title = "Amy",
                imageResId = R.drawable.amy,
                rating = 7.8f,
                description = "A look at the life of singer Amy Winehouse and her struggles with fame, addiction, and love.",
                yearReleased = "2015",
                director = "Asif Kapadia",
                cast = listOf("Amy Winehouse", "Mitch Winehouse", "Mark Ronson")
            ),
            Movie(
                title = "Blackfish",
                imageResId = R.drawable.blackfish,
                rating = 8.1f,
                description = "Tells the story of Tilikum, a performing killer whale, and the consequences of keeping such creatures in captivity.",
                yearReleased = "2013",
                director = "Gabriela Cowperthwaite",
                cast = listOf("Tilikum", "John Hargrove", "Samantha Berg")
            ),
            Movie(
                title = "Jiro Dreams of Sushi",
                imageResId = R.drawable.jiro_dreams_of_sushi,
                rating = 7.9f,
                description = "A documentary on 85-year-old sushi master Jiro Ono, his famous Tokyo restaurant, and his quest for perfection.",
                yearReleased = "2011",
                director = "David Gelb",
                cast = listOf("Jiro Ono", "Yoshikazu Ono", "Masuhiro Yamamoto")
            ),
            Movie(
                title = "Man on Wire",
                imageResId = R.drawable.man_on_wire,
                rating = 7.7f,
                description = "An account of Philippe Petit's 1974 high-wire walk between the Twin Towers of the World Trade Center.",
                yearReleased = "2008",
                director = "James Marsh",
                cast = listOf("Philippe Petit", "Jean François Heckel", "Jean-Louis Blondeau")
            ),
            Movie(
                title = "The Cove",
                imageResId = R.drawable.the_cove,
                rating = 8.4f,
                description = "Exposes the horrifying dolphin hunting practices in Taiji, Japan, and the activists trying to stop it.",
                yearReleased = "2009",
                director = "Louie Psihoyos",
                cast = listOf("Richard O'Barry", "Louie Psihoyos", "Hardy Jones")
            ),
            Movie(
                title = "Icarus",
                imageResId = R.drawable.icarus,
                rating = 7.9f,
                description = "When filmmaker Bryan Fogel sets out to uncover doping in sports, he stumbles upon a global scandal.",
                yearReleased = "2017",
                director = "Bryan Fogel",
                cast = listOf("Bryan Fogel", "Grigory Rodchenkov", "Nikita Kamaev")
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
