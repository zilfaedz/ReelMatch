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

class AnimePage : Activity() {

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
                title = "Your Name",
                imageResId = R.drawable.your_name,
                rating = 8.4f,
                description = "Two teenagers mysteriously begin to swap bodies and form a powerful emotional bond.",
                yearReleased = "2016",
                director = "Makoto Shinkai",
                cast = listOf("Ryunosuke Kamiki", "Mone Kamishiraishi", "Ryo Narita")
            ),
            Movie(
                title = "Princess Mononoke",
                imageResId = R.drawable.princess_mononoke,
                rating = 8.4f,
                description = "A prince becomes entangled in a struggle between industrial humans and forest gods.",
                yearReleased = "1997",
                director = "Hayao Miyazaki",
                cast = listOf("Yoji Matsuda", "Yuriko Ishida", "Yuko Tanaka")
            ),
            Movie(
                title = "Akira",
                imageResId = R.drawable.akira,
                rating = 8.0f,
                description = "In a post-apocalyptic Neo-Tokyo, a biker gang member develops uncontrollable psychic powers.",
                yearReleased = "1988",
                director = "Katsuhiro Otomo",
                cast = listOf("Mitsuo Iwata", "Nozomu Sasaki", "Mami Koyama")
            ),
            Movie(
                title = "My Neighbor Totoro",
                imageResId = R.drawable.my_neighbor_totoro,
                rating = 8.2f,
                description = "Two sisters move to the countryside and discover magical creatures living nearby.",
                yearReleased = "1988",
                director = "Hayao Miyazaki",
                cast = listOf("Noriko Hidaka", "Chika Sakamoto", "Hitoshi Takagi")
            ),
            Movie(
                title = "Grave of the Fireflies",
                imageResId = R.drawable.the_grave_of_fireflies,
                rating = 8.5f,
                description = "A heartbreaking tale of two siblings struggling to survive in wartime Japan.",
                yearReleased = "1988",
                director = "Isao Takahata",
                cast = listOf("Tsutomu Tatsumi", "Ayano Shiraishi", "Akemi Yamaguchi")
            ),
            Movie(
                title = "Howl's Moving Castle",
                imageResId = R.drawable.howls_moving_castle,
                rating = 8.2f,
                description = "A young woman cursed by a witch finds refuge in a wizard's magical moving castle.",
                yearReleased = "2004",
                director = "Hayao Miyazaki",
                cast = listOf("Chieko Baisho", "Takuya Kimura", "Akihiro Miwa")
            ),
            Movie(
                title = "Ghost in the Shell",
                imageResId = R.drawable.ghost_in_the_shell,
                rating = 8.0f,
                description = "In a cyberpunk future, a cyborg policewoman investigates a mysterious hacker known as the Puppet Master.",
                yearReleased = "1995",
                director = "Mamoru Oshii",
                cast = listOf("Atsuko Tanaka", "Akio Ōtsuka", "Iemasa Kayumi")
            ),
            Movie(
                title = "Paprika",
                imageResId = R.drawable.paprika,
                rating = 7.7f,
                description = "A psychologist uses a device that allows therapists to help patients by entering their dreams.",
                yearReleased = "2006",
                director = "Satoshi Kon",
                cast = listOf("Megumi Hayashibara", "Toru Emori", "Katsunosuke Hori")
            ),
            Movie(
                title = "The Girl Who Leapt Through Time",
                imageResId = R.drawable.the_girl_who_leapt_through_time,
                rating = 7.7f,
                description = "A teenage girl gains the ability to leap through time and tries to fix her past mistakes.",
                yearReleased = "2006",
                director = "Mamoru Hosoda",
                cast = listOf("Riisa Naka", "Takuya Ishida", "Mitsutaka Itakura")
            ),
            Movie(
                title = "Spirited Away",
                imageResId = R.drawable.spirited_away,
                rating = 10.0f,
                description = "A young girl enters a mysterious world of spirits and must rescue her parents.",
                yearReleased = "2001",
                director = "Hayao Miyazaki",
                cast = listOf("Rumi Hiiragi", "Miyu Irino", "Mari Natsuki")
            ),
            Movie(
                title = "Demon Slayer: Mugen Train",
                imageResId = R.drawable.demon_slayer,
                rating = 8.5f,
                description = "Tanjiro and his friends join the Flame Hashira on a mission aboard the Mugen Train to face a powerful demon.",
                yearReleased = "2020",
                director = "Haruo Sotozaki",
                cast = listOf("Natsuki Hanae", "Akari Kito", "Hiro Shimono")
            ),
            Movie(
                title = "My Hero Academia: Heroes Rising",
                imageResId = R.drawable.my_hero_academia,
                rating = 7.9f,
                description = "Class 1-A students must protect a small island and its residents from a powerful new villain.",
                yearReleased = "2019",
                director = "Kenji Nagasaki",
                cast = listOf("Daiki Yamashita", "Nobuhiko Okamoto", "Yuka Terasaki")
            ),
            Movie(
                title = "Attack on Titan",
                imageResId = R.drawable.attack_on_titan,
                rating = 8.8f,
                description = "Humanity fights for survival against giant man-eating Titans that have overrun the world.",
                yearReleased = "2013",
                director = "Tetsurō Araki",
                cast = listOf("Yuki Kaji", "Yui Ishikawa", "Marina Inoue")
            ),
            Movie(
                title = "One Piece: Stampede",
                imageResId = R.drawable.one_piece_stampede,
                rating = 7.6f,
                description = "The Straw Hat Pirates attend a massive pirate festival that turns into a chaotic battle for a legendary treasure.",
                yearReleased = "2019",
                director = "Takashi Otsuka",
                cast = listOf("Mayumi Tanaka", "Kazuya Nakai", "Akemi Okamura")
            ),
            Movie(
                title = "Weathering with You",
                imageResId = R.drawable.weathering_with_you,
                rating = 7.5f,
                description = "A runaway boy meets a girl who has the power to manipulate the weather.",
                yearReleased = "2019",
                director = "Makoto Shinkai",
                cast = listOf("Kotaro Daigo", "Nana Mori", "Shun Oguri")
            ),
            Movie(
                title = "Ponyo",
                imageResId = R.drawable.ponyo,
                rating = 7.7f,
                description = "A goldfish princess escapes the ocean and befriends a young boy on land, wanting to become human.",
                yearReleased = "2008",
                director = "Hayao Miyazaki",
                cast = listOf("Yuria Nara", "Hiroki Doi", "Tomoko Yamaguchi")
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
