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

class FamilyPage : Activity() {

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
                title = "The Lion King",
                imageResId = R.drawable.lion_king,
                rating = 8.5f,
                description = "A young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.",
                yearReleased = "1994",
                director = "Roger Allers, Rob Minkoff",
                cast = listOf("Matthew Broderick", "Jeremy Irons")
            ),

            Movie(
                title = "Paddington",
                imageResId = R.drawable.paddington,
                rating = 7.9f,
                description = "A young Peruvian bear travels to London in search of a home and finds a loving family.",
                yearReleased = "2014",
                director = "Paul King",
                cast = listOf("Ben Whishaw", "Hugh Bonneville")
            ),

            Movie(
                title = "Finding Nemo",
                imageResId = R.drawable.finding_nemo,
                rating = 8.1f,
                description = "After his son is captured, a timid clownfish sets out on a journey to bring him home.",
                yearReleased = "2003",
                director = "Andrew Stanton",
                cast = listOf("Albert Brooks", "Ellen DeGeneres")
            ),

            Movie(
                title = "Frozen",
                imageResId = R.drawable.frozen,
                rating = 7.5f,
                description = "A young queen's powers trap her kingdom in eternal winter, and her sister sets out to stop it.",
                yearReleased = "2013",
                director = "Chris Buck, Jennifer Lee",
                cast = listOf("Kristen Bell", "Idina Menzel")
            ),

            Movie(
                title = "The Incredibles",
                imageResId = R.drawable.incredibles,
                rating = 8.0f,
                description = "A family of undercover superheroes is forced into action to save the world.",
                yearReleased = "2004",
                director = "Brad Bird",
                cast = listOf("Craig T. Nelson", "Holly Hunter")
            ),

            Movie(
                title = "Shrek",
                imageResId = R.drawable.shrek,
                rating = 7.9f,
                description = "An ogre's peaceful life is disrupted when fairytale creatures invade his swamp.",
                yearReleased = "2001",
                director = "Andrew Adamson, Vicky Jenson",
                cast = listOf("Mike Myers", "Eddie Murphy")
            ),

            Movie(
                title = "Up",
                imageResId = R.drawable.up,
                rating = 8.2f,
                description = "An old man ties balloons to his house and flies to South America, accidentally bringing a boy scout with him.",
                yearReleased = "2009",
                director = "Pete Docter",
                cast = listOf("Ed Asner", "Jordan Nagai")
            ),

            Movie(
                title = "Coco",
                imageResId = R.drawable.coco,
                rating = 8.4f,
                description = "A young boy journeys to the Land of the Dead to unlock his family's history and pursue music.",
                yearReleased = "2017",
                director = "Lee Unkrich, Adrian Molina",
                cast = listOf("Anthony Gonzalez", "Gael García Bernal")
            ),

            Movie(
                title = "Toy Story",
                imageResId = R.drawable.toy_story,
                rating = 8.3f,
                description = "A cowboy doll is threatened by a new spaceman toy in this tale of toys that come to life.",
                yearReleased = "1995",
                director = "John Lasseter",
                cast = listOf("Tom Hanks", "Tim Allen")
            ),

            Movie(
                title = "Ratatouille",
                imageResId = R.drawable.ratatouille,
                rating = 8.1f,
                description = "A rat with a passion for cooking makes an alliance with a young kitchen worker in Paris.",
                yearReleased = "2007",
                director = "Brad Bird",
                cast = listOf("Patton Oswalt", "Lou Romano")
            ),

            Movie(
                title = "Monsters, Inc.",
                imageResId = R.drawable.monsters_inc,
                rating = 8.1f,
                description = "Monsters generate their city's power by scaring children, but one monster finds a child who changes everything.",
                yearReleased = "2001",
                director = "Pete Docter, David Silverman",
                cast = listOf("John Goodman", "Billy Crystal")
            ),

            Movie(
                title = "Big Hero 6",
                imageResId = R.drawable.big_hero,
                rating = 7.8f,
                description = "A young robotics prodigy teams up with his robot and friends to form a superhero team.",
                yearReleased = "2014",
                director = "Don Hall, Chris Williams",
                cast = listOf("Ryan Potter", "Scott Adsit")
            ),

            Movie(
                title = "How to Train Your Dragon",
                imageResId = R.drawable.how_to_train_your_dragon,
                rating = 8.1f,
                description = "A young Viking defies tradition by befriending a dragon he was meant to slay.",
                yearReleased = "2010",
                director = "Chris Sanders, Dean DeBlois",
                cast = listOf("Jay Baruchel", "Gerard Butler")
            ),

            Movie(
                title = "Despicable Me",
                imageResId = R.drawable.despicable_me,
                rating = 7.6f,
                description = "A supervillain adopts three girls and finds his heart warming to them.",
                yearReleased = "2010",
                director = "Pierre Coffin, Chris Renaud",
                cast = listOf("Steve Carell", "Miranda Cosgrove")
            ),

            Movie(
                title = "Zootopia",
                imageResId = R.drawable.zootopia,
                rating = 8.0f,
                description = "A rookie bunny cop and a sly fox must work together to uncover a conspiracy in a city of animals.",
                yearReleased = "2016",
                director = "Byron Howard, Rich Moore",
                cast = listOf("Ginnifer Goodwin", "Jason Bateman")
            ),

            Movie(
                title = "Luca",
                imageResId = R.drawable.luca,
                rating = 7.4f,
                description = "A young sea monster experiences a life-changing summer on the Italian Riviera.",
                yearReleased = "2021",
                director = "Enrico Casarosa",
                cast = listOf("Jacob Tremblay", "Jack Dylan Grazer")
            ),

            Movie(
                title = "The Good Dinosaur",
                imageResId = R.drawable.good_dinosaur,
                rating = 6.7f,
                description = "In a world where dinosaurs never went extinct, a young dino forms a bond with a human boy.",
                yearReleased = "2015",
                director = "Peter Sohn",
                cast = listOf("Raymond Ochoa", "Jeffrey Wright")
            ),

            Movie(
                title = "Brave",
                imageResId = R.drawable.brave,
                rating = 7.1f,
                description = "A Scottish princess defies tradition, unleashing a beastly curse she must undo.",
                yearReleased = "2012",
                director = "Mark Andrews, Brenda Chapman",
                cast = listOf("Kelly Macdonald", "Billy Connolly")
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
