package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.ButtonType
import react.RProps
import react.dom.br
import react.functionalComponent
import styled.css
import styled.styledButton
import styled.styledP
import styled.styledSpan

val Conferences = functionalComponent<RProps>() {
    flexColumn {
        css {
            width = 100.pct
            height = 50.vh
            maxSize(580) {
                height = 100.vh
            }
            backgroundColor = Color.koders.cute
        }

        styledP {
            css {
                +koders.display3
                color = Color.koders.darker
                margin(1.5.rem, LinearDimension.auto)
                specific {
                    fontWeight = FontWeight.light
                    textAlign = TextAlign.center
                }
            }

            +"Conferences"
        }

        styledSpan {
            css {
                display = Display.block
                width = 0.05.rem
                height = 5.rem
                opacity = .7
                backgroundColor = Color.koders.korail
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

        styledButton(type = ButtonType.button) {
            css {
                border = "none"
                +koders.button
                margin(2.rem, LinearDimension.auto)
            }

            +"SUBMIT YOUR TALK"
        }
    }
}