package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import react.dom.attrs
import react.dom.br
import styled.*
import kotlin.math.roundToInt

val Venue = functionalComponent<RProps> {
    flexRow {
        css {
            maxWidth(980) {
                flexDirection = FlexDirection.column
            }
        }

        child(Photos)

        styledSpan {
            css {
                display = Display.block
                width = 0.05.rem
                opacity = .7
                backgroundColor = Color.koders.kuivre
                margin(1.rem, LinearDimension.auto)
                maxWidth(980) {
                    display = Display.none
                }
            }
        }

        child(Map)
    }
}

private val Photos = functionalComponent<RProps> {
    flexColumn(justifyContent = JustifyContent.center, alignItems = Align.center) {
        css {
            width = 50.vw
            maxWidth(980) {
                width = 100.vw
            }
        }

        styledDiv {
            css {
                margin(LinearDimension.auto)
                padding(3.rem)
                maxWidth(980) {
                    padding(1.rem)
                }
            }

            styledImg(src = "imgs/pan_piper_auditorium.jpg") {
                css {
                    width = 100.pct
                    objectFit = ObjectFit.cover
                    clipPath = "polygon(0% 0%, calc(100% - ${3.rem}) 0%, 100% calc(0% + ${3.rem}), 100% 100%, calc(0% + ${3.rem}) 100%, 0% calc(100% - ${3.rem}))"
                }
            }
        }
    }
}

private val Map = functionalComponent<RProps> {
    val mapViewport = useRef<HTMLDivElement>(null)
    var mapWidth by useState(0)

    useEffectWithCleanup {
        val onResize: (Event?) -> Unit = {
            mapWidth = when (val viewport = mapViewport.current) {
                null -> 0
                else -> (viewport.clientWidth * 0.9).roundToInt()
            }
        }
        window.addEventListener("resize", onResize)
        onResize(null)
        ({ window.removeEventListener("resize", onResize) })
    }

    flexColumn(justifyContent = JustifyContent.center, alignItems = Align.center) {
        ref = mapViewport

        css {
            width = 50.vw

            maxWidth(980) {
                width = 100.vw
            }
        }

        flexColumn {
            css {
                flexGrow = 1.0
                margin(1.rem, LinearDimension.auto)
            }

            styledP {
                css {
                    +koders.display2
                    color = Color.koders.orange
                }
                +"Pan Piper"
            }

            styledP {
                css {
                    +koders.display1
                    color = Color.koders.kuivre
                }
                +"2-4, impasse Lamier"
                br {}
                +"75011 Paris, FRANCE"
            }
        }

        styledDiv {
            css {
                flexGrow = 1.0
                margin(1.rem, LinearDimension.auto)
            }

            consumer.onTagContentUnsafe {
                +"""<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5616.030283547232!2d2.385070059700082!3d48.85777310035053!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66df52812a533%3A0xb66d316ef4c2d84a!2sPan%20Piper!5e0!3m2!1sfr!2sfr!4v1625654807124!5m2!1sfr!2sfr" width="$mapWidth" height="${mapWidth / 2}" style="border:0;" allowfullscreen="" loading="lazy"></iframe>"""
            }
        }
    }

}