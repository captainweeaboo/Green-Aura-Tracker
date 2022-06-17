package momj.gat.common.views

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import momj.gat.common.entities.MvpItemState

@Composable
fun MainScreen() {
    val mvps1 = listOf(
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
        )
    )

    val mvps2 = listOf(
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
        )
    )
    Row {
        MvpTable("MVPs I track", mvps1)
        ControlPanel({}, {}, {})
        MvpTable("All MVPs", mvps2)
    }
}


