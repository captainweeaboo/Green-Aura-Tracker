package momj.gat.common.features.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import momj.gat.common.features.main.viewstates.MvpItemState

@Composable
fun MvpList(
    list: List<MvpItemState>,
    selectedItemId: String?,
    onItemSelect: (String) -> Unit,
    onEditClick: (String) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(count = list.size, key = { list[it].id }) {
            MvpListItem(list[it], selectedItemId, onItemSelect, onEditClick)
        }
    }
}