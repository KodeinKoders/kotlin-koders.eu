package eu.koders.pages

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.utils.flexRow
import eu.koders.utils.portraitMobile
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RProps
import react.dom.br
import react.functionalComponent
import styled.*


val NextInfo = functionalComponent<RProps> {
    styledH2 {
        css {
            fontFamily = koders.picon
            fontWeight = FontWeight.w900
            fontSize = 2.4.rem
            color = Color.koders.krouille
            portraitMobile {
                fontSize = 1.6.rem
            }
        }
        +"There's a lot more to come!"
    }

    flexRow(alignItems = Align.center) {
        css {
            width = 20.rem
            portraitMobile {
                width = 18.rem
            }
            margin(1.rem)
            color = Color.koders.krouille
        }
        styledImg(src = "/imgs/speakers/next.jpeg") {
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
                portraitMobile {
                    fontSize = 1.2.rem
                }
            }
            +"...STAY"
            br {}
            +"TUNED!"
        }
    }


    styledP {
        css {
            +koders.body
            color = KodersColors.dark
        }
        +"Follow us on "
        styledA(href = "https://twitter.com/kotlinkoders", target = "_blank") {
            css {
                color = KodersColors.orange
                fontWeight = FontWeight.w700
                transition(::color, 0.3.s)
                hover {
                    color = KodersColors.purple
                }
            }
            +"Twitter"
        }
        +" to stay up to date with our announcements!"
    }
}
