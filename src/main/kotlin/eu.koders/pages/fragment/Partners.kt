package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.components.Section
import eu.koders.data.Sponsor
import eu.koders.utils.flexRow
import eu.koders.utils.landscapeMobile
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.ButtonType
import react.RProps
import react.child
import react.dom.br
import react.functionalComponent
import styled.*

val Partners = functionalComponent<RProps> {
    styledP {
        css {
            +koders.chapo
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            margin(LinearDimension.auto, 4.rem)

            "a" {
                color = Color.koders.krouille
                borderBottom(0.05.rem, BorderStyle.solid, Color.koders.krouille)
            }
        }

        +"This community event would not exist without our amazing partners!"
    }

    Sponsor.Type.values().forEach { type ->
        flexRow(justifyContent = JustifyContent.center) {
            css {
                flexWrap = FlexWrap.wrap
                maxWidth = 68.rem
                gap = 2.rem
                flexWrap = FlexWrap.wrap
                margin(LinearDimension.auto)
            }
            Sponsor.all.filter { it.data.type == type }.forEach { sponsor ->
                styledA(href = sponsor.data.url, target = "_blank") {
                    css {
                        display = Display.flex
                        flexDirection = FlexDirection.row
                        alignItems = Align.center
                        width = 15.rem
                        height = 4.2.rem
                        margin(1.rem)
                    }
                    styledImg(src = "/imgs/sponsors/${sponsor.id}.png", alt = sponsor.data.name) {
                        css {
                            maxWidth = 100.pct
                            maxHeight = 100.pct
                        }
                    }
                }
            }
        }
    }

    styledP {
        css {
            +koders.body
            color = Color.koders.orange
            specific {
                textAlign = TextAlign.center
            }
            margin(LinearDimension.auto, 4.rem)

            "a" {
                color = Color.koders.krouille
                borderBottom(0.05.rem, BorderStyle.solid, Color.koders.krouille)
            }
        }

        +"For partnership opportunities, contact us at "
        styledA(href = "mailto:contact@kotlin-koders.eu") {
            +"contact@kotlin-koders.eu"
        }
        +"."
    }
}
