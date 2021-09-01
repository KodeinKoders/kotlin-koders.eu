package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.data.Session
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.functionalComponent
import styled.*

val Workshops = functionalComponent<RProps> {
    styledP {
        css {
            +koders.body
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            marginTop = (-2).rem
            padding(horizontal = 1.rem)
        }

        +"December 1st, venue in Paris (to be announced)"
    }

    flexRow(justifyContent = JustifyContent.center, alignItems = Align.center) {
        css {
            maxWidth = 75.pct
            margin(0.rem, LinearDimension.auto)
            maxWidth(980) {
                flexDirection = FlexDirection.column
            }
        }

        flexRow {
            css {
                maxWidth(980) {
                    marginBottom = 1.rem
                }
            }

            child(Shootout) {
                attrs.number = "1"
                attrs.desc = "Day"
            }

            child(Shootout) {
                attrs.number = "3"
                attrs.desc = "Themes"
            }
        }
    }

    styledP {
        css {
            +koders.chapo
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            margin(LinearDimension.auto, 4.rem)
        }

        +"Learn key development knowledge with Kotlin experts."
    }

    styledDiv {
        css {
            maxWidth = 68.rem
            margin(LinearDimension.auto)
        }

        Session.Workshop.all
            .sortedBy { it.data.title }
            .forEach { workshop ->
                styledP {
                    css {
                        fontFamily = koders.picon
                        color = Color.koders.krouille
                        margin(1.5.rem, 1.rem)
                        "a" {
                            transition(::color, 0.3.s)
                            hover {
                                color = KodersColors.kamethiste
                            }
                        }
                    }
                    styledA(href = "#/workshop/${workshop.id}") {
                        css {
                            fontWeight = FontWeight.w900
                            fontSize = 1.8.rem
                            portraitMobile {
                                fontSize = 1.2.rem
                            }
                        }
                        +workshop.data.title.uppercase()
                    }
                    br {}
                    styledSpan {
                        css {
                            fontWeight = FontWeight.w400
                        }
                        +"by ${workshop.data.speakers.joinToString { it.data.name }}"
                    }
                }
            }
    }

    styledA(
        href = "https://www.billetweb.fr/kotlin-koders-2021",
        target = "_blank"
    ) {
        css {
            border = "none"
            +koders.button
            margin(LinearDimension.auto)
        }

        +"BUY BLIND BIRD!"
    }
}
