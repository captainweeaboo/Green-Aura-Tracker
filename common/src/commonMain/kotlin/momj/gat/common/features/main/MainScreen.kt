package momj.gat.common.features.main

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import momj.gat.common.features.main.controller.MainScreenController
import momj.gat.common.features.main.controller.events.MainScreenEvents
import momj.gat.common.coroutines.ControllerCoroutineScope
import momj.gat.common.features.deathrecord.DeathRecordDialog

@Composable
fun MainScreen(
    openAddDeathRecord: (String?) -> Unit,
) {
    val scope = remember { ControllerCoroutineScope() }
    val controller = remember { MainScreenController(scope) }
    val state = controller.state.collectAsState().value
    Row {
        MvpTable(
            modifier = Modifier.weight(0.45f),
            "MVPs I track",
            state.trackedMvps,
            onItemSelect = controller::onItemSelect,
            selectedItemId = state.selectedMvpId,
            onEditClick = controller::onPreselectedEditClick,
        )
        ControlPanel(
            onEditClick = controller::onEditClick,
            onAddItemClick = controller::onAddToTrackClick,
            onRemoveItemClick = controller::onRemoveFromTrackClick,
        )
        MvpTable(
            modifier = Modifier.weight(0.45f),
            "All MVPs",
            state.ignoredMvps,
            onItemSelect = controller::onItemSelect,
            selectedItemId = state.selectedMvpId,
            onEditClick = controller::onPreselectedEditClick,
        )
    }

    LaunchedEffect(Unit) {
        controller.events.collect {
            when (it) {
                is MainScreenEvents.OpenAddDeathRecord -> openAddDeathRecord(it.preselectedMvpId)
            }
        }
    }

}


