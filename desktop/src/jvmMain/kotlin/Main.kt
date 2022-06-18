// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.*
import momj.gat.common.GreenAuraTrackerMainWindow
import javax.swing.KeyStroke


@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {

    val mainController = remember { MainController() }

    val state = mainController.state.collectAsState().value

    val windowState = rememberWindowState()

    if (!windowState.isMinimized) {
        Window(
            onCloseRequest = ::exitApplication,
            title = "GreenAuraText",
            state = windowState,
        ) {
            GreenAuraTrackerMainWindow(openAddDeathRecord = {
                mainController.onOpenDeathRecordRequested(it)
            })
        }
    }

    Tray(
        icon = rememberVectorPainter(Icons.Default.AccountBox),
        onAction = {
            windowState.isMinimized = false
        },
        menu = {
            Item("Exit", onClick = ::exitApplication)
        },
    )

    if (state.isDeathRecordVisible) {
        DeathRecordDialog {
            mainController.onDeathRecordCloseRequested()
        }
    }
}
