package eu.koders.components

import eu.koders.charter.koders
import eu.koders.utils.PRuleSet
import eu.koders.utils.clipPath
import eu.koders.utils.flexColumn
import eu.koders.utils.light
import kotlinx.css.*
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledP

external interface SectionProps : RProps {
    var index: Int
    var title: String
    var css: PRuleSet?
}

val Section = functionalComponent<SectionProps> { props ->
    styledDiv {
        css {
            backgroundColor = Color.white
            marginTop = (-5).rem
            clipPath = "polygon(0 0, 100% 0, 100% calc(100% - 5rem), 0 100%)"
            position = Position.relative
            zIndex = 5 - props.index
        }

        flexColumn {
            css {
                width = 100.pct
                backgroundColor = Color.koders.kaumon.withAlpha(1 - (0.1666 * props.index))
                padding(vertical = 6.rem)
                gap = 2.5.rem
                props.css?.invoke(this)
            }

            styledH2 {
                css {
                    +koders.display3
                    color = Color.koders.kinzolin
                    margin(LinearDimension.auto)
                    specific {
                        fontWeight = FontWeight.light
                        textAlign = TextAlign.center
                    }
                }

                +props.title
            }

            props.children()
        }
    }
}