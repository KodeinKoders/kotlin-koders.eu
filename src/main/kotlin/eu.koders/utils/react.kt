package eu.koders.utils

import kotlinx.browser.window
import kotlinx.css.CSSBuilder
import kotlinx.css.Rule
import kotlinx.css.RuleSet
import org.w3c.dom.events.Event
import react.*

private const val mobileQuery = "(orientation: portrait) and (max-height: 980px), (orientation: landscape) and (max-width: 980px)"

fun useIsMobile(): Boolean {
    var isMobile: Boolean by useState {
        if (jsTypeOf(window) == "undefined") false
        else window.matchMedia(mobileQuery).matches
    }

    useEffect {
        val onResize: (Event?) -> Unit = {
            isMobile = window.matchMedia(mobileQuery).matches
        }

        window.addEventListener("resize", onResize)
        cleanup { window.removeEventListener("resize", onResize) }

        onResize(null)
    }

    return isMobile
}

typealias PRuleSet = (CSSBuilder) -> Unit
