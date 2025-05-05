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

class HorrorPage : Activity() {

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
                title = "The Shining",
                imageResId = R.drawable.the_shining,
                rating = 8.4f,
                description = "A family heads to an isolated hotel where an evil presence influences the father into violence.",
                yearReleased = "1980",
                director = "Stanley Kubrick",
                cast = listOf("Jack Nicholson", "Shelley Duvall")
            ),

            Movie(
                title = "Get Out",
                imageResId = R.drawable.get_out,
                rating = 7.7f,
                description = "A Black man visits his white girlfriend's family estate and uncovers a disturbing secret.",
                yearReleased = "2017",
                director = "Jordan Peele",
                cast = listOf("Daniel Kaluuya", "Allison Williams")
            ),

            Movie(
                title = "A Quiet Place",
                imageResId = R.drawable.a_quiet_place,
                rating = 7.5f,
                description = "A family must live in silence while hiding from monsters that hunt by sound.",
                yearReleased = "2018",
                director = "John Krasinski",
                cast = listOf("Emily Blunt", "John Krasinski")
            ),

            Movie(
                title = "Hereditary",
                imageResId = R.drawable.hereditary,
                rating = 7.3f,
                description = "A family unravels dark secrets after the death of their secretive grandmother.",
                yearReleased = "2018",
                director = "Ari Aster",
                cast = listOf("Toni Collette", "Alex Wolff")
            ),

            Movie(
                title = "The Exorcist",
                imageResId = R.drawable.the_exorcist,
                rating = 8.1f,
                description = "When a young girl is possessed, her mother seeks the help of two priests to save her.",
                yearReleased = "1973",
                director = "William Friedkin",
                cast = listOf("Ellen Burstyn", "Max von Sydow")
            ),

            Movie(
                title = "Psycho",
                imageResId = R.drawable.psycho,
                rating = 8.5f,
                description = "A secretary embezzles money and checks into a remote motel run by a young man under his mother's domination.",
                yearReleased = "1960",
                director = "Alfred Hitchcock",
                cast = listOf("Anthony Perkins", "Janet Leigh")
            ),

            Movie(
                title = "The Conjuring",
                imageResId = R.drawable.the_conjuring,
                rating = 7.5f,
                description = "Paranormal investigators help a family terrorized by a dark presence in their farmhouse.",
                yearReleased = "2013",
                director = "James Wan",
                cast = listOf("Vera Farmiga", "Patrick Wilson")
            ),

            Movie(
                title = "The Babadook",
                imageResId = R.drawable.the_babadook,
                rating = 6.8f,
                description = "A single mother and her child fall into a deep well of paranoia when a disturbing book appears in their home.",
                yearReleased = "2014",
                director = "Jennifer Kent",
                cast = listOf("Essie Davis", "Noah Wiseman")
            ),

            Movie(
                title = "It",
                imageResId = R.drawable.it,
                rating = 7.3f,
                description = "A group of kids face their fears and a shape-shifting evil that takes the form of a clown.",
                yearReleased = "2017",
                director = "Andy Muschietti",
                cast = listOf("Bill Skarsgård", "Jaeden Martell")
            ),

            Movie(
                title = "Us",
                imageResId = R.drawable.us,
                rating = 6.8f,
                description = "A family's beach vacation turns terrifying when their doppelgängers appear.",
                yearReleased = "2019",
                director = "Jordan Peele",
                cast = listOf("Lupita Nyong'o", "Winston Duke")
            ),

            Movie(
                title = "The Invisible Man",
                imageResId = R.drawable.invisible_man,
                rating = 7.1f,
                description = "A woman believes she is being stalked by her abusive ex-boyfriend after his apparent suicide.",
                yearReleased = "2020",
                director = "Leigh Whannell",
                cast = listOf("Elisabeth Moss", "Aldis Hodge")
            ),

            Movie(
                title = "It Follows",
                imageResId = R.drawable.it_follows,
                rating = 6.8f,
                description = "A young woman is followed by an unknown supernatural force after a sexual encounter.",
                yearReleased = "2014",
                director = "David Robert Mitchell",
                cast = listOf("Maika Monroe", "Keir Gilchrist")
            ),

            Movie(
                title = "Midsommar",
                imageResId = R.drawable.midsommar,
                rating = 7.1f,
                description = "A couple travels to Sweden for a festival that only occurs every 90 years, uncovering a sinister cult.",
                yearReleased = "2019",
                director = "Ari Aster",
                cast = listOf("Florence Pugh", "Jack Reynor")
            ),

            Movie(
                title = "The Witch",
                imageResId = R.drawable.the_witch,
                rating = 6.9f,
                description = "A Puritan family encounters forces of evil in the woods beyond their New England farm.",
                yearReleased = "2015",
                director = "Robert Eggers",
                cast = listOf("Anya Taylor-Joy", "Ralph Ineson")
            ),

            Movie(
                title = "Train to Busan",
                imageResId = R.drawable.train_to_busan,
                rating = 7.6f,
                description = "While a zombie virus breaks out in South Korea, passengers struggle to survive on the train to Busan.",
                yearReleased = "2016",
                director = "Yeon Sang-ho",
                cast = listOf("Gong Yoo", "Ma Dong-seok")
            ),

            Movie(
                title = "The Night House",
                imageResId = R.drawable.night_house,
                rating = 6.5f,
                description = "A widow uncovers her recently deceased husband's disturbing secrets.",
                yearReleased = "2020",
                director = "David Bruckner",
                cast = listOf("Rebecca Hall", "Sarah Goldberg")
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