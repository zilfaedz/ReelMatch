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

class RomancePage : Activity() {

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
                title = "Pride & Prejudice",
                imageResId = R.drawable.pride_and_prejudice,
                rating = 7.8f,
                description = "Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud Mr. Darcy.",
                yearReleased = "2005",
                director = "Joe Wright",
                cast = listOf("Keira Knightley", "Matthew Macfadyen")
            ),

            Movie(
                title = "The Notebook",
                imageResId = R.drawable.the_notebook,
                rating = 7.8f,
                description = "A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom.",
                yearReleased = "2004",
                director = "Nick Cassavetes",
                cast = listOf("Ryan Gosling", "Rachel McAdams")
            ),

            Movie(
                title = "La La Land",
                imageResId = R.drawable.la_la_land,
                rating = 8.0f,
                description = "A jazz musician and an aspiring actress fall in love while pursuing their dreams in Los Angeles.",
                yearReleased = "2016",
                director = "Damien Chazelle",
                cast = listOf("Ryan Gosling", "Emma Stone")
            ),

            Movie(
                title = "Titanic",
                imageResId = R.drawable.titanic,
                rating = 7.8f,
                description = "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious Titanic.",
                yearReleased = "1997",
                director = "James Cameron",
                cast = listOf("Leonardo DiCaprio", "Kate Winslet")
            ),

            Movie(
                title = "Before Sunrise",
                imageResId = R.drawable.before_sunrise,
                rating = 8.1f,
                description = "A young man and woman meet on a train in Europe and spend one evening together in Vienna.",
                yearReleased = "1995",
                director = "Richard Linklater",
                cast = listOf("Ethan Hawke", "Julie Delpy")
            ),

            Movie(
                title = "Eternal Sunshine of the Spotless Mind",
                imageResId = R.drawable.eternal_sunshine,
                rating = 8.3f,
                description = "After a painful breakup, a couple undergoes a procedure to erase memories of each other.",
                yearReleased = "2004",
                director = "Michel Gondry",
                cast = listOf("Jim Carrey", "Kate Winslet")
            ),

            Movie(
                title = "Call Me by Your Name",
                imageResId = R.drawable.call_me_by_your_name,
                rating = 7.9f,
                description = "In 1980s Italy, romance blossoms between a seventeen-year-old student and the older man hired as his father's assistant.",
                yearReleased = "2017",
                director = "Luca Guadagnino",
                cast = listOf("Timothée Chalamet", "Armie Hammer")
            ),

            Movie(
                title = "Atonement",
                imageResId = R.drawable.atonement,
                rating = 7.8f,
                description = "Fledgling writer Briony Tallis irrevocably changes the course of several lives when she accuses her sister's lover of a crime he did not commit.",
                yearReleased = "2007",
                director = "Joe Wright",
                cast = listOf("Keira Knightley", "James McAvoy")
            ),

            Movie(
                title = "500 Days of Summer",
                imageResId = R.drawable.five_hundred_days_of_summer,
                rating = 7.7f,
                description = "An offbeat romantic comedy about a woman who doesn't believe true love exists and the young man who falls for her.",
                yearReleased = "2009",
                director = "Marc Webb",
                cast = listOf("Joseph Gordon-Levitt", "Zooey Deschanel")
            ),

            Movie(
                title = "Her",
                imageResId = R.drawable.her,
                rating = 8.0f,
                description = "In a near future, a lonely writer develops an unlikely relationship with an operating system designed to meet his every need.",
                yearReleased = "2013",
                director = "Spike Jonze",
                cast = listOf("Joaquin Phoenix", "Scarlett Johansson")
            ),

            Movie(
                title = "Mamma Mia",
                imageResId = R.drawable.mamma,
                rating = 8.3f,
                description = "The story of a young woman’s search for her birth father, told through ABBA songs.",
                yearReleased = "2008",
                director = "Phyllida Lloyd",
                cast = listOf("Meryl Streep", "Amanda Seyfried", "Pierce Brosnan")
            ),

            Movie(
                title = "P.S. I Love You",
                imageResId = R.drawable.ps_i_love_you,
                rating = 7.0f,
                description = "A young widow discovers that her late husband left her 10 messages intended to help ease her pain and start a new life.",
                yearReleased = "2007",
                director = "Richard LaGravenese",
                cast = listOf("Hilary Swank", "Gerard Butler")
            ),

            Movie(
                title = "Me Before You",
                imageResId = R.drawable.me_before_you,
                rating = 7.4f,
                description = "A young woman takes a job caring for a man who is paralyzed from the neck down.",
                yearReleased = "2016",
                director = "Thea Sharrock",
                cast = listOf("Emilia Clarke", "Sam Claflin")
            ),

            Movie(
                title = "The Fault in Our Stars",
                imageResId = R.drawable.fault_in_our_stars,
                rating = 7.7f,
                description = "Two teenage cancer patients begin a life-affirming journey to visit a reclusive author in Amsterdam.",
                yearReleased = "2014",
                director = "Josh Boone",
                cast = listOf("Shailene Woodley", "Ansel Elgort")
            ),

            Movie(
                title = "To All the Boys I've Loved Before",
                imageResId = R.drawable.to_all_the_boys,
                rating = 7.1f,
                description = "A teenage girl's secret love letters are exposed and wreak havoc on her love life.",
                yearReleased = "2018",
                director = "Susan Johnson",
                cast = listOf("Lana Condor", "Noah Centineo")
            ),

            Movie(
                title = "The Vow",
                imageResId = R.drawable.the_vow,
                rating = 6.8f,
                description = "A car accident puts Paige in a coma, and when she wakes up with severe memory loss, her husband Leo works to win her heart again.",
                yearReleased = "2012",
                director = "Michael Sucsy",
                cast = listOf("Rachel McAdams", "Channing Tatum")
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
