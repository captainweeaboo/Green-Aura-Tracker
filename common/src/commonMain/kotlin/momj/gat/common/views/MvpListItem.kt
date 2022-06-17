package momj.gat.common.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import momj.gat.common.entities.MvpItemState

@Composable
fun MvpListItem(
    state: MvpItemState
) {
    Card(
        elevation = 8.dp,
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                ItemField("Name", state.name)
                ItemField("Death time", state.dateOfDeath.toString()) //todo
                ItemField("Respawn in", state.untilRebirth.toString()) //todo
                TombLocationField("Tomb location", "${state.tombLat} ${state.tombLong}", state.tombLocation)
            }
            SendTrackButton()
        }
    }
}

@Composable
private fun ItemField(label: String, value: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = label)
        Text(text = ":")
        Text(text = value)
    }
}

@Composable
private fun TombLocationField(label: String, value: String, location: String) {
    val clipboardManager = LocalClipboardManager.current
    Row(
        modifier = Modifier.clickable {
            clipboardManager.setText(AnnotatedString("@navi $location $value"))
        },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = label)
        Text(text = ":")
        Text(text = "@$location $value")
    }
}

@Composable
private fun SendTrackButton() {
    IconButton(onClick = {

    }) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = "Send MVP Tracker Data")
    }
}