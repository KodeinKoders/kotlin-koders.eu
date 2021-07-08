package eu.koders.components

import eu.koders.charter.koders
import eu.koders.utils.flexColumn
import eu.koders.utils.light
import kotlinx.css.*
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledP

external interface SectionProps : RProps {
    var index: Int
    var title: String
    var ratio: Double?
}

val Section = functionalComponent<SectionProps> { props ->
    flexColumn {
        css {
            width = 100.pct
            props.ratio?.let {
                height = (it * 100).vh
            }
            backgroundColor = Color.koders.kaumon.withAlpha(1 - (0.2 * props.index))
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

            +props.title
        }

        styledDiv { css { flexGrow = 1.0 } }

        props.children()

        styledDiv { css { flexGrow = 1.0 } }
    }

}