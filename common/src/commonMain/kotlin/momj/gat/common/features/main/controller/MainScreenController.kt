package momj.gat.common.features.main.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import momj.gat.common.features.main.controller.events.MainScreenEvents
import momj.gat.common.features.main.viewstates.MainScreenState
import momj.gat.common.features.main.viewstates.MvpItemState

class MainScreenController(controllerScope: CoroutineScope) : CoroutineScope by controllerScope {

    val state = MutableStateFlow(MainScreenState())
    val events = MutableSharedFlow<MainScreenEvents>()

    init {
        launch {
            state.emit(
                MainScreenState(
                    ignoredMvps = listOf(
                        MvpItemState(
                            id = "1",
                            name = "biba",
                            dateOfDeath = 1,
                            untilRebirth = 1,
                            tombLat = 152,
                            tombLong = 234,
                            tombLocation = "prontera",
                        ),
                        MvpItemState(
                            id = "2",
                            name = "boba",
                            dateOfDeath = 1,
                            untilRebirth = 1,
                            tombLat = 152,
                            tombLong = 234,
                            tombLocation = "prontera",
                        ),
                        MvpItemState(
                            id = "3",
                            name = "baba",
                            dateOfDeath = 1,
                            untilRebirth = 1,
                            tombLat = 152,
                            tombLong = 234,
                            tombLocation = "prontera",
                        ),
                    )
                )
            )
        }
    }

    fun onEditClick() {
        onEdit()
    }

    fun onPreselectedEditClick(preselectedItemId: String) {
        onEdit(preselectedItemId)
    }

    private fun onEdit(itemId: String? = null) {
        launch {
            events.emit(MainScreenEvents.OpenAddDeathRecord(itemId))
        }
    }

    private fun onActionClick(
        actionOnTrackedList: List<MvpItemState>.(MvpItemState) -> List<MvpItemState>,
        actionOnIgnoredList: List<MvpItemState>.(MvpItemState) -> List<MvpItemState>,
        checkItemIn: List<MvpItemState>,
    ) {
        state.value.let { state ->
            checkItemIn.find { it.id == state.selectedMvpId }?.let { item ->
                state.toggleMvpTrackingIfPossible(
                    actionOnTrackedList = {
                        this.actionOnTrackedList(it)
                    },
                    actionOnIgnoredList = {
                        this.actionOnIgnoredList(it)
                    },
                    item = item
                )
            }
        }
    }

    fun onAddToTrackClick() {
        onActionClick(
            checkItemIn = state.value.ignoredMvps,
            actionOnTrackedList = {
                this.addToList(it)
            },
            actionOnIgnoredList = {
                this.removeFromList(it)
            },
        )
    }

    fun onRemoveFromTrackClick() {
        onActionClick(
            checkItemIn = state.value.trackedMvps,
            actionOnTrackedList = {
                this.removeFromList(it)
            },
            actionOnIgnoredList = {
                this.addToList(it)
            },
        )
    }

    private fun MainScreenState.toggleMvpTrackingIfPossible(
        actionOnTrackedList: List<MvpItemState>.(MvpItemState) -> List<MvpItemState>,
        actionOnIgnoredList: List<MvpItemState>.(MvpItemState) -> List<MvpItemState>,
        item: MvpItemState,
    ) {
        state.update {
            it.copy(
                trackedMvps = trackedMvps.actionOnTrackedList(item),
                ignoredMvps = ignoredMvps.actionOnIgnoredList(item),
                selectedMvpId = null,
            )
        }
    }

    private fun List<MvpItemState>.addToList(item: MvpItemState) = this.plus(item.copy())

    private fun List<MvpItemState>.removeFromList(item: MvpItemState) = this.minus(item)

    fun onItemSelect(id: String) {
        state.update {
            it.copy(
                selectedMvpId = if (it.selectedMvpId == id) {
                    null
                } else {
                    id
                }
            )
        }
    }
}
