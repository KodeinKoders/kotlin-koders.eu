package eu.koders.pages

import eu.koders.components.Section
import eu.koders.pages.fragment.*
import org.w3c.dom.HTMLElement
import react.RProps
import react.child
import react.functionalComponent
import react.useRef

val Page = functionalComponent<RProps>() {
    val div = useRef<HTMLElement>()

    child(Header)

    child(Section) {
        attrs.title = "Conferences"
        attrs.index = 1
        attrs.ratio = 1.0

        child(Conferences)
    }

    child(Section) {
        attrs.title = "Partners"
        attrs.index = 2
        attrs.ratio = 0.5

        child(Partners)
    }

    child(Section) {
        attrs.title = "Volunteers"
        attrs.index = 3
        attrs.ratio = 0.5

        child(Volunteers)
    }

    child(Section) {
        attrs.title = "Venue"
        attrs.index = 4

        child(Venue)
    }

    child(Footer)
}
