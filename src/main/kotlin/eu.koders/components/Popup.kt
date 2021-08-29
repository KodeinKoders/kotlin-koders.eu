package eu.koders.components

import eu.koders.charter.KodersColors
import eu.koders.utils.flexColumn
import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.html.js.onClickFunction
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv


external interface OverlayProps : RProps {
    var onClick: () -> Unit
}

val Popup = functionalComponent<OverlayProps> { props ->

    styledDiv {
        css {
            position = Position.fixed
            zIndex = 100
            top = 0.px
            bottom = 0.px
            left = 0.px
            right = 0.px
            backgroundColor = KodersColors.dark.withAlpha(0.8)
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = Align.center
        }

        attrs.onClickFunction = {
            props.onClick()
        }

        flexColumn {
            css {
                width = 95.vw
                maxWidth = 50.rem
                height = 95.vh
                maxHeight = 50.rem
                backgroundColor = KodersColors.cute
                overflowX = Overflow.hidden
                overflowY = Overflow.auto
                borderRadius = 0.2.rem
                boxShadow(Color.black, 0.rem, 0.2.rem, 1.rem)
                padding(2.rem)
                gap = 2.rem
            }

            attrs.onClickFunction = {
                it.stopPropagation()
            }

            props.children()
        }
    }

}
