import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.rememberDialogState

@Composable
fun DeathRecordDialog(
    onCloseRequest: () -> Unit,
) {

    val dialogController = remember { DeathRecordDialogController() }
    val state = dialogController.state.collectAsState().value


    Dialog(
        state = rememberDialogState(),
        onCloseRequest = onCloseRequest,
    ) {
        Column {
            DeathRecordInputField(
                label = "MVP Name",
                textValue = state.nameValue,
                controller = dialogController,
                isDropdownExpanded = state.isNameDropdownExpanded,
                mvpNames = state.mvpNamesDropdownOptions,
            )
            DateOfDeathPicker()
        }
    }
}

@Composable
private fun DateOfDeathPicker() {
}

@Composable
private fun DeathRecordInputField(
    label: String,
    textValue: TextFieldValue,
    controller: DeathRecordDialogController,
    isDropdownExpanded: Boolean,
    mvpNames: List<String>,
) {
    Row {
        Text(label)
        TextFieldWithDropdown(
            value = textValue,
            setValue = controller::onMvpNameEdit,
            onDropdownClick = controller::onDropdownClick,
            onDismissRequest = controller::onDismissNameDropdown,
            dropDownExpanded = isDropdownExpanded,
            list = mvpNames,
            label = "asdasd"
        )
    }
}

@Composable
fun TextFieldWithDropdown(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    setValue: (TextFieldValue) -> Unit,
    onDropdownClick: (TextFieldValue) -> Unit,
    onDismissRequest: () -> Unit,
    dropDownExpanded: Boolean,
    list: List<String>,
    label: String = ""
) {
    Box(modifier) {
        TextField(
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused) onDismissRequest()
                },
            value = value,
            onValueChange = setValue,
            label = { Text(label) },
            colors = TextFieldDefaults.outlinedTextFieldColors(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        )
        DropdownMenu(
            expanded = dropDownExpanded,
            onDismissRequest = onDismissRequest,
            focusable = false,
        ) {
            list.forEach { text ->
                DropdownMenuItem(modifier = Modifier.focusable(true), onClick = {
                    onDropdownClick(
                        TextFieldValue(
                            text, TextRange(text.length)
                        )
                    )
                }) {
                    Text(text = text)
                }
            }
        }
    }
}