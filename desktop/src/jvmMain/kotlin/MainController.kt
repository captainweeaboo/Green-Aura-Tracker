import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainController {
    val state = MutableStateFlow(MainState())

    fun onOpenDeathRecordRequested(mvpId: String?) {
        state.update {
            it.copy(
                isDeathRecordVisible = true,
                currentSelectedMvpId = mvpId,
            )
        }
    }

    fun onDeathRecordCloseRequested() {
        state.update {
            it.copy(
                isDeathRecordVisible = false,
                currentSelectedMvpId = null,
            )
        }
    }
}
