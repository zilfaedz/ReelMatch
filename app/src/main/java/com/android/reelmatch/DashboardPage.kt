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

class DashboardPage : Activity() {

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
                title = "The Dark Knight",
                imageResId = R.drawable.the_dark_knight,
                rating = 9.0f,
                description = "Batman faces off against the Joker, a criminal mastermind who wants to plunge Gotham City into anarchy.",
                yearReleased = "2008",
                director = "Christopher Nolan",
                cast = listOf("Christian Bale, Heath Ledger, Aaron Eckhart")
            ),
            Movie(
                title = "The Godfather",
                imageResId = R.drawable.the_godfather,
                rating = 9.2f,
                description = "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son.",
                yearReleased = "1972",
                director = "Francis Ford Coppola",
                cast = listOf("Marlon Brando", "Al Pacino", "James Caan")
            ),
            Movie(
                title = "Forrest Gump",
                imageResId = R.drawable.forrest_gump,
                rating = 8.8f,
                description = "A slow-witted but kind-hearted man from Alabama witnesses and unwittingly influences several historical events.",
                yearReleased = "1994",
                director = "Robert Zemeckis",
                cast = listOf("Tom Hanks", "Robin Wright", "Gary Sinise")
            ),
            Movie(
                title = "Fight Club",
                imageResId = R.drawable.fight_club,
                rating = 8.8f,
                description = "An insomniac and a soap salesman form an underground fight club that evolves into something much more.",
                yearReleased = "1999",
                director = "David Fincher",
                cast = listOf("Brad Pitt", "Edward Norton", "Helena Bonham Carter")
            ),
            Movie(
                title = "The Matrix",
                imageResId = R.drawable.the_matrix,
                rating = 8.7f,
                description = "A computer hacker discovers the truth about reality and his role in the war against its controllers.",
                yearReleased = "1999",
                director = "Lana Wachowski, Lilly Wachowski",
                cast = listOf("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss")
            ),
            Movie(
                title = "The Lord of the Rings: The Return of the King",
                imageResId = R.drawable.lord_of_the_rings,
                rating = 8.9f,
                description = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam.",
                yearReleased = "2003",
                director = "Peter Jackson",
                cast = listOf("Elijah Wood", "Viggo Mortensen", "Ian McKellen")
            ),
            Movie(
                title = "The Shawshank Redemption",
                imageResId = R.drawable.the_shawshank_redemption,
                rating = 9.3f,
                description = "Two imprisoned men bond over years, finding solace and eventual redemption through acts of decency.",
                yearReleased = "1994",
                director = "Frank Darabont",
                cast = listOf("Tim Robbins", "Morgan Freeman", "Bob Gunton")
            ),
            Movie(
                title = "Spider-Man: Across the Spider-Verse",
                imageResId = R.drawable.spider_man_across_spiderverse,
                rating = 8.6f,
                description = "Miles Morales returns for an epic adventure across the multiverse, meeting a team of Spider-People.",
                yearReleased = "2023",
                director = "Joaquim Dos Santos, Kemp Powers, Justin K. Thompson",
                cast = listOf("Shameik Moore", "Hailee Steinfeld", "Oscar Isaac")
            ),
            Movie(
                title = "Avatar: The Way of Water",
                imageResId = R.drawable.avatar2,
                rating = 7.8f,
                description = "Jake Sully lives with his newfound family on Pandora but must protect it from a familiar threat.",
                yearReleased = "2022",
                director = "James Cameron",
                cast = listOf("Sam Worthington", "Zoe Saldaña", "Sigourney Weaver")
            ),
            Movie(
                title = "Doctor Strange in the Multiverse of Madness",
                imageResId = R.drawable.doctor_strange,
                rating = 7.0f,
                description = "Dr. Stephen Strange teams up with a mysterious teenager from his dreams to traverse the multiverse.",
                yearReleased = "2022",
                director = "Sam Raimi",
                cast = listOf("Benedict Cumberbatch", "Elizabeth Olsen", "Xochitl Gomez")
            ),
            Movie(
                title = "Black Adam",
                imageResId = R.drawable.black_adam,
                rating = 6.9f,
                description = "An anti-hero from ancient times is unleashed into modern society and challenged by a team of heroes.",
                yearReleased = "2022",
                director = "Jaume Collet-Serra",
                cast = listOf("Dwayne Johnson", "Aldis Hodge", "Pierce Brosnan")
            ),
            Movie(
                title = "The Batman",
                imageResId = R.drawable.the_batman,
                rating = 7.9f,
                description = "Batman ventures into Gotham's underworld when a sadistic killer leaves behind a trail of clues.",
                yearReleased = "2022",
                director = "Matt Reeves",
                cast = listOf("Robert Pattinson", "Zoë Kravitz", "Paul Dano")
            ),
            Movie(
                title = "Top Gun: Maverick",
                imageResId = R.drawable.topgun_maverick,
                rating = 8.3f,
                description = "After more than 30 years of service, Maverick is called back to train elite pilots for a dangerous mission.",
                yearReleased = "2022",
                director = "Joseph Kosinski",
                cast = listOf("Tom Cruise", "Miles Teller", "Jennifer Connelly")
            ),
            Movie(
                title = "Jurassic World: Dominion",
                imageResId = R.drawable.jurassic_world,
                rating = 6.0f,
                description = "Four years after Isla Nublar's destruction, dinosaurs live among humans, threatening the future.",
                yearReleased = "2022",
                director = "Colin Trevorrow",
                cast = listOf("Chris Pratt", "Bryce Dallas Howard", "Laura Dern")
            ),
            Movie(
                title = "Thor: Love and Thunder",
                imageResId = R.drawable.thor_love_and_thunder,
                rating = 6.3f,
                description = "Thor teams up with Valkyrie, Korg, and Jane Foster to fight Gorr the God Butcher.",
                yearReleased = "2022",
                director = "Taika Waititi",
                cast = listOf("Chris Hemsworth", "Natalie Portman", "Christian Bale")
            ),
            Movie(
                title = "The Flash",
                imageResId = R.drawable.flash,
                rating = 6.7f,
                description = "Barry Allen uses his super speed to change the past, which alters the future in unintended ways.",
                yearReleased = "2023",
                director = "Andy Muschietti",
                cast = listOf("Ezra Miller", "Michael Keaton", "Sasha Calle")
            ),
            Movie(
                title = "Scream",
                imageResId = R.drawable.scream2022,
                rating = 6.4f,
                description = "Twenty-five years after a streak of brutal murders, a new killer dons the Ghostface mask.",
                yearReleased = "2022",
                director = "Matt Bettinelli-Olpin, Tyler Gillett",
                cast = listOf("Neve Campbell", "Courteney Cox", "David Arquette")
            ),

            //documentary
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
            ),

            //anime
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
            ),

                    //series
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
            ),

            //romance
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
            ),

            //action
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

            //horror
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
            ),

            //family
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
            ),

                    //scifi
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
            ),

            // Fantasy
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
            ),

            // Mystery
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
