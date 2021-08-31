package eu.koders.components

import eu.koders.charter.KodersColors
import eu.koders.utils.flexColumn
import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onScrollFunction
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledSpan


external interface OverlayProps : RProps {
    var onClose: () -> Unit
    var key: String
}

val Popup = functionalComponent<OverlayProps> { props ->

    styledDiv {
        key = props.key

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
            props.onClose()
        }

        styledDiv {
            css {
                width = 95.vw
                maxWidth = 50.rem
                height = 95.vh
                maxHeight = 60.rem
                backgroundColor = KodersColors.cute
                overflow = Overflow.hidden
                borderRadius = 0.2.rem
                boxShadow(Color.black, 0.rem, 0.2.rem, 1.rem)
                position = Position.relative

                "ul" {
                    put("list-style-position", "inside")
                }
            }

            styledSpan {
                css {
                    display = Display.block
                    position = Position.absolute
                    top = 0.8.rem
                    right = 0.8.rem
                    padding(0.2.rem, 0.5.rem)
                    fontSize = 1.5.rem
                    fontWeight = FontWeight.w900
                    color = KodersColors.kaumon
                    cursor = Cursor.pointer
                }
                attrs.onClickFunction = {
                    props.onClose()
                }
                +"X"
            }

            attrs.onClickFunction = {
                it.stopPropagation()
            }

            flexColumn {
                css {
                    width = 100.pct - 4.rem
                    height = 100.pct - 4.rem
                    overflowX = Overflow.hidden
                    overflowY = Overflow.auto
                    padding(2.rem)
                    gap = 2.rem
                }
                attrs.onScrollFunction = {
                    it.stopPropagation()
                }
                props.children()
            }
        }
    }

}
