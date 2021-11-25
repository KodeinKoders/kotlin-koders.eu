package eu.koders.data

import eu.koders.data.SessionDuration.*


sealed class Session {

    abstract val title: String
    abstract val speakers: List<Data<Speaker>>
    abstract val abstract: String
    abstract val duration: SessionDuration

    companion object : DataHolder<Session>() {
        fun load() {
            Workshop.all
            Talk.all
        }
    }

    data class Talk(
        override val title: String,
        override val speakers: List<Data<Speaker>> = emptyList(),
        override val abstract: String = "",
        override val duration: SessionDuration,
    ) : Session() {
        companion object : DataHolder<Talk>(Session) {
            val Opening by Talk(title = "Opening", duration = SHORT)
            val Break by Talk(title = "Break", duration = SHORT)
            val LongBreak by Talk(title = "Break", duration = LONG)
            val KmmGraphQL by Talk(
                title = "Using GraphQL in a KMM project with Jetpack Compose and SwiftUI",
                speakers = listOf(Speaker.JohnOReilly),
                abstract = """
                    This is a live coding based talk in which John will show how GraphQL, using the Apollo library, can be used in shared code in a Kotlin Multiplatform project with the UI developed using Jetpack Compose on Android and SwiftUI on iOS.
                """.trimIndent(),
                duration = LONG
            )
            val NewInKMP by Talk(
                title = "What's new in Kotlin Multiplatform",
                speakers = listOf(Speaker.LiliiaAbdulina),
                abstract = """
                    To be announced... Stay in touch!
                """.trimIndent(),
                duration = LONG
            )
            val KeepKotlinFun by Talk(
                title = "Keep Kotlin Fun",
                speakers = listOf(Speaker.SebastianAigner),
                abstract = """
                    From emoji generators to multiplayer games, tiny printer drivers, IoT-integrations, or Slack message parsers:
                    prototypes for strange ideas are a great driver for learning opportunities – even just to disprove that something is impossible.

                    I want to share with you the fun and excitement that comes from building something truly exciting,
                    the small ideas that keep us up at night until the first tiny proof of concept has been hacked together.
                    We’ll explore how Kotlin can empower us in making those things, through a blend of language features, libraries, and use cases that you might not come across every day.
                """.trimIndent(),
                duration = LONG
            )
            val CompilerLies by Talk(
                title = "Lies Told By The Kotlin Compiler",
                speakers = listOf(Speaker.GarthGilmour),
                abstract = """
                    In order to interoperate with the JVM, and to implement advanced features, the Kotlin Compiler needs to take some liberties on your behalf.
                    It must translate Kotlin specific constructs into concepts the VM can understand, which requires that it reinterpret your code in unexpected ways.
                    This applies to both simple things like symbol names and complex abstractions like suspending and composable functions.

                    In this talk Garth Gilmour will lift the lid on some of the tricks the Kotlin compiler (with plug-ins) uses to keep your coding life simple, plus show when and how you can influence its output.

                    [See announcement article](https://instil.co/news/kotlin-koders-2021/).
                """.trimIndent(),
                duration = LONG
            )
            val ArrowMetaSerialization by Talk(
                title = "Extending kotlinx.serialization functionality with Arrow Meta",
                speakers = listOf(Speaker.KarinAleksandraMonoid),
                abstract = """
                    Migrating from Jackson to kotlinx.serialization may be quite a challenge due to differences in approaches.
                    One of them is not having a global naming strategy.
                    But can we solve this? Sure, we can with Arrow Meta.

                    Arrow Meta is a functional companion to Kotlin's compiler. 
                    This library opens a way to write compiler plugins, linters and other source transformations.

                    In this talk, we are going to cover the following:
                    
                    - Setup a multi module project for compiler plugin development with gradle.
                    - Overview of Arrow Meta features.
                    - Use case: Adding a global naming strategy to Kotlin Serialization.
                """.trimIndent(),
                duration = LONG
            )
            val KotlinAdoptionAtScale by Talk(
                title = "Kotlin Adoption at Scale",
                speakers = listOf(Speaker.SergeiRybalkin, Speaker.SergeyRyabov),
                abstract = """
                    Usually, Kotlin adoption is a smooth process: do some initial configuration and then follow the typical flow \"writing code → building code → shipping code\".
                    But turns out this experience does not scale well for a really big project.

                    Two Sergei s will walk you through the Kotlin adoption journey at Facebook.
                    You will learn what problems speakers have encountered while trying to bring a new programming language into the biggest mobile codebase: from infrastructure support to hardcode JVM bytecode optimizations. Contains bloody DEX code.
                """.trimIndent(),
                duration = LONG
            )
            val KMPAtDeezer by Talk(
                title = "How we moved to KMP at Deezer",
                speakers = listOf(Speaker.AnthonyPages, Speaker.GeoffreyMetais),
                abstract = """
                    After benchmarking cross-platform technologies, we decide to set up KMP at Deezer.

                    How did we integrated this new technology with our three main platforms: Android, iOS and Web?
                    How did we deal with the stacks specific needs? How did the technology been accepted by ours stacks? Here is our Story...
                """.trimIndent(),
                duration = SHORT
            )
            val FunctionalInSpringBoot by Talk(
                title = "From annotation-based configuration to functional in Spring Boot apps with Kotlin",
                speakers = listOf(Speaker.NicolasFrankel),
                abstract = """
                    In the latest years, there has been some push-back against frameworks, and more specifically annotations: some call them magic.
                    Obviously, they make understanding the flow of the application harder.

                    Spring and Spring Boot latest versions go along this trend, by offering an additional way to configure beans with explicit code instead of annotations.
                    It’s declarative in the sense it looks like configuration, though it’s based on Domain-Specific Language(s).
                    This talk aims to demo a step-by-step process to achieve that.
                """.trimIndent(),
                duration = LONG
            )
            val http4KLiveCoding by Talk(
                title = "Live coding server as a function with http4k",
                speakers = listOf(Speaker.DmitryKandalov),
                abstract = """
                    Http4k is a lightweight HTTP library written in Kotlin that enables serving and consuming of HTTP services in a functional and testable way.
                    Unlike many other libraries and frameworks which have complicated abstractions and workflows, http4k captures the essence of communication over HTTP with a few simple concepts.
                    In this session I will explain and demo the core concepts in http4k by live coding from scratch an HTTP server which will simulate the board from the noughts and crosses game.
                """.trimIndent(),
                duration = LONG
            )
            val CICDWithKotlin by Talk(
                title = "Winning CI/CD with Kotlin",
                speakers = listOf(Speaker.ZanMarkan),
                abstract = """
                    DevOps teams often have to build and maintain their own CI/CD pipelines.
                    This at first seems straightforward to implement and maintain.
                    Yet it can often quickly become a tedious time sink and a source of universal frustration on many teams.

                    From flaky builds, to long running builds, to flaky long running builds, the sources of frustration are endless.
                    With the goal to ship more and faster as well as to compete in an ever changing industry, we can (and must) do better.

                    This talk will cover best practices for performance, stability, security, and maintainability of CI/CD pipelines focusing on Kotlin projects, each supported with practical examples and counterexamples.
                """.trimIndent(),
                duration = SHORT
            )
            val QuickStartKMP by Talk(
                title = "Quick start native mobile Kotlin/Multiplatform setup",
                speakers = listOf(Speaker.SalomonBrys),
                abstract = """
                    Kotlin/Multiplatform is a complicated piece of tech! Because it chose to integrate inside native development tools & workflows, setting up a clean and shareable project can be complicated.
                    Here’s everything you need to set up a production ready architecture.

                    In this talk, we will explain how to architecture your code for a multi-platform mobile application,
                    how to efficiently share business & behaviour code between your native apps, and how to configure each project (Common, Android & iOS) to link them to the business library.
                    We’ll discuss various patterns that we can use to standardise communication between the frontend (the UI) and the backend (the business logic) to ensure that the behaviour of our application remains strictly equivalent no matter the actual platform.
                    We’ll also show how to automatically test your common code, and how to deploy the various produced artifacts when working with application specific teams.
                """.trimIndent(),
                duration = SHORT
            )
            val AnimatingCompose by Talk(
                title = "Intro to Animating things with Jetpack Compose",
                speakers = listOf(Speaker.ThomasPucci),
                abstract = """
                    You have probably heard about Jetpack Compose, the Android way to build Declarative UI!
                    How to create SOLID Animations in Jetpack Compose?

                    I recreated some famous apps animations in Jetpack Compose. And I share with you what I learned from it.
                """.trimIndent(),
                duration = SHORT
            )
            val ReliableWebServices by Talk(
                title = "Building reliable web services with Kotlin Ktor",
                speakers = listOf(Speaker.JulienSalvi),
                abstract = """
                    Through this live coding session, you will learn how to setup a Kotlin Ktor project with some routes
                    using the framework tools and features (Routing, DataConversion, ContentNegotiation...) and communicate with a sample Android app.

                    Let see how we can easily setup a Postgres database connection with Exposed, an ORM library for Kotlin and see how clean architecture can be a good choice for developing your brand new API.

                    We can even go further and see that we can actually share code between your backend application and your Android application (say hi to Swagger!).
                """.trimIndent(),
                duration = LONG
            )
            val GradleKotlinDSL by Talk(
                title = "Gradle: a deeper look at the Kotlin DSL",
                speakers = listOf(Speaker.MartinBonnin),
                abstract = """
                    Originally designed for Groovy, Gradle now supports writing scripts in Kotlin.
                    Writing your scripts in Kotlin brings more compile-type safety and IDE features but also has a few drawbacks.

                    In this talk, we will take a look some widely used Groovy constructs, their Kotlin equivalent and what’s happening under the hood.
                    We will explore how Gradle loads scripts and uses Kotlin compiler flags to allow a the Kotlin DSL syntax.

                    We will also look at the limitation like compilation time and fixed Kotlin runtime version and how to mitigate them.
                """.trimIndent(),
                duration = SHORT
            )
            val KotlinNativeFromTheTrenches by Talk(
                title = "Kotlin Native from the trenches",
                speakers = listOf(Speaker.GaetanZoritchak),
                abstract = """
                    This presentation will share our feedback on the challenges we faced to provide an iOS version of our multiplatform dataviz library:
                    
                    - interop with low-level objective C APIs
                    - providing an easy of use library for Kotlin developers
                    - integration into iOS projects
                """.trimIndent(),
                duration = LONG
            )
            val ExploringAdvancedCompose by Talk(
                title = "Exploring Advanced Jetpack Compose Features",
                speakers = listOf(Speaker.FilipBabic),
                abstract = """
                    In this talk, we’ll dive into more \"advanced\" Jetpack Compose features that rely on architecture, generics and meaningful motion.
                    These are all topics that go beyond the basics of creating Compose UI, that are crucial in every app!

                    W’ll explore state handling and reactive and uniform data flow structures - how to connect Compose components to observable structures such as LiveData, coroutine Flows, Rx and finally State structures from the Compose framework.
                    You’ll learn how to show different types of UI based on state and how Compose reacts to state changes to re-draw the UI.

                    Next, you’ll learn about beautiful and easy to implement animations and how to use the Transition API to animate multiple states at the same time.
                    Finally, once you create the animations, you’ll learn how to apply the state from them to your UI for smooth screen transitions.

                    And last, but not least, we’ll talk about code reusability through generics and generic Composable functions.
                    With the power of Kotlin and its strong type system, in pair with Compose being fully written in Kotlin and relying on functions, you can create truly reusable generic components, without much code.

                    Join me in this talk and you’ll get a better sense of how awesome Compose can be!
                """.trimIndent(),
                duration = LONG
            )
            val KMPLightningNode by Talk(
                title = "KMM case study, with Phoenix and Bitcoin",
                speakers = listOf(Speaker.DominiquePadiou),
                abstract = """
                    At ACINQ we have been developing complex Bitcoin mobile applications running on Android and the JVM.
                    In order to also support iOS, we moved to Kotlin Multiplatform.

                    We'll talk about our experience of migrating a large codebase from Scala to Kotlin Multiplatform,
                    with some focus on how we leveraged the device's native cryptography API.
                    We'll also look into the KMM module shared between the Android and the iOS apps,
                    and give you some feedback regarding the iOS developers' experience.
                """.trimIndent(),
                duration = SHORT
            )
            val BridgingKotlinAndSwift by Talk(
                title = "Bridging the gap between Kotlin and Swift",
                speakers = listOf(Speaker.AydarMukhametzyanov),
                abstract = """
                    Tooling and technologies around Kotlin Multiplatform always leave Apple platforms a little overboard.
                    After all, Kotlin is a part of Android development, not in iOS. I will tell you what we do to fix it.
                    You will learn about the Kotlin Multiplatform Mobile plugin for AppCode, what it was created for, and what it can do at the moment.
                    I will show the latest developments in the Kotlin Multiplatform, and will tell you how they work from the inside.
                """.trimIndent(),
                duration = LONG
            )
        }
    }

    data class Workshop(
        override val title: String,
        override val speakers: List<Data<Speaker>>,
        override val abstract: String,
        val requirements: String,
        val content: List<String>,
        override val duration: SessionDuration = DAY,
    ) : Session() {
        companion object : DataHolder<Workshop>(Session) {
            val Spring by Workshop(
                title = "Reactive Coding in Spring with Kotlin, Reactor, WebFlux and R2DBC",
                speakers = listOf(Speaker.GarthGilmour),
                abstract = """
                    Spring has traditionally been used to build synchronous applications in Java, based around the JEE specifications. But more recent releases have added extensive support for both the Kotlin language and the functional / reactive approach.
                    A new reactive library (Project Reactor) is at the heart of Spring 5. This in turn enables the creation of reactive versions of Spring frameworks. WebFlux replaces Spring MVC for creating microservices, whilst Spring Data R2DBC is available for accessing data stores.
                    This workshop will enable you to create Spring projects in Kotlin which perform all their operations in an asynchronous and reactive manner. Integration with Kotlin will be covered in depth, including support for Coroutines and Kotlin specific DSL’s.
                """.trimIndent(),
                requirements = """
                    Delegates must be proficient in Kotlin and have prior experience in Web Application development. Prior knowledge of Spring is advantageous but not essential.
                """.trimIndent(),
                content = listOf(
                    "Core Spring Concepts",
                    "Introducing Project Reactor",
                    "Building Services with WebFlux",
                    "Database Access With R2DBC"
                )
            )
            val Coroutines by Workshop(
                title = "Efficient asynchronous Kotlin with Coroutines",
                speakers = listOf(Speaker.KarinAleksandraMonoid),
                abstract = """
                    Kotlin's approach to working with asynchronous code is using coroutines. The idea behind coroutines is that a function (or a computation) can be suspended and resumed later on.
                    Coroutines in Kotlin can also be imagined as a light-weight threads with all the benefits of being non-blocking and good readability compared to callbacks.
                    During the workshop you will start from the basics of the asynchronous programming in Kotlin and dive deep gradually into more advanced topics like coroutine contexts, shared states and how everything works under the hood.
                """.trimIndent(),
                requirements = """
                    Basic knowledge of Kotlin (Collection API included) is expected from participants.
                """.trimIndent(),
                content = listOf(
                    "Introduction to asynchronous programming and coroutines",
                    "Coroutines in depth: contexts, scopes, builders",
                    "Shared state. Exception handling",
                    "Streams, Channels, Flows",
                    "Testing"
                )
            )
            val Multiplatform by Workshop(
                title = "Kotlin Multiplatform for native mobile applications",
                speakers = listOf(Speaker.SalomonBrys, Speaker.RomainBoisselle),
                abstract = """
                    In recent years, Kotlin/Multiplatform has become one of the most hot topic in both Kotlin & the mobile application industry. Its novel promise makes a lot of sense to seasoned application creators: only share business code, and leave UI & platform integration code to the platform itself & its experts.
                    In this workshop we'll learn how to leverage the Kotlin language and tooling to create shared business and behaviour code across major mobile platforms: Android, iOS and the Web. We'll see how to define the architecture of our applications, create the necessary abstractions for code sharing, how to test our code on each platforms, and how to deploy and integrate our common code in each platform.
                    Through a series of simple exercises we'll build a business application together which will be deployed to each platform, each with their corresponding UI layer, and platform specificities.
                """.trimIndent(),
                requirements = """
                    Attendees are expected to understand basic Kotlin, as well as having development experience in at least one mobile application platform.
                    Note that while it is recommended to have a MacBook, as we'll be targeting iOS, it is not mandatory as you'll still be able to leverage multiplatform code to target Android, the Web, and Kotlin/Native.
                """.trimIndent(),
                content = listOf(
                    "Create a Multiplatform Project with Gradle",
                    "Test & deploy your code for each targeted platform",
                    "Integrate your shared code in native applications",
                    "Architecture your API with best practices & design patterns",
                    "Use multiplatform libraries"
                )
            )
        }
    }
}

enum class SessionDuration { LONG, SHORT, DAY }
