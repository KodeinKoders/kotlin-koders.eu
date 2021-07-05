package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinext.js.jsObject
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.events.EventListener
import react.*
import react.dom.attrs
import react.dom.br
import styled.*


external interface HeaderProps : RProps {
    var onScrollClick: () -> Unit
}

val Header = functionalComponent<HeaderProps> { props ->

    val scrollIndicatorRef = useRef<HTMLDivElement>()

    flexColumn {
        css {
            width = 100.pct
            height = 100.vh
            backgroundColor = Color.koders.kyzantium
        }

        styledDiv {
            css {
                flexGrow = 1.0
                landscapeMobile {
                    display = Display.none
                }
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

                    rangeHeight(768, 980) {
                        marginTop = 4.rem
                    }
                }

                +"2nd December - Paris, France"
            }

            // Desktop header
            styledP {
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
            styledP {
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
                height = 7.rem
                opacity = .7
                backgroundColor = Color.koders.kaumon
                margin(1.rem, LinearDimension.auto)
                portraitMobile {
                    height = 5.rem
                    margin(0.rem, LinearDimension.auto, 2.rem)

                    maxHeight(640) {
                        margin(0.rem, LinearDimension.auto)
                    }
                }
                landscapeMobile {
                    height = 3.rem
                    margin(0.rem, LinearDimension.auto, 1.rem)
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
            }

            +"A conference for all Kotlin developers."
        }

        styledA(href = "https://docs.google.com/forms/d/1Lw04egvA1srqM7BVYe37vcCRWJDMeCltCwaNomnOEAc") {
            css {
                border = "none"
                +koders.button
                margin(3.rem, LinearDimension.auto)
                landscapeMobile {
                    margin(0.5.rem, LinearDimension.auto)
                }
            }

            +"SUBMIT YOUR TALK"
        }

        styledDiv { css { flexGrow = 1.0 } }
    }

    flexRow(JustifyContent.center) {
        ref = scrollIndicatorRef
        css {
            position = Position.absolute
            width = 6.rem
            left = 50.pct - 3.rem
            bottom = 3.rem
            +koders.body
            portraitMobile {
                specific { fontSize = 0.8.rem }
                bottom = 1.rem
            }
            landscapeMobile {
                specific { fontSize = 0.8.rem }
                bottom = 1.rem
            }
            maxHeight(320) {
                marginLeft = 3.rem
            }
        }

        child(ScrollIndicator, props)
    }
}

private val ScrollIndicator = functionalComponent<HeaderProps>("ScrollIndicator") { props ->
    var isTop by useState(true)
    var isVisible by useState(false)
    val img = useRef<HTMLImageElement>()
    val isMobile = useIsMobile()

    useEffectWithCleanup(listOf(isVisible, isMobile)) {
        if (!isVisible) { return@useEffectWithCleanup ({}) }

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
        execute()

        ({ window.clearInterval(handle) })
    }

    useEffectWithCleanup(listOf(isTop)) {
        if (isTop) {
            val handle = window.setTimeout({
                isVisible = true
            }, 2000)
            return@useEffectWithCleanup ({ window.clearTimeout(handle) })
        } else {
            isVisible = false
            return@useEffectWithCleanup ({})
        }
    }

    useEffectWithCleanup(emptyList()) {
        val scroll = EventListener {
            isTop = window.scrollY < 1.0
        }
        window.addEventListener("scroll", scroll, jsObject { passive = true })
        ({ window.removeEventListener("scroll", scroll) })
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