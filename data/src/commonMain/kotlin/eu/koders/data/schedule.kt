package eu.koders.data

import eu.koders.data.Session.Talk

data class Schedule(
    val sessions: List<Slot>
) {

    data class Slot(
        val hour: Int,
        val minute: Int,
        val talk: Data<Talk>
    )

    companion object : DataHolder<Schedule>() {
        val auditorium by Schedule(listOf(
            Slot(9, 0, Talk.Opening),
            Slot(9, 20, Talk.KeepKotlinFun),
            Slot(10, 20, Talk.http4KLiveCoding),
            Slot(11, 20, Talk.Break),
            Slot(11, 50, Talk.KMPAtDeezer),
            Slot(12, 20, Talk.KmmGraphQL),
            Slot(13, 20, Talk.LongBreak),
            Slot(14, 20, Talk.NewInKMP),
            Slot(15, 20, Talk.ReliableWebServices),
            Slot(16, 20, Talk.Break),
            Slot(16, 50, Talk.GradleKotlinDSL),
            Slot(17, 20, Talk.BridgingKotlinAndSwift)
        ))

        val loft by Schedule(listOf(
            Slot(9, 20, Talk.KotlinAdoptionAtScale),
            Slot(10, 20, Talk.KMPLightningNode),
            Slot(10, 50, Talk.Break),
            Slot(11, 20, Talk.FunctionalInSpringBoot),
            Slot(12, 20, Talk.CICDWithKotlin),
            Slot(12, 50, Talk.QuickStartKMP),
            Slot(13, 20, Talk.LongBreak),
            Slot(14, 20, Talk.KotlinNativeFromTheTrenches),
            Slot(15, 20, Talk.AnimatingCompose),
            Slot(15, 50, Talk.Break),
            Slot(16, 20, Talk.ExploringAdvancedCompose),
            Slot(17, 20, Talk.CompilerLies)
        ))
    }
}
