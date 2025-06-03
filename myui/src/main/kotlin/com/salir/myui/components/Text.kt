package com.salir.myui.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.salir.myui.theme.colors.LocalContentColor
import com.salir.myui.theme.typo.LocalTextStyle
import kotlin.math.min

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current,
    textStyle: TextStyle = LocalTextStyle.current,
    minLines: Int = 1,
    maxLines: Int = Int.MAX_VALUE
) {
    BasicText(
        modifier = modifier,
        minLines = minLines,
        maxLines = maxLines,
        text = text,
        style = textStyle,
        color = { color }
    )
}