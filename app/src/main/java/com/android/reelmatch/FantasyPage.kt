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

class FantasyPage : Activity() {

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
                title = "The Lord of the Rings: The Fellowship of the Ring",
                imageResId = R.drawable.lotr_fellowship,
                rating = 8.8f,
                description = "A young hobbit, Frodo, embarks on an epic journey with a group of companions to destroy a powerful ring that threatens the world.",
                yearReleased = "2001",
                director = "Peter Jackson",
                cast = listOf("Elijah Wood", "Ian McKellen", "Viggo Mortensen")
            ),
            Movie(
                title = "Harry Potter and the Sorcerer’s Stone",
                imageResId = R.drawable.hp1,
                rating = 7.6f,
                description = "A young boy discovers he is a wizard on his 11th birthday and attends Hogwarts School of Witchcraft and Wizardry to begin his magical education.",
                yearReleased = "2001",
                director = "Chris Columbus",
                cast = listOf("Daniel Radcliffe", "Rupert Grint", "Emma Watson")
            ),
            Movie(
                title = "The Chronicles of Narnia",
                imageResId = R.drawable.narnia,
                rating = 6.9f,
                description = "Four siblings discover a magical world through a wardrobe and help the land's rightful ruler battle an evil queen.",
                yearReleased = "2005",
                director = "Andrew Adamson",
                cast = listOf("Tilda Swinton", "Georgie Henley", "Skandar Keynes")
            ),
            Movie(
                title = "Pan’s Labyrinth",
                imageResId = R.drawable.pans_labyrinth,
                rating = 8.2f,
                description = "In post-Civil War Spain, a young girl encounters a mysterious labyrinth and a faun who tells her she is the reincarnation of a lost princess.",
                yearReleased = "2006",
                director = "Guillermo del Toro",
                cast = listOf("Ivana Baquero", "Sergi López", "Maribel Verdú")
            ),
            Movie(
                title = "Fantastic Beasts and Where to Find Them",
                imageResId = R.drawable.fantastic_beasts,
                rating = 7.3f,
                description = "Set in the wizarding world decades before Harry Potter, a magizoologist tracks magical creatures and uncovers dark secrets.",
                yearReleased = "2016",
                director = "David Yates",
                cast = listOf("Eddie Redmayne", "Katherine Waterston", "Dan Fogler")
            ),
            Movie(
                title = "Percy Jackson & the Olympians",
                imageResId = R.drawable.percy_jackson,
                rating = 5.9f,
                description = "A teenager discovers he is the son of Poseidon and embarks on a quest to prevent a war between the gods.",
                yearReleased = "2010",
                director = "Chris Columbus",
                cast = listOf("Logan Lerman", "Brandon T. Jackson", "Alexandra Daddario")
            ),
            Movie(
                title = "Eragon",
                imageResId = R.drawable.eragon,
                rating = 5.1f,
                description = "A young farm boy discovers a dragon egg and becomes the last of a group of dragon riders, determined to defeat a tyrannical king.",
                yearReleased = "2006",
                director = "Stefen Fangmeier",
                cast = listOf("Edward Speleers", "Sienna Guillory", "Jeremy Irons")
            ),
            Movie(
                title = "Stardust",
                imageResId = R.drawable.stardust,
                rating = 7.6f,
                description = "A young man ventures into a magical kingdom to retrieve a fallen star, only to discover it is a woman, and they are pursued by witches.",
                yearReleased = "2007",
                director = "Matthew Vaughn",
                cast = listOf("Charlie Cox", "Claire Danes", "Robert De Niro")
            ),
            Movie(
                title = "The Hobbit: An Unexpected Journey",
                imageResId = R.drawable.hobbit1,
                rating = 7.8f,
                description = "Bilbo Baggins embarks on an unexpected adventure with a group of dwarves to reclaim a lost kingdom from the dragon Smaug.",
                yearReleased = "2012",
                director = "Peter Jackson",
                cast = listOf("Martin Freeman", "Ian McKellen", "Richard Armitage")
            ),
            Movie(
                title = "Willow",
                imageResId = R.drawable.willow,
                rating = 7.2f,
                description = "A young farmer is tasked with protecting a special baby from an evil queen in a world filled with magic and danger.",
                yearReleased = "1988",
                director = "Ron Howard",
                cast = listOf("Warwick Davis", "Val Kilmer", "Joanne Whalley")
            ),
            Movie(
                title = "The Golden Compass",
                imageResId = R.drawable.golden_compass,
                rating = 6.1f,
                description = "A young girl embarks on a perilous journey to rescue her kidnapped friend and uncover a secret conspiracy involving mystical creatures.",
                yearReleased = "2007",
                director = "Chris Weitz",
                cast = listOf("Nicole Kidman", "Daniel Craig", "Dakota Blue Richards")
            ),
            Movie(
                title = "Legend",
                imageResId = R.drawable.legend,
                rating = 6.5f,
                description = "A young hero must stop the Lord of Darkness, who is determined to create eternal night and rule the world.",
                yearReleased = "1985",
                director = "Ridley Scott",
                cast = listOf("Tom Cruise", "Mia Sara", "Tim Curry")
            ),
            Movie(
                title = "Ella Enchanted",
                imageResId = R.drawable.ella_enchanted,
                rating = 6.3f,
                description = "A young woman, cursed with the gift of obedience, embarks on a journey to break the curse and regain control of her life.",
                yearReleased = "2004",
                director = "Tommy O'Haver",
                cast = listOf("Anne Hathaway", "Hugh Dancy", "Cary Elwes")
            ),
            Movie(
                title = "Bridge to Terabithia",
                imageResId = R.drawable.bridge_terabithia,
                rating = 7.1f,
                description = "Two friends create an imaginary kingdom in the woods, where they face both joyous and tragic experiences that change their lives forever.",
                yearReleased = "2007",
                director = "Gabor Csupo",
                cast = listOf("Josh Hutcherson", "AnnaSophia Robb", "Zooey Deschanel")
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
