package momj.gat.common.features.main

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
import momj.gat.common.features.main.viewstates.MvpItemState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MvpListItem(
    state: MvpItemState,
    selectedItemId: String?,
    onItemSelect: (String) -> Unit,
    onEditClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 2.dp,
        backgroundColor = if (selectedItemId == state.id) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.surface
        },
        onClick = {
            onItemSelect(state.id)
        },
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                ItemField("Name", state.name)
                ItemField("Death time", state.dateOfDeath.toString()) //todo
                ItemField("Respawn in", state.untilRebirth.toString()) //todo
                TombLocationField("Tomb location", "${state.tombLat} ${state.tombLong}", state.tombLocation)
            }
            SendTrackButton(onEditClick, state.id)
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
private fun SendTrackButton(
    onEditClick: (String) -> Unit,
    itemId: String,
) {
    IconButton(onClick = {
        onEditClick(itemId)
    }) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = "Send MVP Tracker Data")
    }
}