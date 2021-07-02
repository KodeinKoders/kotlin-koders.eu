package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.css.properties.boxShadow
import kotlinx.html.ButtonType
import react.RProps
import react.functionalComponent
import styled.*

val Header = functionalComponent<RProps>() {

    flexColumn {
        css {
            width = 100.pct
            height = 100.vh
            backgroundColor = Color.koders.kyzantium
        }

        styledDiv {
            css {
                margin(LinearDimension.auto)
            }

            styledP {
                css {
                    +koders.display1
                    width = LinearDimension.fitContent
                    color = Color.koders.orange
                    specific {
                        textAlign = TextAlign.center
                    }
                    margin(2.rem, LinearDimension.auto)
                    borderBottom(0.05.rem, BorderStyle.solid, Color.koders.orange)
                }

                +"2nd December - Paris, France"
            }

            styledP {
                css {
                    +koders.display3
                    color = Color.koders.kaumon
                    specific {
                        fontSize = 4.5.rem
                        fontWeight = FontWeight.light
                        textAlign = TextAlign.center
                    }
                    margin(1.rem, 1.rem)
                }

                +"Kotlin"

                styledSpan {
                    css {
                        color = Color.koders.korail
                        specific {
                            fontWeight = FontWeight.w700
                            textAlign = TextAlign.center
                        }
                    }
                    +"KODERS"
                }

                +"2021"
            }

            styledSpan {
                css {
                    display = Display.block
                    width = 0.05.rem
                    height = 7.rem
                    opacity = .7
                    backgroundColor = Color.koders.kaumon
                    margin(1.rem, LinearDimension.auto)
                    maxSize(768) {
                        height = 4.rem
                        margin(0.rem, LinearDimension.auto)
                    }
                    landscapeMobile {
                        height = 5.rem
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
                    margin(2.rem, LinearDimension.auto)
                }

                +"A conference for all Kotlin developers."
            }

            styledA(href = "https://docs.google.com/forms/d/1Lw04egvA1srqM7BVYe37vcCRWJDMeCltCwaNomnOEAc") {
                css {
                    border = "none"
                    +koders.button
                    margin(3.rem, LinearDimension.auto)
                }

                +"SUBMIT YOUR TALK"
            }

        }
    }
}