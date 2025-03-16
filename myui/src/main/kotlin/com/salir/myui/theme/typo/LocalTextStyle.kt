package com.salir.myui.theme.typo

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle

val LocalTextStyle = compositionLocalOf<TextStyle> { throw Exception("No text style provided") }