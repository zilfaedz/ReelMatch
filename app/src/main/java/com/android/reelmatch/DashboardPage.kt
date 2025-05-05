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
        val btnMovies: Button = findViewById(R.id.btn_movies)
        val btnDocumentaries: Button = findViewById(R.id.btn_documentaries)
        val btnAnime: Button = findViewById(R.id.btn_anime)

        val allButtons = listOf(btnForYou, btnPopular, btnMovies, btnDocumentaries, btnAnime)

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
        }

        allButtons.forEach {
            it.setOnClickListener(buttonClickListener)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val movieList = listOf(
            //popular
            Movie("The Godfather (1972)",R.drawable.the_godfather,9.2f),
            Movie("The Dark Knight (2008)",R.drawable.the_dark_knight,9.0f),
            Movie("Pulp Fiction",R.drawable.pulp_fiction,8.9f),
            Movie("Forrest Gump (1994)",R.drawable.forrest_gump,8.8f),
            Movie("Fight Club (1999)",R.drawable.fight_club,8.8f),
            Movie("The Matrix (1999)",R.drawable.the_matrix,8.7f),
            Movie("The Lord of the Rings: The Return of the King (2003)",R.drawable.lord_of_the_rings,8.9f),
            Movie("The Shawshank Redemption (1994)",R.drawable.the_shawshank_redemption,9.3f),
            Movie("Spider-Man: Across the Spider-Verse", R.drawable.spider_man_across_spiderverse, 8.6f),
            Movie("Avatar: The Way of Water", R.drawable.avatar2, 7.8f),
            Movie("Doctor Strange in the Multiverse of Madness", R.drawable.doctor_strange, 7.0f),
            Movie("Black Adam", R.drawable.black_adam, 6.9f),
            Movie("The Batman", R.drawable.the_batman, 7.9f),
            Movie("Top Gun: Maverick", R.drawable.topgun_maverick, 8.3f),
            Movie("Jurassic World: Dominion", R.drawable.jurassic_world, 6.0f),
            Movie("Thor: Love and Thunder", R.drawable.thor_love_and_thunder, 6.3f),
            Movie("The Flash", R.drawable.flash, 6.7f),
            Movie("Scream", R.drawable.scream2022, 6.4f),

            //documentary
            Movie("13th (2016)",R.drawable.thirteenth,8.2f),
            Movie("Won’t You Be My Neighbor? (2018)",R.drawable.wont_you_be_my_neighbor,8.4f),
            Movie("Free Solo (2018)", R.drawable.free_solo,8.4f),
            Movie("The Social Dilemma (2020)",R.drawable.the_social_dilemma,7.6f),
            Movie("Amy (2015)",R.drawable.amy,7.8f),
            Movie("Blackfish (2013)",R.drawable.blackfish,8.1f),
            Movie("Jiro Dreams of Sushi (2011)",R.drawable.jiro_dreams_of_sushi,7.9f),
            Movie("Man on Wire (2008)",R.drawable.man_on_wire,7.7f),
            Movie("The Cove (2009)",R.drawable.the_cove,8.4f),
            Movie("Icarus (2017)",R.drawable.icarus,7.9f),

            //anime
            Movie("Your Name (2016)",R.drawable.your_name,8.4f),
            Movie("Princess Mononoke (1997)",R.drawable.princess_mononoke,8.4f),
            Movie("Akira (1988)",R.drawable.akira,8.0f),
            Movie("My Neighbor Totoro (1988)",R.drawable.my_neighbor_totoro,8.2f),
            Movie("Grave of the Fireflies (1988)",R.drawable.the_grave_of_fireflies,8.5f),
            Movie("Howl's Moving Castle (2004)",R.drawable.howls_moving_castle,8.2f),
            Movie("Ghost in the Shell (1995)",R.drawable.ghost_in_the_shell,8.0f),
            Movie("Paprika (2006)",R.drawable.paprika,7.7f),
            Movie("The Girl Who Leapt Through Time (2006)",R.drawable.the_girl_who_leapt_through_time,7.7f),
            Movie("Spirited Away (2001)", R.drawable.spirited_away,10.0f),
            Movie("Demon Slayer: Mugen Train", R.drawable.demon_slayer, 8.5f),
            Movie("My Hero Academia: Heroes Rising", R.drawable.my_hero_academia, 7.9f),
            Movie("Attack on Titan", R.drawable.attack_on_titan, 8.8f),
            Movie("One Piece: Stampede", R.drawable.one_piece_stampede, 7.6f),
            Movie("Weathering with You", R.drawable.weathering_with_you, 7.5f),
            Movie("Ponyo", R.drawable.ponyo, 7.7f),

            //series
            Movie("Breaking Bad (2008–2013)",R.drawable.breaking_bad,9.5f),
            Movie("Game of Thrones (2011–2019)",R.drawable.game_of_thrones,9.2f),
            Movie("Stranger Things (2016–present)",R.drawable.stranger_things,8.7f),
            Movie("The Crown (2016–present)",R.drawable.the_crown,8.6f),
            Movie("The Mandalorian (2019–present)",R.drawable.the_mandalorian,8.7f),
            Movie("Queen's Gambit (2020)",R.drawable.queens_gambit,8.6f),
            Movie("Chernobyl (2019)",R.drawable.chernobyl,9.4f),
            Movie("The Office (2005–2013) ",R.drawable.the_office,9.0f),
            Movie("Friends (1994–2004)",R.drawable.friends,8.9f),
            Movie("The Witcher (2019–present)",R.drawable.the_witcher,8.2f),
            Movie("Stranger Things", R.drawable.stranger_things, 8.7f),
            Movie("The Witcher", R.drawable.the_witcher, 8.0f),
            Movie("Breaking Bad", R.drawable.breaking_bad, 9.5f),
            Movie("The Crown", R.drawable.the_crown, 8.7f),
            Movie("Money Heist", R.drawable.money_heist, 8.3f),
            Movie("The Boys", R.drawable.the_boys, 8.7f),
            Movie("Narcos", R.drawable.narcos, 8.8f),

            //romance
            Movie("Pride & Prejudice", R.drawable.pride_and_prejudice, 7.8f),
            Movie("The Notebook", R.drawable.the_notebook, 7.8f),
            Movie("La La Land", R.drawable.la_la_land, 8.0f),
            Movie("Titanic", R.drawable.titanic, 7.8f),
            Movie("Before Sunrise", R.drawable.before_sunrise, 8.1f),
            Movie("Eternal Sunshine of the Spotless Mind", R.drawable.eternal_sunshine, 8.3f),
            Movie("Call Me by Your Name", R.drawable.call_me_by_your_name, 7.9f),
            Movie("Atonement", R.drawable.atonement, 7.8f),
            Movie("500 Days of Summer", R.drawable.five_hundred_days_of_summer, 7.7f),
            Movie("Her", R.drawable.her, 8.0f),
            Movie("Mamma Mia (2008)", R.drawable.mamma, 8.3f),
            Movie("P.S. I Love You", R.drawable.ps_i_love_you, 7.0f),
            Movie("Me Before You", R.drawable.me_before_you, 7.4f),
            Movie("The Fault in Our Stars", R.drawable.fault_in_our_stars, 7.7f),
            Movie("To All the Boys I've Loved Before", R.drawable.to_all_the_boys, 7.1f),
            Movie("The Vow", R.drawable.the_vow, 6.8f),

            //action
            Movie("Mad Max: Fury Road", R.drawable.mad_max_fury_road, 8.1f),
            Movie("John Wick", R.drawable.john_wick, 7.4f),
            Movie("Die Hard", R.drawable.die_hard, 8.2f),
            Movie("The Bourne Identity", R.drawable.bourne_identity, 7.9f),
            Movie("Gladiator", R.drawable.gladiator, 8.5f),
            Movie("The Dark Knight", R.drawable.dark_knight, 9.0f),
            Movie("Inception", R.drawable.inception, 8.8f),
            Movie("The Matrix", R.drawable.the_matrix, 8.7f),
            Movie("Casino Royale", R.drawable.casino_royale, 8.0f),
            Movie("Skyfall", R.drawable.skyfall, 7.8f),
            Movie("Mad Max: Fury Road", R.drawable.mad_max_fury_road, 8.1f),
            Movie("John Wick", R.drawable.john_wick, 7.4f),
            Movie("The Dark Knight", R.drawable.dark_knight, 9.0f),
            Movie("Die Hard", R.drawable.die_hard, 8.2f),
            Movie("Mission: Impossible - Fallout", R.drawable.mission_impossible_fallout, 7.7f),
            Movie("The Avengers: Endgame", R.drawable.avengers, 8.0f),
            Movie("Spider-Man: No Way Home", R.drawable.spiderman_no_way_home, 8.3f),
            Movie("Black Panther", R.drawable.black_panther, 7.3f),
            Movie("Wonder Woman", R.drawable.wonder_woman, 7.4f),

            //horror
            Movie("The Shining", R.drawable.the_shining, 8.4f),
            Movie("Get Out", R.drawable.get_out, 7.7f),
            Movie("A Quiet Place", R.drawable.a_quiet_place, 7.5f),
            Movie("Hereditary", R.drawable.hereditary, 7.3f),
            Movie("The Exorcist", R.drawable.the_exorcist, 8.1f),
            Movie("Psycho", R.drawable.psycho, 8.5f),
            Movie("The Conjuring", R.drawable.the_conjuring, 7.5f),
            Movie("The Babadook", R.drawable.the_babadook, 6.8f),
            Movie("It", R.drawable.it, 7.3f),
            Movie("Us", R.drawable.us, 6.8f),
            Movie("A Quiet Place", R.drawable.a_quiet_place, 7.5f),
            Movie("Hereditary", R.drawable.hereditary, 7.3f),
            Movie("Get Out", R.drawable.get_out, 8.0f),
            Movie("The Invisible Man", R.drawable.invisible_man, 7.1f),
            Movie("It Follows", R.drawable.it_follows, 6.8f),
            Movie("Midsommar", R.drawable.midsommar, 7.1f),
            Movie("The Witch", R.drawable.the_witch, 6.9f),
            Movie("Train to Busan", R.drawable.train_to_busan, 7.6f),
            Movie("The Night House", R.drawable.night_house, 6.5f),

            //family
            Movie("The Lion King", R.drawable.lion_king, 8.5f),
            Movie("Paddington", R.drawable.paddington, 7.9f),
            Movie("Finding Nemo", R.drawable.finding_nemo, 8.1f),
            Movie("Frozen", R.drawable.frozen, 7.5f),
            Movie("The Incredibles", R.drawable.incredibles, 8.0f),
            Movie("Shrek", R.drawable.shrek, 7.9f),
            Movie("Up", R.drawable.up, 8.2f),
            Movie("Coco", R.drawable.coco, 8.4f),
            Movie("Toy Story", R.drawable.toy_story, 8.3f),
            Movie("Ratatouille", R.drawable.ratatouille, 8.1f),
            Movie("Monsters, Inc.", R.drawable.monsters_inc, 8.1f),
            Movie("Big Hero 6", R.drawable.big_hero, 7.8f),
            Movie("How to Train Your Dragon", R.drawable.how_to_train_your_dragon, 8.1f),
            Movie("Despicable Me", R.drawable.despicable_me, 7.6f),
            Movie("Zootopia", R.drawable.zootopia, 8.0f),
            Movie("Luca", R.drawable.luca, 7.4f),
            Movie("The Good Dinosaur", R.drawable.good_dinosaur, 6.7f),
            Movie("Brave", R.drawable.brave, 7.1f),

            //scifi
            Movie("Blade Runner 2049", R.drawable.blade_runner, 8.0f),
            Movie("Dune", R.drawable.dune, 8.1f),
            Movie("Arrival", R.drawable.arrival, 7.9f),
            Movie("Ex Machina", R.drawable.ex_machina, 7.7f),
            Movie("Edge of Tomorrow", R.drawable.edge_of_tomorrow, 7.9f),
            Movie("Interstellar (2014)", R.drawable.interstellar, 9.0f),
            Movie("Avatar", R.drawable.avatar, 7.9f),
            Movie("Avatar: The Way of Water", R.drawable.avatar2, 7.8f),
            Movie("I Am Legend", R.drawable.i_am_legend, 7.2f),
            Movie("Oblivion", R.drawable.oblivion, 7.0f),
            Movie("The Fifth Element", R.drawable.fifth_element, 7.6f),
            Movie("Minority Report", R.drawable.minority_report, 7.6f),
            Movie("District 9", R.drawable.district9, 7.9f),
            Movie("Star Trek", R.drawable.star_trek, 7.9f),
            Movie("Tenet", R.drawable.tenet, 7.3f),
            Movie("Moon", R.drawable.moon, 7.8f),
            Movie("Her", R.drawable.her, 8.0f),

            //fantasy
            Movie("The Lord of the Rings: The Fellowship of the Ring", R.drawable.lotr_fellowship, 8.8f),
            Movie("Harry Potter and the Sorcerer’s Stone", R.drawable.hp1, 7.6f),
            Movie("The Chronicles of Narnia", R.drawable.narnia, 6.9f),
            Movie("Pan’s Labyrinth", R.drawable.pans_labyrinth, 8.2f),
            Movie("Fantastic Beasts and Where to Find Them", R.drawable.fantastic_beasts, 7.3f),
            Movie("Percy Jackson & the Olympians", R.drawable.percy_jackson, 5.9f),
            Movie("Eragon", R.drawable.eragon, 5.1f),
            Movie("Stardust", R.drawable.stardust, 7.6f),
            Movie("The Hobbit: An Unexpected Journey", R.drawable.hobbit1, 7.8f),
            Movie("Willow", R.drawable.willow, 7.2f),
            Movie("The Golden Compass", R.drawable.golden_compass, 6.1f),
            Movie("Legend", R.drawable.legend, 6.5f),
            Movie("Ella Enchanted", R.drawable.ella_enchanted, 6.3f),
            Movie("Bridge to Terabithia", R.drawable.bridge_terabithia, 7.1f),

            //mystery
            Movie("Gone Girl", R.drawable.gone_girl, 8.1f),
            Movie("Prisoners", R.drawable.prisoners, 8.1f),
            Movie("Knives Out", R.drawable.knives_out, 7.9f),
            Movie("The Girl with the Dragon Tattoo", R.drawable.dragon_tattoo, 7.8f),
            Movie("Zodiac", R.drawable.zodiac, 7.7f),
            Movie("The Prestige", R.drawable.prestige, 8.5f),
            Movie("Memento", R.drawable.memento, 8.4f),
            Movie("The Sixth Sense", R.drawable.sixth_sense, 8.1f),
            Movie("Shutter Island", R.drawable.shutter_island, 8.2f),
            Movie("Se7en", R.drawable.se7en, 8.6f),
            Movie("The Others", R.drawable.the_others, 7.6f),
            Movie("The Da Vinci Code", R.drawable.da_vinci_code, 6.6f),
            Movie("The Machinist", R.drawable.machinist, 7.7f),
            Movie("Before I Go to Sleep", R.drawable.before_i_go_to_sleep, 6.3f),
            Movie("Side Effects", R.drawable.side_effects, 7.1f)

            //Movie("",R.drawable.,10f)
        )

//        val adapter = MovieAdapter(movieList)
//        recyclerView.adapter = adapter
//        recyclerView.adapter = MovieAdapter(movieList)

        val adapter = MovieAdapter(movieList) { selectedMovie ->
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("title", selectedMovie.title)
            intent.putExtra("image", selectedMovie.imageResId)
            intent.putExtra("rating", selectedMovie.rating)
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}
