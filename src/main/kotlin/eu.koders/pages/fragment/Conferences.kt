package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.components.Section
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.functionalComponent
import styled.*

val Conferences = functionalComponent<RProps> {
    flexRow(justifyContent = JustifyContent.center, alignItems = Align.center) {
        styledDiv { css { flexGrow = 1.0 } }

        child(Shootout) {
            attrs.number = "1"
            attrs.desc = "Day"
        }

        child(Shootout) {
            attrs.number = "2"
            attrs.desc = "Tracks"
        }

        child(Shootout) {
            attrs.number = "20+"
            attrs.desc = "Speakers"
        }

        styledDiv { css { flexGrow = 1.0 } }
    }

    styledDiv { css { flexGrow = 1.0 } }

    styledP {
        css {
            +koders.chapo
            color = Color.koders.korail
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
        css { width = 20.rem }

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