package eu.koders

import eu.koders.charter.koders
import eu.koders.pages.Page
import eu.koders.utils.maxSize
import eu.koders.utils.minSize
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.borderBottom
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.child
import react.dom.render
import styled.injectGlobal

val appGlobalStyle: CSSBuilder.() -> Unit = {
    universal {
        margin(0.px)
        padding(0.px)
    }

    html {
        maxSize(380) { fontSize = 10.px }
        maxSize(480) { fontSize = 12.px }
        maxSize(768) { fontSize = 13.px }
        maxSize(980) { fontSize = 14.px }
        maxSize(1024) { fontSize = 15.px }
        minSize(min = 1920) { fontSize = 17.px }
        minSize(min = 2500) { fontSize = 18.px }
    }

    body {
        fontFamily = "Picon, Arial, sans-serif"
    }

    a {
        textDecoration = TextDecoration.none
        color = Color.inherit
        transition(::color, 0.2.s)
    }

    "noscroll" {
        overflow = Overflow.hidden
    }

    "span.nowrap" {
        whiteSpace = WhiteSpace.nowrap
    }
}

fun main() {
    injectGlobal(appGlobalStyle)

    window.onload = {
        val element = document.getElementById("page") ?: error("Could not find page element")

        render(element) {
            child(Page)
        }
    }
}
