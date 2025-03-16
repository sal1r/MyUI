package com.salir.myui.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.salir.myui.theme.colors.LocalContentColor
import com.salir.myui.theme.typo.LocalTextStyle

@Composable
fun Text(
    text: String,
    color: Color = LocalContentColor.current,
    textStyle: TextStyle = LocalTextStyle.current
) {
    BasicText(
        text = text,
        style = textStyle,
        color = { color }
    )
}