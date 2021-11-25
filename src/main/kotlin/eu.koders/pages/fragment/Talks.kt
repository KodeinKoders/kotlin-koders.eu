package eu.koders.pages.fragment

import eu.koders.charter.koders
import eu.koders.data.*
import eu.koders.data.Session.Talk.*
import eu.koders.utils.flexColumn
import eu.koders.utils.maxWidth
import kotlinx.css.*
import react.*
import styled.*

val ScheduleHours = functionalComponent<RProps> {
    val timeRanges by useState(listOf(
        "09:00", "09:20", "10:20", "11:20", "12:20",
        "13:20", "14:20", "15:20", "16:20", "17:20",
    ))

    flexColumn {
        css {
            marginTop = 3.rem
            padding(horizontal = 0.5.rem)
            maxWidth(780) {
                width = 15.pct
            }
        }

        timeRanges.forEachIndexed { index, startTime ->

            flexColumn(alignItems = Align.flexEnd) {
                css {
                    height = when (index) {
                        0 -> 6.rem
                        else -> 12.rem
                    }
                }

                styledSpan {
                    css {
                        display = Display.block
                        height = 0.1.rem
                        width = 100.pct
                        opacity = .7
                        backgroundColor = Color.koders.orange
                        marginBottom = 0.5.rem
                        margin(horizontal = LinearDimension.auto)
                    }
                }

                styledP {
                    css {
                        width = 5.rem
                        +koders.intertitre
                        color = Color.koders.orange
                        specific {
                            textAlign = TextAlign.right
                        }
                    }

                    +startTime
                }
            }
        }
    }
}

val Auditorium = functionalComponent<RProps> {
    val auditoriumSessions by useState(Schedule.auditorium.data.sessions.map { it.talk })

    flexColumn {
        css {
            width = 40.pct
            maxWidth(780) {
                width = 70.pct
            }
            padding(horizontal = 1.rem)
        }

        styledP {
            css {
                +koders.display1
                color = Color.koders.kinzolin
                height = 3.rem
                margin(horizontal = LinearDimension.auto)
            }

            styledSpan {
                css {
                    maxWidth(780) {
                        display = Display.none
                    }
                }
                +"Auditorium"
            }
        }

        auditoriumSessions.forEach {
            child(TalkCell) {
                attrs.talk = it
            }
        }
    }
}

val Loft = functionalComponent<RProps> {
    val loftSessions by useState(Schedule.loft.data.sessions.map { it.talk })

    flexColumn {
        css {
            width = 40.pct
            maxWidth(780) {
                width = 70.pct
            }
            padding(horizontal = 1.rem)
        }

        styledP {
            css {
                +koders.display1
                color = Color.koders.kinzolin
                height = 3.rem
                margin(horizontal = LinearDimension.auto)
            }

            styledSpan {
                css {
                    maxWidth(780) {
                        display = Display.none
                    }
                }
                +"Loft"
            }
        }

        flexColumn {
            css {
                height = 6.rem
                backgroundColor = Color.koders.klycine.withAlpha(0.2)
            }

            styledSpan {
                css {
                    display = Display.block
                    height = 0.1.rem
                    width = 100.pct
                    opacity = .7
                    backgroundColor = Color.koders.orange
                    marginBottom = 0.5.rem
                    margin(horizontal = LinearDimension.auto)
                }
            }
        }

        loftSessions.forEach {
            child(TalkCell) {
                attrs.talk = it
            }
        }

    }
}

external interface TalkProps : StyledProps {
    var talk: Data<Session.Talk>
}

val TalkCell = functionalComponent<TalkProps> { props ->
    val (talk, speakers, _, duration) = props.talk.data

    flexColumn {
        css {
            height = when (duration.name) {
                SessionDuration.SHORT.name -> 6.rem
                else -> 12.rem
            }

            if (talk.equals("break", ignoreCase = true)) {
                backgroundColor = Color.koders.klycine.withAlpha(0.2)
            }
        }

        styledSpan {
            css {
                display = Display.block
                height = 0.1.rem
                width = 100.pct
                opacity = .7
                backgroundColor = Color.koders.orange
                marginBottom = 0.5.rem
                margin(horizontal = LinearDimension.auto)
            }
        }


        if (talk.equals("break", ignoreCase = true) ||
            talk.equals("opening", ignoreCase = true)) {
            displayTalk(talk, speakers, duration)
        } else {
            styledA(href = "#/talk/${props.talk.id}") {
                displayTalk(talk, speakers, duration)
            }
        }
    }
}

fun RBuilder.displayTalk(talk: String, speakers: List<Data<Speaker>>, duration: SessionDuration) {
    styledP {
        css {
            +koders.intertitre
            color = Color.koders.orange
        }

        +talk

        if (speakers.isEmpty()) {
            styledSpan {
                css {
                    +koders.body
                    color = Color.koders.krouille
                }

                when {
                    talk.equals("opening", ignoreCase = true) -> +" - 15 min"
                    else -> when (duration.name) {
                        SessionDuration.LONG.name -> +" - 60 min"
                        SessionDuration.SHORT.name -> +" - 30 min"
                    }
                }
            }
        }
    }

    if (speakers.isNotEmpty()) {
        styledP {
            css {
                +koders.body
                color = Color.koders.krouille
            }

            speakers.forEachIndexed { index, speaker ->
                +speaker.data.name
                +if (speakers.lastIndex != index) {
                    ", "
                } else {
                    " - "
                }
            }

            when (duration.name) {
                SessionDuration.LONG.name -> +"45 min"
                SessionDuration.SHORT.name -> +"20 min"
            }
        }
    }
}