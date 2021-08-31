package eu.koders.pages

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.data.Session
import eu.koders.pages.fragment.SpeakerLink
import eu.koders.utils.flexRow
import eu.koders.utils.portraitMobile
import kotlinx.css.*
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
    val session = when (props.type) {
        "talk" -> Session.Talk[props.id]
        "workshop" -> Session.Workshop[props.id]
        else -> null
    }

    if (session == null) {
        h2 { +"Unknown ${props.type}!" }
        return@functionalComponent
    }

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
            +session.data.title.uppercase()
        }
        styledP {
            css {
                +koders.body
                color = Color.koders.korail
            }
            when (session.data) {
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

        session.data.speakers
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
            "p" {
                paddingBottom = 0.8.rem
            }
        }
        session.data.abstract(this)
    }

    if (session.data is Session.Workshop) {
        styledDiv {
            css {
                +koders.body
                color = Color.koders.dark
            }

            styledP {
                css {
                    color = Color.koders.korail
                    fontWeight = FontWeight.bold
                    fontFamily = koders.piconExtended
                }
                +"Requirements:"
            }

            session.data.requirements(this)
        }

        styledDiv {
            css {
                +koders.body
                color = Color.koders.dark
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
                session.data.content.forEach {
                    li { +it }
                }
            }
        }
    }

}
