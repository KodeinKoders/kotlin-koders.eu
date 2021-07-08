package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.components.Section
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.functionalComponent
import styled.*

val Partners = functionalComponent<RProps>() {
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

        +"You want to give your brand some visibility or increase your popularity among Kotlin developers?"
        br { }
        +"For partnership opportunities, contact us at "
        styledA(href = "mailto:contact@kodein.net") {
            +"contact@kodein.net"
        }
        +"."
    }

    /* TODO finalize de sponsor deck
    styledButton(type = ButtonType.button) {
        css {
            border = "none"
            +koders.button
            margin(2.rem, LinearDimension.auto)
        }

        +"GET THE SPONSOR DECK"
    }
    */
}
