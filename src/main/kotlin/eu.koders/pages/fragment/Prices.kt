package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.utils.flexColumn
import eu.koders.utils.flexRow
import eu.koders.utils.maxWidth
import kotlinx.css.*
import react.RProps
import react.dom.b
import react.dom.span
import react.functionalComponent
import styled.css
import styled.styledA


val Prices = functionalComponent<RProps> {

    flexRow(JustifyContent.center) {
        css {
            color = KodersColors.krouille
            gap = 8.rem

            maxWidth(650) {
                flexDirection = FlexDirection.column
                gap = 4.rem
            }

            "b.day" {
                fontWeight = FontWeight.w800
                fontSize = 1.8.rem
            }
            "span.date" {
                fontFamily = koders.piconExtended
                fontSize = 1.rem
                fontWeight = FontWeight.w200
            }
            "b.price" {
                color = KodersColors.orange
                fontSize = 2.2.rem
                paddingTop = 1.rem
            }
            "span.special" {
                color = KodersColors.orange
                fontSize = 1.2.rem
                fontWeight = FontWeight.w400
            }
        }

        flexColumn(alignItems = Align.center) {
            b("day") { +"Conference day" }
            span("date") { +"Thursday, December 2nd" }
            b("price") { +"80€" }
            span("special") { +"(Blind Bird: 50€)" }
        }

        flexColumn(alignItems = Align.center) {
            b("day") { +"Workshop day" }
            span("date") { +"Wednesday, December 1st" }
            b("price") { +"450€" }
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
