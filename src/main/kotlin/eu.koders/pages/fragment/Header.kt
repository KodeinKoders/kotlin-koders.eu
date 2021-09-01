package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinext.js.jsObject
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.*
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.events.EventListener
import react.*
import react.dom.attrs
import react.dom.br
import styled.*

val Header = functionalComponent<RProps> {

    val div = useRef<HTMLDivElement>()

    flexColumn {
        ref = div
        css {
            width = 100.pct
            height = 100.vh
            backgroundColor = Color.koders.kyzantium
            clipPath = "polygon(0 0, 100% 0, 100% calc(100% - 5rem), 0 100%)"
            position = Position.relative
            zIndex = 10
        }

        styledDiv {
            css {
                flexGrow = 1.0
                maxWidth(1280) {
                    display = Display.none
                }
            }
        }

        styledImg(src = "imgs/kotlin-koders-logo.svg") {
            css {
                width = 10.rem
                margin(1.5.rem, LinearDimension.auto)
            }
        }

        styledDiv {
            css {
                margin(0.rem, LinearDimension.auto)
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

                    maxHeight(800) {
                        margin(LinearDimension.auto)
                    }
                }

                +"December 1st & 2nd - Paris, France"
            }

            // Desktop header
            styledDiv {
                css {
                    +koders.display3
                    color = Color.koders.kaumon
                    specific {
                        fontWeight = FontWeight.light
                        textAlign = TextAlign.center
                    }
                    margin(1.rem, 1.rem)
                    portraitMobile {
                        display = Display.none
                    }
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

            // Mobile header
            styledDiv {
                css {
                    +koders.display3
                    color = Color.koders.kaumon
                    specific {
                        fontWeight = FontWeight.light
                        textAlign = TextAlign.left
                        lineHeight = 90.pct.lh
                    }
                    margin(3.rem, 4.rem)
                    display = Display.none
                    portraitMobile(979) {
                        display = Display.block
                    }
                }

                +"Kotlin"

                br { }
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
                br { }
                styledP {
                    css { textAlign = TextAlign.right }
                    +"2021"
                }
            }
        }

        styledSpan {
            css {
                display = Display.block
                width = 0.05.rem
                height = 5.rem
                opacity = .7
                backgroundColor = Color.koders.kaumon
                margin(1.rem, LinearDimension.auto)
                portraitMobile {
                    margin(0.rem, LinearDimension.auto, 2.rem)

                    rangeHeight(680, 740) {
                        margin(0.rem, LinearDimension.auto)
                        height = 3.rem
                    }

                    maxHeight(680) {
                        display = Display.none
                    }
                }
                landscapeMobile {
                    display = Display.none
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
                landscapeMobile {
                    margin(0.5.rem, LinearDimension.auto)
                }
                portraitMobile {
                    maxHeight(640) {
                        display = Display.none
                        margin(0.5.rem, LinearDimension.auto)
                    }
                }
            }

            +"A conference for all Kotlin developers."
        }

        styledA(
            href = "https://www.billetweb.fr/kotlin-koders-2021",
            target = "_blank"
        ) {
            css {
                border = "none"
                +koders.button
                margin(1.rem, LinearDimension.auto)
                landscapeMobile {
                    margin(0.5.rem, LinearDimension.auto)
                }
            }

            +"BUY BLIND BIRD!"
        }

        styledDiv {
            css {
                flexGrow = 2.0
                maxWidth(1280) {
                    display = Display.none
                }
            }
        }
    }

    flexRow(JustifyContent.center) {
        css {
            position = Position.absolute
            width = 6.rem
            left = 50.pct - 3.rem
            bottom = 4.rem
            +koders.body
            zIndex = 20

            portraitMobile {
                specific { fontSize = 0.8.rem }
                bottom = 3.rem
            }
            landscapeMobile {
                specific { fontSize = 0.8.rem }
                bottom = 3.rem
            }
            maxHeight(320) {
                marginLeft = 3.rem
            }
        }

        child(ScrollIndicator) {
            attrs.onScrollClick = {
                val (_, offsetTop) = div.current!!.recursiveOffset()
                val clientHeight = div.current!!.clientHeight
                window.scrollTo(ScrollToOptions(top = (offsetTop + clientHeight).toDouble(), behavior = ScrollBehavior.SMOOTH))
            }
        }
    }
}


external interface ScrollIndicatorProps : RProps {
    var onScrollClick: () -> Unit
}

private val ScrollIndicator = functionalComponent<ScrollIndicatorProps>("ScrollIndicator") { props ->
    var isTop by useState(true)
    var isVisible by useState(false)
    val img = useRef<HTMLImageElement>()
    val isMobile = useIsMobile()

    useEffect(isVisible, isMobile) {
        if (!isVisible) return@useEffect

        fun execute() {
            img.current?.style?.opacity = "1.0"
            window.setTimeout({
                img.current?.style?.paddingTop = if (isMobile) "0rem" else "1rem"
            }, 500)
            window.setTimeout({
                img.current?.style?.opacity = "0.0"
            }, 1500)
            window.setTimeout({
                img.current?.style?.paddingTop = if (isMobile) "1rem" else "0rem"
            }, 2500)
        }

        val handle = window.setInterval(::execute, 3500)
        cleanup { window.clearInterval(handle) }

        execute()
    }

    useEffect(isTop) {
        if (isTop) {
            val handle = window.setTimeout({
                isVisible = true
            }, 2000)
            cleanup { window.clearTimeout(handle) }
        } else {
            isVisible = false
        }
    }

    useEffect {
        val scroll = EventListener {
            isTop = window.scrollY < 1.0
        }
        window.addEventListener("scroll", scroll, jsObject { passive = true })
        cleanup { window.removeEventListener("scroll", scroll) }
    }

    flexColumn(JustifyContent.center, Align.center) {
        css {
            opacity = if (isVisible) 1.0 else 0.0
            transition(::opacity, .5.s)
            cursor = Cursor.pointer
        }
        attrs.onClickFunction = {
            props.onScrollClick()
        }

        styledDiv {
            css {
                height = 3.em
                marginBottom = .5.em
            }
            styledImg(src = "imgs/pointer-${if (isMobile) "hand" else "mouse"}-korail.svg",
                alt = "Scroll") {
                attrs {
                    width = "36"
                    height = "36"
                }
                ref = img
                css {
                    height = 2.em
                    paddingTop = if (isMobile) 1.rem else 0.rem
                    opacity = 1.0
                    transition(::opacity, .5.s)
                    transition(::paddingTop, 1.s)
                }
            }
        }
        styledP {
            css {
                color = Color.koders.korail
            }
            +"SCROLL"
        }
    }
}