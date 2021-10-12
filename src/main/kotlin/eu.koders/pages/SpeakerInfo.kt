package eu.koders.pages

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.data.Speaker
import eu.koders.data.sessions
import eu.koders.utils.flexRow
import eu.koders.utils.light
import eu.koders.utils.portraitMobile
import eu.koders.utils.ultraLight
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RProps
import react.dom.br
import react.dom.h2
import react.functionalComponent
import styled.*


external interface SpeakerInfoProps : RProps {
    var id: String
}

val SpeakerInfo = functionalComponent<SpeakerInfoProps> { props ->
    val speaker = Speaker[props.id]
    if (speaker == null) {
        h2 { +"Unknown speaker!" }
        return@functionalComponent
    }
    flexRow(alignItems = Align.center) {
        css {
            portraitMobile {
                flexDirection = FlexDirection.column
                gap = 1.rem
            }
        }
        styledImg(src = "/imgs/speakers/${props.id}.jpeg") {
            css {
                width = 12.rem
                height = 12.rem
                zIndex = 1
                marginRight = 1.5.rem
                borderRadius = 0.5.rem
            }
        }
        styledH2 {
            css {
                fontFamily = koders.piconExtended
                fontWeight = FontWeight.w900
                fontSize = 2.5.rem
                portraitMobile {
                    fontSize = 1.6.rem
                    textAlign = TextAlign.center
                }
                color = Color.koders.krouille
            }
            speaker.data.name.uppercase().split(" ").forEach {
                +it
                br {}
            }
            styledP {
                css {
                    fontWeight = FontWeight.light
                    fontSize = 2.rem
                    portraitMobile {
                        fontSize = 1.3.rem
                    }
                }
                +speaker.data.company
                br {}

                if (speaker.data.twitter.isNotEmpty()) {
                    styledA("https://twitter.com/${speaker.data.twitter}") {
                        css {
                            fontWeight = FontWeight.ultraLight
                            fontSize = 1.5.rem
                            portraitMobile {
                                fontSize = 1.2.rem
                            }
                        }
                        +"@"
                        +speaker.data.twitter
                    }
                }
            }
        }

    }

    styledP {
        css {
            +koders.body
            color = KodersColors.dark
            textAlign = TextAlign.justify
        }
        +speaker.data.bio
    }

    speaker.sessions().forEach { session ->
        styledDiv {
            styledA(href = "#/${session.data::class.simpleName?.lowercase()}/${session.id}") {
                css {
                    fontWeight = FontWeight.w900
                    fontSize = 1.8.rem
                    portraitMobile {
                        fontSize = 1.2.rem
                    }
                    color = Color.koders.krouille
                    transition(::color, 0.3.s)
                    hover {
                        color = KodersColors.kamethiste
                    }
                }
                +session.data.title.uppercase()
            }
        }
    }
}
