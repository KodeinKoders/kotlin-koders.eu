package eu.koders.data


data class Speaker(
    val name: String,
    val bio: String,
    val company: String,
) {
    companion object : DataHolder<Speaker>() {
        val GarthGilmour by Speaker(
            name = "Garth Gilmour",
            bio = """
                    Garth is 'Head of Learning' at Instil Software in Belfast.
                    Since 1999 he's taught C++ to C coders, Java to C++ coders, C# to Java coders and Kotlin to everyone.
                    He is a Kotlin GDE, author of over 20 courses, prolific conference speaker and co-organiser of the Belfast BASH Meetup and KUG.
                    Outside of work he is a martial arts instructor and weightlifter.
                """.trimIndent(),
            company = "Instil"
        )
        val JohnOReilly by Speaker(
            name = "John O'Reilly",
            bio = """
                    John is Kotlin GDE that has been developing Android apps since 2010.
                    He worked on server side Java applications in the 2000s and desktop clients in the 1990s....and is waiting in anticipation to see what the 20s bring!
                """.trimIndent(),
            company = "Neat"
        )
        val KarinAleksandraMonoid by Speaker(
            name = "Karin-Aleksandra Monoid",
            bio = """
                    Karin is a Senior Software Engineer with background in various programming languages.
                    Currently she is specializing in Kotlin and advocating for functional programming (the good parts!).
                    She probably tried your favorite backend language on frontend (Scala.js and Kotlin/JS).
                """.trimIndent(),
            company = ""
        )
        val LeonidStartsev by Speaker(
            name = "Leonid Startsev",
            bio = """
                    Developer in Kotlin Libraries team at JetBrains, maintainer of kotlinx.serialization.
                """.trimIndent(),
            company = "JetBrains"
        )
        val LiliiaAbdulina by Speaker(
            name = "Liliia Abdulina",
            bio = """
                    I work in Kotlin, JetBrains for more than 4 years already.
                    I have been Kotlin Multiplatform QA from almost its beginning, have worked with the very first model (which was before Kotlin 1.3) and even met a bit headers/impl instead of well known expect/actual keywords.
                    For a long time I was a single QA there, now there are 2.5 of us, including me who leads the whole Kotlin QA team nowadays. 
                """.trimIndent(),
            company = "JetBrains"
        )
        val SalomonBrys by Speaker(
            name = "Salomon Brys",
            bio = """
                    Salomon is the creator and maintainer of the KODEIN multiplatform framework as well as the founder of KODEIN Koders.
                    Deeply rooted in the Open-Source philosophy, he is dedicated to making tools and libraries to make programming easier, safer, and more exciting.
                    He is a Kotlin GDE, Kotlin certified trainer, KUG Paris co-organiser, and conference speaker.
                    He also loves dancing Rock'n'Roll, playing boardgames, and flying small planes.
                """.trimIndent(),
            company = "KODEIN Koders"
        )
    }
}

fun Data<Speaker>.sessions() = Session.all.filter { this.id in it.data.speakers.map { it.id } }
