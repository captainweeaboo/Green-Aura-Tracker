package momj.gat.common.features.deathrecord

import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeDialog
import androidx.compose.ui.window.Dialog

@Composable
actual fun DeathRecordDialog() {
    Dialog(visible = true, create = {
        ComposeDialog(owner = null)
    }, dispose = {
        it.dispose()
    }) {

    }
}