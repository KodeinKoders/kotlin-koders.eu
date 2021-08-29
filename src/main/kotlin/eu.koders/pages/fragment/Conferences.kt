package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.components.Section
import eu.koders.data.Data
import eu.koders.data.Speaker
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.dom.div
import react.functionalComponent
import styled.*

val Conferences = functionalComponent<RProps> {
    styledP {
        css {
            +koders.body
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            marginTop = (-2).rem
        }

        +"December 2nd, Pan Piper"
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
                attrs.number = "2"
                attrs.desc = "Tracks"
            }
        }

        flexRow {
            child(Shootout) {
                attrs.number = "20+"
                attrs.desc = "Speakers"
            }

            child(Shootout) {
                attrs.number = "250"
                attrs.desc = "Attendees"
            }
        }
    }

    flexRow(justifyContent = JustifyContent.center) {
        css {
            flexWrap = FlexWrap.wrap
            maxWidth = 68.rem
            margin(LinearDimension.auto)
        }

        Speaker.all
            .sortedBy { it.data.name }
            .plus(Data("next", Speaker("...stay tuned!", "")))
            .forEach { speaker ->
                styledA(href = "#/speaker/${speaker.id}") {
                    css {
                        display = Display.flex
                        flexDirection = FlexDirection.row
                        alignItems = Align.center
                        width = 20.rem
                        margin(1.rem)
                        color = Color.koders.krouille
                        transition(::color, 0.3.s)
                        hover {
                            color = KodersColors.kamethiste
                        }
                    }
                    styledImg(src = "/imgs/speakers/${speaker.id}.jpeg") {
                        css {
                            width = 6.rem
                            marginRight = 0.5.rem
                            borderRadius = 0.25.rem
                        }
                    }
                    styledP {
                        css {
                            fontFamily = koders.piconExtended
                            fontWeight = FontWeight.w900
                            fontSize = 1.4.rem
                        }
                        speaker.data.name.uppercase().split(" ").forEach {
                            +it
                            br {}
                        }
                    }
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

        +"Join us to hear about the future of Kotlin, with key industry speakers!"
    }

    styledP {
        css {
            margin(LinearDimension.auto)
            landscapeMobile {
                margin(0.5.rem, LinearDimension.auto)
            }

        }
        styledA(
            href = "https://www.billetweb.fr/kotlin-koders-2021",
            target = "_blank"
        ) {
            css {
                border = "none"
                +koders.button
            }

            +"BUY EARLY BIRD!"
        }
        styledSpan {
            css {
                padding(horizontal = 1.rem)
                color = Color.koders.orange
                fontWeight = FontWeight.medium
            }
            +"OR"
        }
        styledA(
            href = "https://docs.google.com/forms/d/1Lw04egvA1srqM7BVYe37vcCRWJDMeCltCwaNomnOEAc",
            target = "_blank"
        ) {
            css {
                border = "none"
                +koders.button
            }

            +"SUBMIT YOUR TALK!"
        }
    }
}

external interface ShootoutProps : RProps {
    var number: String
    var desc: String
}

val Shootout = functionalComponent<ShootoutProps> { props ->
    flexColumn(justifyContent = JustifyContent.center, alignItems = Align.center) {
        css {
            width = 15.rem
            portraitMobile {
                width = 12.rem
            }
        }

        styledP {
            css {
                +koders.display2
                color = Color.koders.orange
            }
            +props.number
        }

        styledP {
            css {
                +koders.display1
                color = Color.koders.kuivre
            }
            +props.desc
        }
    }
}