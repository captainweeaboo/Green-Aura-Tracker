package momj.gat.common.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import momj.gat.common.features.main.viewstates.MvpItemState

@Composable
fun MvpTable(
    modifier: Modifier = Modifier,
    label: String,
    mvps: List<MvpItemState>,
    selectedItemId: String?,
    onItemSelect: (String) -> Unit,
    onEditClick: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp),
    ) {
        Text(label)
        MvpList(mvps, selectedItemId, onItemSelect, onEditClick)
    }
}