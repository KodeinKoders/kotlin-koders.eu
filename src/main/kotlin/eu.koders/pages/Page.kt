package eu.koders.pages

import eu.koders.components.Section
import eu.koders.pages.fragment.*
import eu.koders.utils.maxWidth
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.css.ruleSet
import kotlinx.css.vh
import org.w3c.dom.HTMLElement
import react.RProps
import react.child
import react.functionalComponent
import react.useRef

val Page = functionalComponent<RProps> {
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

    child(Footer)
}
