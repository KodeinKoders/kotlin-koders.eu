package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.components.Section
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.dom.div
import react.functionalComponent
import styled.*

val Conferences = functionalComponent<RProps> {
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
                attrs.number = "250+"
                attrs.desc = "Attendees"
            }
        }

        flexRow {
            child(Shootout) {
                attrs.number = "2"
                attrs.desc = "Tracks"
            }

            child(Shootout) {
                attrs.number = "20+"
                attrs.desc = "Speakers"
            }
        }
    }

    styledDiv { css { flexGrow = 1.0 } }

    styledP {
        css {
            +koders.chapo
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            margin(LinearDimension.auto, 4.rem)
        }

        +"Conferences are nothing without their amazing speakers."
        br {}
        +"We are very excited to see what you have to share with the community :)."
    }

    styledDiv { css { flexGrow = 1.0 } }

    styledButton(type = ButtonType.button) {
        css {
            border = "none"
            +koders.button
            margin(2.rem, LinearDimension.auto)
        }

        +"SUBMIT YOUR TALK"
    }
}

external interface ShootoutProps : RProps {
    var number: String
    var desc: String
}

private val Shootout = functionalComponent<ShootoutProps> { props ->
    flexColumn(justifyContent = JustifyContent.center, alignItems = Align.center) {
        css {
            flexGrow = 1.0
            width = 15.rem
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