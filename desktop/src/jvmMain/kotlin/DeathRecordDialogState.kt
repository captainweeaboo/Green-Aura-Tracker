import androidx.compose.ui.text.input.TextFieldValue

data class DeathRecordDialogState(
    val nameValue: TextFieldValue = TextFieldValue(),
    val isNameDropdownExpanded: Boolean = false,
    val mvpNamesDropdownOptions: List<String> = emptyList(),
)
