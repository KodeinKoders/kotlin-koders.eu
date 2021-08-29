package eu.koders.data


data class Sponsor(
    val name: String,
    val url: String,
    val type: Sponsor.Type
) {
    enum class Type { PLATINUM, GOLD, SILVER }
    companion object : DataHolder<Sponsor>() {
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
