package momj.gat.common.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import momj.gat.common.entities.MvpItemState

@Composable
fun MvpList(list: List<MvpItemState>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(count = list.size, key = { list[it] }) {
            MvpListItem(list[it])
        }
    }
}