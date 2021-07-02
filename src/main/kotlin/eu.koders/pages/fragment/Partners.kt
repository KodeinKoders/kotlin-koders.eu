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

val Partners = functionalComponent<RProps>() {
    flexColumn {
        css {
            width = 100.pct
            height = 50.vh
            maxSize(580) {
                height = 100.vh
            }
            backgroundColor = Color.koders.kaumon
        }

        styledP {
            css {
                +koders.display3
                color = Color.koders.kinzolin
                margin(1.5.rem, LinearDimension.auto)
                specific {
                    fontWeight = FontWeight.light
                    textAlign = TextAlign.center
                }
            }

            +"Partners"
        }

        styledSpan {
            css {
                display = Display.block
                width = 0.05.rem
                height = 5.rem
                opacity = .7
                backgroundColor = Color.koders.orange
                margin(1.rem, LinearDimension.auto)
                maxSize(768) {
                    height = 3.rem
                    margin(0.rem, LinearDimension.auto)
                }
                landscapeMobile {
                    margin(1.rem, LinearDimension.auto)
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
                "a" {
                    color = Color.koders.krouille
                    borderBottom(0.05.rem, BorderStyle.solid, Color.koders.krouille)
                }
            }

            +"You want to give your brand some visibility or increase your popularity among Kotlin developers?"
            br {  }
            +"For partnership opportunities, contact us at "
            styledA(href = "mailto:contact@kodein.net") {
                +"contact@kodein.net"
            }
        }

        styledButton(type = ButtonType.button) {
            css {
                border = "none"
                +koders.button
                margin(2.rem, LinearDimension.auto)
            }

            +"GET THE SPONSOR DECK"
        }
    }
}
