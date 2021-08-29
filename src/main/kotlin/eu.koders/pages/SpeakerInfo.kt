package eu.koders.pages

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.data.Speaker
import eu.koders.data.sessions
import eu.koders.utils.flexRow
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
                fontSize = 2.8.rem
                color = Color.koders.krouille
            }
            speaker.data.name.uppercase().split(" ").forEach {
                +it
                br {}
            }
        }

    }

    styledP {
        css {
            +koders.body
            color = KodersColors.dark
        }
        +speaker.data.bio
    }

    speaker.sessions().forEach { session ->
        styledDiv {
            styledA(href = "#/${session.data::class.simpleName?.lowercase()}/${session.id}") {
                css {
                    fontWeight = FontWeight.w900
                    fontSize = 1.8.rem
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
