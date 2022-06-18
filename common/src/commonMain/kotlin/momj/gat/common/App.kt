package momj.gat.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import momj.gat.common.features.main.controller.events.MainScreenEvents
import momj.gat.common.features.main.MainScreen

@Composable
fun GreenAuraTrackerMainWindow(
    openAddDeathRecord: (String?) -> Unit,
) {
    MaterialTheme {
        MainScreen(openAddDeathRecord)
    }
}
