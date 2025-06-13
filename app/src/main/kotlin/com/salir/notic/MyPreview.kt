package com.salir.notic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.components.Button
import com.salir.myui.components.CheckBox
import com.salir.myui.components.Switch
import com.salir.myui.components.Text
import com.salir.myui.components.TextField
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme

@Composable
fun MyPreview() {
    val focusManager = LocalFocusManager.current

    var name by remember { mutableStateOf("") }
    var applyedName by remember { mutableStateOf("") }
    var isActiveSwitch by remember { mutableStateOf(false) }
    var isActiveCheckBox by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your name: $applyedName",
            textStyle = Theme.typo.title
        )

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    applyedName = name
                }
            ) {
                Text(
                    text = "Apply name"
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    focusManager.clearFocus()
                }
            ) {
                Text(
                    text = "Clear focus"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                isActive = isActiveSwitch
            ) {
                isActiveSwitch = it
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Switch that does nothing🌈",
                textStyle = Theme.typo.title
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckBox(
                isActive = isActiveCheckBox
            ) {
                isActiveCheckBox = it
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "CheckBox that does nothing🌈",
                textStyle = Theme.typo.title
            )
        }
    }
}


@Preview
@Composable
private fun MyPreviewPreview() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            MyPreview()
        }
    }
}