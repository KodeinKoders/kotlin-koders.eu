package eu.koders.pages

import eu.koders.RouteProps
import eu.koders.components.Popup
import eu.koders.components.Section
import eu.koders.pages.fragment.*
import eu.koders.utils.maxWidth
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.css.ruleSet
import react.child
import react.dom.h2
import react.functionalComponent
import react.router.dom.useHistory

val Page = functionalComponent<RouteProps> { props ->
    val history = useHistory()

    child(Header)

    child(Section) {
        attrs.title = "Conferences"
        attrs.index = 1

        child(Conferences)
    }

    child(Section) {
        attrs.title = "Workshops"
        attrs.index = 2

        child(Workshops)
    }

    child(Section) {
        attrs.title = "Sponsors"
        attrs.index = 3

        child(Partners)
    }

    child(Section) {
        attrs.title = "Venue"
        attrs.index = 4
        attrs.css = ruleSet {
            maxWidth(980) {
                height = LinearDimension.auto
            }
        }

        child(Venue)
    }

    child(Section) {
        attrs.title = "Prices"
        attrs.index = 5

        child(Prices)
    }

    child(Footer)

    val section = props.section
    val id = props.id
    if (section != null && id != null) {
        child(Popup) {
            attrs {
                onClose = {
                    history.push("/")
                }
                key = "${props.section}/${props.id}"
            }
            when (section) {
                "speaker" -> {
                    if (id == "next") {
                        child(NextInfo)
                    } else {
                        child(SpeakerInfo) {
                            attrs.id = id
                        }
                    }
                }
                "talk", "workshop" -> {
                    child(SessionInfo) {
                        attrs.type = section
                        attrs.id = id
                    }
                }
                "else" -> {
                    h2 { +"Unknown $section!" }
                }
            }
        }
    }
}
