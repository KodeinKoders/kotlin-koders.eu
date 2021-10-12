package eu.koders.data


data class Speaker(
    val name: String,
    val bio: String,
    val company: String = "",
    val twitter: String = "",
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
            company = "Instil",
            twitter = "GarthGilmour"
        )
        val JohnOReilly by Speaker(
            name = "John O'Reilly",
            bio = """
                    John is Kotlin GDE that has been developing Android apps since 2010.
                    He worked on server side Java applications in the 2000s and desktop clients in the 1990s....and is waiting in anticipation to see what the 20s bring!
                """.trimIndent(),
            company = "Neat",
            twitter = "joreilly"
        )
        val KarinAleksandraMonoid by Speaker(
            name = "Karin-Aleksandra Monoid",
            bio = """
                    Karin is a Senior Software Engineer with background in various programming languages.
                    Currently she is specializing in Kotlin and advocating for functional programming (the good parts!).
                    She probably tried your favorite backend language on frontend (Scala.js and Kotlin/JS).
                """.trimIndent(),
            twitter = "paranoidmonoid"
        )
        val SebastianAigner by Speaker(
            name = "Sebastian Aigner",
            bio = """
                    As a Kotlin Developer Advocate at JetBrains, Sebastian spends a lot of time thinking about how technologies can empower and delight people. 
                    He loves building networked applications and using Kotlin on a multitude of platforms, as well as hacking up strange ideas late at night.
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
            company = "JetBrains",
            twitter = "var_lynx"
        )
        val SalomonBrys by Speaker(
            name = "Salomon Brys",
            bio = """
                    Salomon is the creator and maintainer of the KODEIN multiplatform framework as well as the founder of KODEIN Koders.
                    Deeply rooted in the Open-Source philosophy, he is dedicated to making tools and libraries to make programming easier, safer, and more exciting.
                    He is a Kotlin GDE, Kotlin certified trainer, KUG Paris co-organiser, and conference speaker.
                    He also loves dancing Rock'n'Roll, playing boardgames, and flying small planes.
                """.trimIndent(),
            company = "KODEIN Koders",
            twitter = "salomonbrys"
        )
        val SergeiRybalkin by Speaker(
            name = "Sergei Rybalkin",
            bio = """
                    Software Engineer @ Facebook (Kotlin Foundation team)
                    Sergei has been working with JVM-based languages for more than 8 years. At Facebook, he is adopting and optimizing Kotlin for Android. Before joining Facebook Sergey worked on Kotlin adoption for the server-side and frameworks at Alibaba Group. Now he develops and maintains Kohttp, a Kotlin DSL HTTP client and Redex, an Android bytecode optimizer.
                """.trimIndent(),
            company = "Facebook",
            twitter = "lightdelay"
        )
        val SergeyRyabov by Speaker(
            name = "Sergey Ryabov",
            bio = """
                    Sergey is a developer from London who paused his nomadic lifestyle to feel the scale and peculiarities of working in Big Tech for himself. At Facebook, he works on Android UI Frameworks, Backend-Driven UI, and helps with the implementation of Kotlin into the largest mobile codebase. In the past, he was involved in the organization of the Kotlin User Group in St. Petersburg and the Android Academy schools in St. Petersburg and Moscow. Has been writing in Kotlin since traits.
                """.trimIndent(),
            company = "Facebook",
            twitter = "colriot"
        )
        val DmitryKandalov by Speaker(
            name = "Dmitry Kandalov",
            bio = """
                    Dmitry has been programming since DOS times. He spent the last 15 years or so in Java lands most recently working with server-side Kotlin.
                """.trimIndent(),
            company = "Code Mine"
        )
        val AnthonyPages by Speaker(
            name = "Anthony Pages",
            bio = """
                    Lead KMP at Deezer.
                """.trimIndent(),
            company = "Deezer"
        )
        val GeoffreyMetais by Speaker(
            name = "Geoffrey Metais",
            bio = """
                    Lead KMP at Deezer.
                """.trimIndent(),
            company = "Deezer",
            twitter = "geoffreymetais"
        )
        val NicolasFrankel by Speaker(
            name = "Nicolas Fränkel",
            bio = """
                    Developer Advocate with 15+ years experience consulting for many different customers, in a wide range of contexts (such as telecoms, banking, insurances, large retail and public sector). 
                    Usually working on Java/Java EE and Spring technologies, but with focused interests like Rich Internet Applications, Testing, CI/CD and DevOps. 
                    Currently working for Hazelcast. Also double as a trainer and triples as a book author.
                """.trimIndent(),
            company = "Hazelcast",
            twitter = "nicolas_frankel"
        )
        val ZanMarkan by Speaker(
            name = "Zan Markan",
            bio = """
                    Zan Markan is a developer advocate at CircleCI, on a mission to educate and inspire developers on the topics of CI/CD, DevOps, and software quality. 
                    Across his career he has worked in companies of various sizes, from enterprises to own startups, and everything in between, and across industries as diverse as retail, AI, and developer tools. 
                    He’s passionate about serverless technologies, mobile development, and developer experience. 
                    Outside of work, he enthuses over airplanes, craft beer, and the Oxford comma.
                """.trimIndent(),
            company = "CircleCI",
            twitter = "zmarkan"
        )
        val ThomasPucci by Speaker(
            name = "Thomas Pucci",
            bio = """
                    Former React-Native expert, I jumped in Kotlin Android App development 3 years ago. I work at BAM as Head of Native and manage several developer teams working in Kotlin and Swift.
                    I share my thoughts about Kotlin and Android on Twitter and like to experiment in Jetpack Compose on my spare time !
                """.trimIndent(),
            company = "BAM",
            twitter = "Thomas_Pucci"
        )
        val JulienSalvi by Speaker(
            name = "Julien Salvi",
            bio = """
                    Into the Android world for almost 10 years (scary Eclipse dark time!), I experienced California startup way of life before coming back to France. 
                    I am currently a Senior Android Engineer at Aircall where we are building the best phone system for modern businesses. 
                    Alongside Android, I have a great interest in backend development with Kotlin and AR/VR technology. 
                    In 2021, I became an Android GDE to continue my journey to always share and learn with the Android community. 
                    On my spare time, I am a world traveler and a beer lover always looking for the best IPAs!
                """.trimIndent(),
            company = "Aircall",
            twitter = "JulienSalvi"
        )
        val MartinBonnin by Speaker(
            name = "Martin Bonnin",
            bio = """
                    Parisian developer with a thing for type safe APIs and Chocolate Bugdroids 🍫
                """.trimIndent(),
            company = "ApolloGraphQL",
            twitter = "MartinBonnin"
        )
        val GaetanZoritchak by Speaker(
            name = "Gaetan Zoritchak",
            bio = """
                    Early Adopter of Kotlin, I’m working on dataviz and charting multiplatform libraries
                """.trimIndent(),
            company = "data2viz",
            twitter = "gz_k"
        )
        val FilipBabic by Speaker(
            name = "Filip Babić",
            bio = """
                    Filip Babić is a senior Android developer from Croatia, and a Google Developer Expert for Android & Kotlin. 
                    He’s currently working on building awesome things with Jetpack Compose, teaching people about topics in Android and Kotlin and sharing his knowledge in various types of community engagement.
                """.trimIndent(),
            company = "Stream",
            twitter = "filbabic"
        )
        val RomainBoisselle by Speaker(
            name = "Romain Boisselle",
            bio = """
                    Romain has been coding for almost 15 years. For some times, he has been working on server side architectures with Java, then with Kotlin since its early days. 
                    He added a new string to its bow at KotlinConf 2018, where he met Salomon and started contributing to Kodein-DI, the very first Kotlin/Multiplatform community library.
                    He loves wild spaces, mountain hikes and climbing.
                """.trimIndent(),
            company = "KODEIN Koders",
            twitter = "romainbsl"
        )
        val DominiquePadiou by Speaker(
            name = "Dominique Padiou",
            bio = """
                    Dominique is the developer behind Eclair Mobile, Phoenix and Strike. 
                    He believes that a lean and simple user experience is one Lightning's key challenges. 
                    He's determined to make Lightning easy to use and Bitcoin accessible to everyone.
                """.trimIndent(),
            company = "ACINQ"
        )
        val AydarMukhametzyanov by Speaker(
            name = "Aydar Mukhametzyanov",
            bio = """
                I had been developing iOS applications since iOS 5 in a mobile agency, 
                in a large and cozy 2GIS, and Freeletics in Munich. I currently work at JetBrains, 
                AppCode team, but still remember how it feels to be a mobile developer. 
                I write code in Kotlin/Java so that people are comfortable writing in Swift/Objective-C.
            """.trimIndent(),
            company = "JetBrains",
            twitter = "aydarmukh"
        )
    }
}

fun Data<Speaker>.sessions() = Session.all.filter { this.id in it.data.speakers.map { it.id } }
