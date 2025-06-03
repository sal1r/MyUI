package com.salir.notic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.components.Button
import com.salir.myui.components.Text
import com.salir.myui.components.TextField
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme

@Composable
fun MyPreview() {
    var name by remember { mutableStateOf("") }
    var applyedName by remember { mutableStateOf("") }

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

        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.6f),
            onClick = {
                applyedName = name
            }
        ) {
            Text(
                text = "Apply name"
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