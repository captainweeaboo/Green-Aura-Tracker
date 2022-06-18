package momj.gat.common.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ControlPanel(
    onEditClick: () -> Unit,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit,
) {
    Column(modifier = Modifier.width(32.dp)) {
        ControlPanelButton(
            onClick = onEditClick,
            icon = Icons.Default.Edit,
            contentDescription = "Edit MVP Track"
        )
        ControlPanelButton(
            onClick = onAddItemClick,
            icon = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Add MVP I Track"
        )
        ControlPanelButton(
            onClick = onRemoveItemClick,
            icon = Icons.Default.KeyboardArrowRight,
            contentDescription = "Remove MVP I Track"
        )
    }
}

@Composable
private fun ControlPanelButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
        )
    }
}
