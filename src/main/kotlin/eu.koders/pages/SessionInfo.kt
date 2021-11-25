package eu.koders.pages

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.components.Markdown
import eu.koders.data.Session
import eu.koders.pages.fragment.SpeakerLink
import eu.koders.utils.flexRow
import eu.koders.utils.portraitMobile
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import react.RProps
import react.child
import react.dom.b
import react.dom.h2
import react.dom.li
import react.dom.ul
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledP


external interface SessionInfoProps : RProps {
    var type: String
    var id: String
}

val SessionInfo = functionalComponent<SessionInfoProps> { props ->
    val sessionData = when (props.type) {
        "talk" -> Session.Talk[props.id]
        "workshop" -> Session.Workshop[props.id]
        else -> null
    }

    if (sessionData == null) {
        h2 { +"Unknown ${props.type}!" }
        return@functionalComponent
    }

    val session = sessionData.data

    styledDiv {
        styledH2 {
            css {
                fontFamily = koders.picon
                fontWeight = FontWeight.w900
                fontSize = 2.4.rem
                color = Color.koders.krouille
                portraitMobile {
                    fontSize = 1.6.rem
                }
            }
            +session.title.uppercase()
        }
        styledP {
            css {
                +koders.body
                color = Color.koders.korail
            }
            when (session) {
                is Session.Talk -> +"Thursday, December 2nd"
                is Session.Workshop -> {
                    b { +"FULL DAY WORKSHOP" }
                    +", Wednesday, December 1st"
                }
            }
        }
    }

    flexRow {
        css {
            flexWrap = FlexWrap.wrap
        }

        session.speakers
            .sortedBy { it.data.name }
            .forEach { speaker ->
                child(SpeakerLink) {
                    attrs.speaker = speaker
                }
            }
    }

    styledDiv {
        css {
            +koders.body
            color = KodersColors.dark
            textAlign = TextAlign.justify
            "p" {
                paddingBottom = 0.8.rem
            }
            "a" {
                textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
                color = Color.koders.krouille
            }
        }
        Markdown {
            +session.abstract
        }
    }

    if (session is Session.Workshop) {
        styledDiv {
            css {
                +koders.body
                color = Color.koders.dark
                "p" {
                    paddingBottom = 0.8.rem
                }
            }

            styledP {
                css {
                    color = Color.koders.korail
                    fontWeight = FontWeight.bold
                    fontFamily = koders.piconExtended
                }
                +"Requirements:"
            }
            Markdown {
                +session.requirements
            }
        }

        styledDiv {
            css {
                +koders.body
                color = Color.koders.dark
                "p" {
                    paddingBottom = 0.8.rem
                }
            }

            styledP {
                css {
                    color = Color.koders.korail
                    fontWeight = FontWeight.bold
                    fontFamily = koders.piconExtended
                }
                +"Course content:"
            }

            ul {
                session.content.forEach {
                    li { +it }
                }
            }
        }
    }

}
