package eu.koders.data

import eu.koders.charter.koders
import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import kotlinx.css.textDecoration
import react.RRender
import react.dom.*
import styled.css
import styled.styledA


sealed class Session {

    abstract val title: String
    abstract val speakers: List<Data<Speaker>>
    abstract val abstract: RRender

    companion object : DataHolder<Session>() {
        fun load() {
            Workshop.all
            Talk.all
        }
    }

    data class Talk(
        override val title: String,
        override val speakers: List<Data<Speaker>>,
        override val abstract: RRender
    ) : Session() {
        companion object : DataHolder<Talk>(Session) {
            val KmmGraphQL by Talk(
                title = "Using GraphQL in a KMM project with Jetpack Compose and SwiftUI",
                speakers = listOf(Speaker.JohnOReilly),
                abstract = {
                    p {
                        +"This is a live coding based talk in which John will show how GraphQL, using the Apollo library, can be used in shared code in a Kotlin Multiplatform project with the UI developed using Jetpack Compose on Android and SwiftUI on iOS."
                    }
                }
            )
            val NewInKMP by Talk(
                title = "What's new in Kotlin Multiplatform",
                speakers = listOf(Speaker.LiliiaAbdulina),
                abstract = {
                    p {
                        +"To be announced... Stay in touch!"
                    }
                }
            )
            val KeepKotlinFun by Talk(
                title = "Keep Kotlin Fun",
                speakers = listOf(Speaker.SebastianAigner),
                abstract = {
                    p {
                        +"From emoji generators to multiplayer games, tiny printer drivers, IoT-integrations, or Slack message parsers: "
                        +"prototypes for strange ideas are a great driver for learning opportunities – even just to disprove that something is impossible."
                    }
                    p {
                        +"I want to share with you the fun and excitement that comes from building something truly exciting, "
                        +"the small ideas that keep us up at night until the first tiny proof of concept has been hacked together. "
                        +"We’ll explore how Kotlin can empower us in making those things, through a blend of language features, libraries, and use cases that you might not come across every day."
                    }
                }
            )
            val CompilerLies by Talk(
                title = "Lies Told By The Kotlin Compiler",
                speakers = listOf(Speaker.GarthGilmour),
                abstract = {
                    p {
                        +"In order to interoperate with the JVM, and to implement advanced features, the Kotlin Compiler needs to take some liberties on your behalf."
                        +"It must translate Kotlin specific constructs into concepts the VM can understand, which requires that it reinterpret your code in unexpected ways."
                        +"This applies to both simple things like symbol names and complex abstractions like suspending and composable functions."
                    }
                    p {
                        +"In this talk Garth Gilmour will lift the lid on some of the tricks the Kotlin compiler (with plug-ins) uses to keep your coding life simple, plus show when and how you can influence its output."
                    }
                    p {
                        styledA(href = "https://instil.co/news/kotlin-koders-2021/"){
                            css {
                                textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
                                color = Color.koders.krouille
                            }

                            +"See announcement article."
                        }
                    }
                }
            )
            val ArrowMetaSerialization by Talk(
                title = "Extending kotlinx.serialization functionality with Arrow Meta",
                speakers = listOf(Speaker.KarinAleksandraMonoid),
                abstract = {
                    p {
                        +"Migrating from Jackson to kotlinx.serialization may be quite a challenge due to differences in approaches."
                        +"One of them is not having a global naming strategy."
                        +"But can we solve this? Sure, we can with Arrow Meta."
                    }
                    p {
                        +"Arrow Meta is a functional companion to Kotlin's compiler."
                        +"This library opens a way to write compiler plugins, linters and other source transformations."
                    }
                    p {
                        +"In this talk, we are going to cover the following:"
                        ul {
                            li { +"Setup a multi module project for compiler plugin development with gradle." }
                            li { +"Overview of Arrow Meta features." }
                            li { +"Use case: Adding a global naming strategy to Kotlin Serialization." }
                        }
                    }
                }
            )
        }
    }

    data class Workshop(
        override val title: String,
        override val speakers: List<Data<Speaker>>,
        override val abstract: RRender,
        val requirements: RRender,
        val content: List<String>
    ) : Session() {
        companion object : DataHolder<Workshop>(Session) {
            val Spring by Workshop(
                title = "Reactive Coding in Spring with Kotlin, Reactor, WebFlux and R2DBC",
                speakers = listOf(Speaker.GarthGilmour),
                abstract = {
                    p { +"Spring has traditionally been used to build synchronous applications in Java, based around the JEE specifications. But more recent releases have added extensive support for both the Kotlin language and the functional / reactive approach." }
                    p { +"A new reactive library (Project Reactor) is at the heart of Spring 5. This in turn enables the creation of reactive versions of Spring frameworks. WebFlux replaces Spring MVC for creating microservices, whilst Spring Data R2DBC is available for accessing data stores." }
                    p { +"This workshop will enable you to create Spring projects in Kotlin which perform all their operations in an asynchronous and reactive manner. Integration with Kotlin will be covered in depth, including support for Coroutines and Kotlin specific DSL’s." }
                },
                requirements = {
                    p { +"Delegates must be proficient in Kotlin and have prior experience in Web Application development. Prior knowledge of Spring is advantageous but not essential." }
                },
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
                abstract = {
                    p { +"Kotlin's approach to working with asynchronous code is using coroutines. The idea behind coroutines is that a function (or a computation) can be suspended and resumed later on. " }
                    p { +"Coroutines in Kotlin can also be imagined as a light-weight threads with all the benefits of being non-blocking and good readability compared to callbacks." }
                    p { +"During the workshop you will start from the basics of the asynchronous programming in Kotlin and dive deep gradually into more advanced topics like coroutine contexts, shared states and how everything works under the hood." }
                },
                requirements = {
                    p { +"Basic knowledge of Kotlin (Collection API included) is expected from participants." }
                },
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
                speakers = listOf(Speaker.SalomonBrys),
                abstract = {
                    p { +"In recent years, Kotlin/Multiplatform has become one of the most hot topic in both Kotlin & the mobile application industry. Its novel promise makes a lot of sense to seasoned application creators: only share business code, and leave UI & platform integration code to the platform itself & its experts." }
                    p { +"In this workshop we'll learn how to leverage the Kotlin language and tooling to create shared business and behaviour code across major mobile platforms: Android, iOS and the Web. We'll see how to define the architecture of our applications, create the necessary abstractions for code sharing, how to test our code on each platforms, and how to deploy and integrate our common code in each platform." }
                    p { +"Through a series of simple exercises we'll build a business application together which will be deployed to each platform, each with their corresponding UI layer, and platform specificities." }
                },
                requirements = {
                    p { +"Attendees are expected to understand basic Kotlin, as well as having development experience in at least one mobile application platform." }
                    p { +"Note that while it is recommended to have a MacBook, as we'll be targeting iOS, it is not mandatory as you'll still be able to leverage multiplatform code to target Android, the Web, and Kotlin/Native." }
                },
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
