package momj.gat.common.features.main.controller.events

sealed interface MainScreenEvents {
    data class OpenAddDeathRecord(
        val preselectedMvpId: String? = null,
    ) : MainScreenEvents
}
