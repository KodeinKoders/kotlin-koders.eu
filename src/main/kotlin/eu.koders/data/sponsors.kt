package eu.koders.data


data class Sponsor(
    val name: String,
    val url: String,
    val type: Type
) {
    enum class Type { PLATINUM, GOLD, SILVER }
    companion object : DataHolder<Sponsor>() {
        val Acinq by Sponsor(
            name = "Acinq",
            url = "https://acinq.co",
            type = Type.PLATINUM
        )
        val Bam by Sponsor(
            name = "BAM",
            url = "https://www.bam.tech",
            type = Type.GOLD
        )
        val KodeinKoders by Sponsor(
            name = "KODEIN Koders",
            url = "https://kodein.net",
            type = Type.GOLD
        )
        val Malt by Sponsor(
            name = "Malt",
            url = "https://www.malt.fr",
            type = Type.GOLD
        )
        val Data2viz by Sponsor(
            name = "Data2viz",
            url = "https://data2viz.io",
            type = Type.SILVER
        )
        val Instil by Sponsor(
            name = "Instil",
            url = "https://instil.co",
            type = Type.SILVER
        )
        val JetBrains by Sponsor(
            name = "JetBrains",
            url = "https://www.jetbrains.com",
            type = Type.SILVER
        )
        val Neopixl by Sponsor(
            name = "neopixl",
            url = "https://www.neopixl.com",
            type = Type.SILVER
        )
    }
}
