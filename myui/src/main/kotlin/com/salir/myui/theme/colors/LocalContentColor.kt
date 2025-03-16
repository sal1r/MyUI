package com.salir.myui.theme.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalContentColor = staticCompositionLocalOf<Color> { throw Exception("No content color provided") }