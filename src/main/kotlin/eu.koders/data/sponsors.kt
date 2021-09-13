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
            type = Type.GOLD
        )
        val Bam by Sponsor(
            name = "BAM",
            url = "https://www.bam.tech/",
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
        val KodeinKoders by Sponsor(
            name = "KODEIN Koders",
            url = "https://kodein.net",
            type = Type.GOLD
        )
    }
}