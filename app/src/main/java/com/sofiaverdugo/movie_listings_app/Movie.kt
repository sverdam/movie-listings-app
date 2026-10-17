package com.sofiaverdugo.movie_listings_app

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val length: Int,
    val genre: String,
    val director: String,
    val description: String,
    val picture: Int
)

val movies = listOf(
    Movie(
        1,
        "Chiikawa the Movie: The Secret of the Mermaid Island",
        2026,
        99,
        "Anime",
        "Kei Oikawa",
        "Chiikawa and friends suddenly find an invitation to a \"Special Island\" with promises of rewards and free food. Lured by its temptations, the group set sail for the island alongside Rakko, who remains suspicious of the brochure's claims.",
        R.drawable.chiikawa
    ),
    Movie(
        2,
        "Your Name",
        2016,
        106,
        "Anime / Fantasy / Romance",
        "Makoto Shinkai",
        "Two teenagers, a boy in Tokyo and a girl in a rural town, mysteriously begin swapping bodies and become connected through an experience that changes their lives.",
        R.drawable.yourname
    ),
    Movie(
        3,
        "Lost in Starlight",
        2025,
        96,
        "Animation / Sci-Fi / Romance",
        "Han Ji-won",
        "An astronaut and a musician fall in love, but their relationship faces the challenges of distance when one travels to Mars.",
        R.drawable.lostinstarlight
    ),
    Movie(
        4,
        "Spider-Man: Into the Spider-Verse",
        2018,
        117,
        "Animation / Action / Sci-Fi",
        "Bob Persichetti, Peter Ramsey, Rodney Rothman",
        "Teenager Miles Morales becomes Spider-Man and joins forces with other Spider-People from different dimensions to stop a threat to the multiverse.",
        R.drawable.into_the_spiderverse
    ),
    Movie(
        5,
        "Suzume",
        2022,
        122,
        "Anime / Fantasy / Adventure",
        "Makoto Shinkai",
        "A 17-year-old girl meets a mysterious young man and helps him close supernatural doors across Japan to prevent a series of disasters.",
        R.drawable.suzume
    ),
    Movie(
        6,
        "Weathering with You",
        2019,
        112,
        "Anime / Fantasy / Romance",
        "Makoto Shinkai",
        "A runaway teenager in Tokyo meets a girl who possesses the extraordinary ability to control the weather.",
        R.drawable.weatheringwithyou
    ),
    Movie(
        7,
        "The Truman Show",
        1998,
        103,
        "Drama / Sci-Fi / Satire",
        "Peter Weir",
        "An ordinary man begins questioning his seemingly perfect life and discovers that his entire existence may be an elaborate television production.",
        R.drawable.thetrumanshow
    ),
    Movie(
        8,
        "31 Minutos, La Película",
        2008,
        87,
        "Comedy / Adventure / Musical",
        "Álvaro Díaz, Pedro Peirano",
        "The eccentric news team from 31 Minutos embarks on a hilarious adventure to rescue their beloved friend Juanín from a mysterious collector.",
        R.drawable.treintayunminutos
    ),
    Movie(
        9,
        "Spider-Man: Across the Spider-Verse",
        2023,
        140,
        "Animation / Action / Sci-Fi",
        "Joaquim Dos Santos, Kemp Powers, Justin K. Thompson",
        "Miles Morales reunites with Gwen Stacy and encounters a society of Spider-People, leading him to challenge their rules to protect the people he loves.",
        R.drawable.across_the_spiderverse
    ),
    Movie(
        10,
        "Spider-Man: Brand New Day",
        2026,
        0,
        "Action / Adventure / Sci-Fi",
        "Destin Daniel Cretton",
        "Peter Parker lives alone in a world that has forgotten him, dedicating himself to being Spider-Man while facing new challenges and changes in his powers.",
        R.drawable.brand_new_day
    ),
    Movie(
        11,
        "2026 TXT MOA CON IN JAPAN: LIVE VIEWING",
        2026,
        0,
        "Concert / Music / Live Viewing",
        "TOMORROW X TOGETHER",
        "A concert event celebrating TOMORROW X TOGETHER and bringing MOA together to experience the group's music and live performances on the big screen.",
        R.drawable.moaco
    )
)
