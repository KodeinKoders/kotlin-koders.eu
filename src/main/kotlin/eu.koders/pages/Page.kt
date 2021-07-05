package eu.koders.pages

import eu.koders.pages.fragment.*
import eu.koders.utils.recursiveOffset
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import react.RProps
import react.child
import react.functionalComponent
import react.useRef

val Page = functionalComponent<RProps>() {
    val div = useRef<HTMLElement>()

    child(Header) {
        attrs.onScrollClick = { console.info("SCROLL") }
    }
    child(Partners)
    child(Conferences)
//    child(Volunteers)
    child(Footer)
}
