package momj.gat.common.features.main.viewstates

import androidx.compose.runtime.Immutable

@Immutable
data class MvpItemState(
    val id: String,
    val name: String,
    val dateOfDeath: Long,
    val untilRebirth: Long,
    val tombLat: Int,
    val tombLong: Int,
    val tombLocation: String,
)
