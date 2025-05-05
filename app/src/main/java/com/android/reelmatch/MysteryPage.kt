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

class MysteryPage : Activity() {

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
                title = "Gone Girl",
                imageResId = R.drawable.gone_girl,
                rating = 8.1f,
                description = "A man becomes the prime suspect in the disappearance of his wife, but he is hiding dark secrets of his own.",
                yearReleased = "2014",
                director = "David Fincher",
                cast = listOf("Ben Affleck", "Rosamund Pike", "Neil Patrick Harris")
            ),
            Movie(
                title = "Prisoners",
                imageResId = R.drawable.prisoners,
                rating = 8.1f,
                description = "When two young girls are kidnapped, a desperate father takes matters into his own hands while the police pursue multiple leads.",
                yearReleased = "2013",
                director = "Denis Villeneuve",
                cast = listOf("Hugh Jackman", "Jake Gyllenhaal", "Viola Davis")
            ),
            Movie(
                title = "Knives Out",
                imageResId = R.drawable.knives_out,
                rating = 7.9f,
                description = "A detective investigates the death of a wealthy patriarch during a family gathering, uncovering many secrets along the way.",
                yearReleased = "2019",
                director = "Rian Johnson",
                cast = listOf("Daniel Craig", "Chris Evans", "Ana de Armas")
            ),
            Movie(
                title = "The Girl with the Dragon Tattoo",
                imageResId = R.drawable.dragon_tattoo,
                rating = 7.8f,
                description = "A journalist and a hacker team up to solve a decades-old disappearance, uncovering a deeper conspiracy in the process.",
                yearReleased = "2011",
                director = "David Fincher",
                cast = listOf("Daniel Craig", "Rooney Mara", "Christopher Plummer")
            ),
            Movie(
                title = "Zodiac",
                imageResId = R.drawable.zodiac,
                rating = 7.7f,
                description = "A newspaper cartoonist, a reporter, and a pair of detectives work together to uncover the identity of the elusive Zodiac killer.",
                yearReleased = "2007",
                director = "David Fincher",
                cast = listOf("Jake Gyllenhaal", "Mark Ruffalo", "Robert Downey Jr.")
            ),
            Movie(
                title = "The Prestige",
                imageResId = R.drawable.prestige,
                rating = 8.5f,
                description = "Two magicians engage in a bitter rivalry to create the ultimate illusion, with tragic consequences.",
                yearReleased = "2006",
                director = "Christopher Nolan",
                cast = listOf("Christian Bale", "Hugh Jackman", "Scarlett Johansson")
            ),
            Movie(
                title = "Memento",
                imageResId = R.drawable.memento,
                rating = 8.4f,
                description = "A man with short-term memory loss tries to track down the person who murdered his wife, using a system of photos and tattoos.",
                yearReleased = "2000",
                director = "Christopher Nolan",
                cast = listOf("Guy Pearce", "Carrie-Anne Moss", "Joe Pantoliano")
            ),
            Movie(
                title = "The Sixth Sense",
                imageResId = R.drawable.sixth_sense,
                rating = 8.1f,
                description = "A young boy who communicates with spirits seeks the help of a disheartened child psychologist.",
                yearReleased = "1999",
                director = "M. Night Shyamalan",
                cast = listOf("Bruce Willis", "Haley Joel Osment", "Toni Collette")
            ),
            Movie(
                title = "Shutter Island",
                imageResId = R.drawable.shutter_island,
                rating = 8.2f,
                description = "A U.S. Marshal investigates the disappearance of a patient from a mental institution located on an isolated island.",
                yearReleased = "2010",
                director = "Martin Scorsese",
                cast = listOf("Leonardo DiCaprio", "Mark Ruffalo", "Ben Kingsley")
            ),
            Movie(
                title = "Se7en",
                imageResId = R.drawable.se7en,
                rating = 8.6f,
                description = "Two detectives hunt a serial killer who uses the seven deadly sins as his modus operandi.",
                yearReleased = "1995",
                director = "David Fincher",
                cast = listOf("Brad Pitt", "Morgan Freeman", "Gwyneth Paltrow")
            ),
            Movie(
                title = "The Others",
                imageResId = R.drawable.the_others,
                rating = 7.6f,
                description = "A woman lives in a dark, old house with her two light-sensitive children and becomes convinced that the house is haunted.",
                yearReleased = "2001",
                director = "Alejandro Amenábar",
                cast = listOf("Nicole Kidman", "Fionnula Flanagan", "Christopher Eccleston")
            ),
            Movie(
                title = "The Da Vinci Code",
                imageResId = R.drawable.da_vinci_code,
                rating = 6.6f,
                description = "A professor and a cryptologist follow a trail of ancient clues through Europe in a quest to uncover the secrets of the Holy Grail.",
                yearReleased = "2006",
                director = "Ron Howard",
                cast = listOf("Tom Hanks", "Audrey Tautou", "Ian McKellen")
            ),
            Movie(
                title = "The Machinist",
                imageResId = R.drawable.machinist,
                rating = 7.7f,
                description = "An industrial worker who hasn't slept in a year begins to doubt his own sanity as he experiences strange occurrences.",
                yearReleased = "2004",
                director = "Brad Anderson",
                cast = listOf("Christian Bale", "Jennifer Jason Leigh", "Aitana Sánchez-Gijón")
            ),
            Movie(
                title = "Before I Go to Sleep",
                imageResId = R.drawable.before_i_go_to_sleep,
                rating = 6.3f,
                description = "A woman wakes up every day with no memory of her past, and when her therapist reveals the truth, she starts to question everything.",
                yearReleased = "2014",
                director = "Rowan Joffé",
                cast = listOf("Nicole Kidman", "Colin Firth", "Mark Strong")
            ),
            Movie(
                title = "Side Effects",
                imageResId = R.drawable.side_effects,
                rating = 7.1f,
                description = "A woman’s world unravels when her psychiatrist prescribes a new medication that causes unexpected side effects.",
                yearReleased = "2013",
                director = "Steven Soderbergh",
                cast = listOf("Rooney Mara", "Channing Tatum", "Jude Law")
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
