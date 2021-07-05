package eu.koders.utils

import kotlinx.browser.window
import org.w3c.dom.events.Event
import react.*

private const val mobileQuery = "(orientation: portrait) and (max-height: 980px), (orientation: landscape) and (max-width: 980px)"

fun useIsMobile(): Boolean {
    var isMobile: Boolean by useState {
        if (jsTypeOf(window) == "undefined") false
        else window.matchMedia(mobileQuery).matches
    }

    useEffectWithCleanup(emptyList()) {
        val onResize: (Event?) -> Unit = {
            isMobile = window.matchMedia(mobileQuery).matches
        }
        window.addEventListener("resize", onResize)
        onResize(null)
        ({ window.removeEventListener("resize", onResize) })
    }

    return isMobile
}