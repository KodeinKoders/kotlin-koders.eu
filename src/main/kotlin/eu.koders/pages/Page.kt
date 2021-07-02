package eu.koders.pages

import eu.koders.pages.fragment.*
import react.RProps
import react.child
import react.functionalComponent

val Page = functionalComponent<RProps>() {
    child(Header)
    child(Partners)
    child(Conferences)
//    child(Volunteers)
    child(Footer)
}
