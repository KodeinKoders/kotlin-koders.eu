package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.utils.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import org.w3c.dom.events.Event
import react.*
import react.dom.attrs
import react.dom.br
import styled.css
import styled.styledDiv
import styled.styledImg
import styled.styledP

val Venue = functionalComponent<RProps> {

    var mapWidth by useState(0)
    var mapHeight by useState(0)

    useEffectWithCleanup {
        val onResize: (Event?) -> Unit = {
            document.body?.clientWidth?.let { clientWidth ->
                mapWidth = when {
                    clientWidth > 1024 -> 1024
                    clientWidth > 900 -> 900
                    else -> clientWidth
                }
                mapHeight = when {
                    clientWidth > 1024 -> 350
                    clientWidth > 900 -> 300
                    else -> 200
                }
            }
        }
        window.addEventListener("resize", onResize)
        onResize(null)
        ({ window.removeEventListener("resize", onResize) })
    }

    styledDiv {
        css {
            flexGrow = 1.0
            margin(LinearDimension.auto)
        }

        styledImg(src = "imgs/pan_piper_auditorium.jpg") {
            css {
                width = 100.pct
                objectFit = ObjectFit.cover
                minWidth(980) {
                    width = LinearDimension.auto
                }
            }
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
            +"""<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5616.030283547232!2d2.385070059700082!3d48.85777310035053!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66df52812a533%3A0xb66d316ef4c2d84a!2sPan%20Piper!5e0!3m2!1sfr!2sfr!4v1625654807124!5m2!1sfr!2sfr" width="$mapWidth" height="$mapHeight" style="border:0;" allowfullscreen="" loading="lazy"></iframe>"""
        }
    }
}
