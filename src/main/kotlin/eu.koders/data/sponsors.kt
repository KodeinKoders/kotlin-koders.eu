package eu.koders.data


data class Sponsor(
    val name: String,
    val url: String,
    val type: Type
) {
    enum class Type { PLATINUM, GOLD, SILVER }
    companion object : DataHolder<Sponsor>() {
        val KodeinKoders by Sponsor(
            name = "KODEIN Koders",
            url = "https://kodein.net",
            type = Type.GOLD
        )
        val Instil by Sponsor(
            name = "Instil",
            url = "https://instil.co",
            type = Type.SILVER
        )
        val Data2viz by Sponsor(
            name = "Data2viz",
            url = "https://data2viz.io",
            type = Type.SILVER
        )
    }
}
