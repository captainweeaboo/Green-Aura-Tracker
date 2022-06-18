package momj.gat.common.features.main.viewstates

import androidx.compose.runtime.Immutable

@Immutable
data class MainScreenState(
    val trackedMvps: List<MvpItemState> = emptyList(),
    val ignoredMvps: List<MvpItemState> = emptyList(),
    val selectedMvpId: String? = null,
)
