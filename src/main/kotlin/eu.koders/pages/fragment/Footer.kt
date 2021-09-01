package eu.koders.pages.fragment

import eu.koders.charter.KodersColors
import eu.koders.charter.koders
import eu.koders.utils.flexRow
import eu.koders.utils.maxSize
import eu.koders.utils.maxWidth
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.css.properties.lh
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RProps
import react.dom.attrs
import react.dom.span
import react.functionalComponent
import styled.*

val Footer = functionalComponent<RProps> {
    flexRow {
        css {
            width = 100.pct
            backgroundColor = Color.koders.dark
            maxWidth(980) {
                flexDirection = FlexDirection.column
            }
            paddingTop = 5.rem
            marginTop = (-5).rem
        }

        flexRow(justifyContent =JustifyContent.start, alignItems = Align.center) {
            css {
                +koders.body
                color = Color.koders.orange
                specific {
                    textAlign = TextAlign.start
                }
                margin(2.rem, 1.rem)

                maxWidth(980) {
                    marginBottom = 1.rem
                    textAlign = TextAlign.center
                    justifyContent = JustifyContent.center
                }
            }

            styledP {
                css {
                    marginTop = 0.25.rem
                    marginRight = 0.5.rem
                }

                +"An event by"
            }

            styledA(href = "https://kodein.net", target = "_blank") {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    "span.underline" {
                        maxWidth(1024) { display = Display.none }
                        display = Display.block
                        width = (100.pct - 2.rem + 0.4.rem) * 0.2
                        marginRight = (100.pct - 2.rem + 0.4.rem) * 0.4
                        alignSelf = Align.flexEnd
                        opacity = 0.0
                        height = 0.05.rem
                        backgroundColor = Color.koders.orange
                        transition(::width, 0.5.s)
                        transition(::marginRight, 0.5.s)
                        transition(::opacity, 0.5.s)
                    }
                    hover {
                        "span.underline" {
                            width = 100.pct - 2.rem + 0.4.rem
                            marginRight = (-0.2).rem
                            opacity = 1.0
                        }
                    }
                    margin(LinearDimension.auto, 0.rem)
                }

                styledDiv {
                    css {
                        display = Display.flex
                        flexDirection = FlexDirection.row
                        alignItems = Align.center
                        justifyContent = JustifyContent.flexStart
                        color = Color.koders.orange
                        transition("marginRight", duration = 0.15.s)
                        zIndex = 1001
                    }
                    styledImg(src = "imgs/logo-orange-fat.svg") {
                        attrs {
                            width = "30"
                            height = "38"
                        }
                        css {
                            display = Display.block
                            padding(right = .5.em)
                            maxWidth(350) { padding(right = 0.5.em) }
                            height = 2.rem
                            width = 2.rem * 0.8
                            maxWidth(480) {
                                height = 2.rem
                                width = 2.rem * 0.8
                            }
                        }
                    }
                    styledDiv {
                        styledH1 {
                            css {
                                fontSize = 1.4.em
                                maxWidth(480) { fontSize = 1.25.em }
                                fontWeight = FontWeight.w700
                                lineHeight = 1.em.lh
                                paddingTop = 0.25.em
                                color = Color.koders.orange
                            }

                            +"KODEIN"

                            styledSpan {
                                css {
                                    opacity = 0.7
                                    fontWeight = FontWeight.w300
                                }
                                +"Koders"
                            }
                        }
                    }
                }
                span("underline") {}
            }
        }

        flexRow(JustifyContent.flexEnd, Align.center) {
            css {
                flexGrow = 1.0
                textAlign = TextAlign.end

                margin(2.rem, 1.rem)

                maxWidth(980) {
                    marginTop = 1.rem
                    textAlign = TextAlign.center
                    justifyContent = JustifyContent.center
                }
            }

            styledP {
                css {
                    +koders.body
                    color = Color.koders.orange
                }

                styledA(href = "https://twitter.com/kotlinkoders", target = "_blank") {
                    css {
                        color = KodersColors.kaumon
                        fontWeight = FontWeight.w700
                        transition(::color, 0.3.s)
                        hover {
                            color = KodersColors.klycine
                        }
                    }
                    +"@KotlinKoders"
                }
            }
        }
    }
}