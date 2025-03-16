package com.salir.myui.theme

import androidx.compose.runtime.staticCompositionLocalOf

val LocalTheme = staticCompositionLocalOf<Theme> { throw Exception("No theme provided") }