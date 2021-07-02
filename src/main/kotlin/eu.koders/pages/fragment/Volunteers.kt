package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.flexColumn
import eu.koders.utils.hairline
import eu.koders.utils.landscapeMobile
import eu.koders.utils.maxSize
import kotlinx.css.*
import kotlinx.html.ButtonType
import react.RProps
import react.dom.br
import react.functionalComponent
import styled.css
import styled.styledButton
import styled.styledP
import styled.styledSpan

val Volunteers = functionalComponent<RProps>() {
    flexColumn {
        css {
            width = 100.pct
            height = 100.vh
            backgroundColor = Color.koders.klycine
        }

        styledP {
            css {
                +koders.display3
                color = Color.koders.kinzolin
                marginTop = 1.rem
                specific {
                    fontWeight = FontWeight.hairline
                    textAlign = TextAlign.center
                }
            }

            +"Volunteers"
        }

        styledSpan {
            css {
                display = Display.block
                width = 0.05.rem
                height = 5.rem
                opacity = .7
                backgroundColor = Color.koders.kinzolin
                margin(LinearDimension.auto, LinearDimension.auto)
                maxSize(768) {
                    height = 3.rem
                    margin(LinearDimension.auto, LinearDimension.auto)
                }
                landscapeMobile {
                    margin(1.rem, LinearDimension.auto)
                }
            }
        }

        styledP {
            css {
                +koders.body
                color = Color.koders.kinzolin
                specific {
                    textAlign = TextAlign.center
                }
                margin(0.5.rem, LinearDimension.auto)
            }

            +"Do you want to see the event from the inside?"
            br {}
            +"Fill the form to take part to the adventure as a volunteer."
        }

        styledButton(type = ButtonType.button) {
            css {
                border = "none"
                +koders.button
                margin(1.rem, LinearDimension.auto)
            }

            +"VOLUNTEER FORM"
        }
    }
}