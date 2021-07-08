package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.ButtonType
import react.RProps
import react.dom.br
import react.functionalComponent
import styled.*

val Volunteers = functionalComponent<RProps> {
    styledP {
        css {
            +koders.chapo
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            margin(LinearDimension.auto, 4.rem)

            "a" {
                color = Color.koders.krouille
                borderBottom(0.05.rem, BorderStyle.solid, Color.koders.krouille)
            }
        }

        +"Do you want to see the event from the inside?"
        br {}
        +"To take part to the adventure as a volunteer please contact us at "
        styledA(href = "mailto:contact@kodein.net") {
            +"contact@kodein.net"
        }
        +"."
    }
}