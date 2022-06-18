import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DeathRecordDialogController {

    val state = MutableStateFlow(DeathRecordDialogState())

    val mvps = listOf("biba", "boba", "dva", "dolbeoba")

    fun onMvpNameEdit(textFieldValue: TextFieldValue) {
        val filteredNames = mvps.filter { it.contains(textFieldValue.text) }
        state.update {
            it.copy(
                isNameDropdownExpanded = textFieldValue.text.isNotEmpty() && filteredNames.isNotEmpty(),
                nameValue = textFieldValue,
                mvpNamesDropdownOptions = filteredNames,
            )
        }
    }

    fun onDropdownClick(textFieldValue: TextFieldValue) {
        state.update {
            it.copy(
                isNameDropdownExpanded = false,
                nameValue = textFieldValue,
            )
        }
    }

    fun onDismissNameDropdown() {
        state.update {
            it.copy(isNameDropdownExpanded = false, mvpNamesDropdownOptions = emptyList())
        }
    }

}
