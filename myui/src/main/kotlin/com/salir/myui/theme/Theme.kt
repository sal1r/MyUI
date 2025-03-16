package com.salir.myui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.salir.myui.theme.colors.ThemeColors
import com.salir.myui.theme.shapes.ThemeShapes
import com.salir.myui.theme.typo.ThemeTypo

data class Theme(
    val colors: ThemeColors,
    val typo: ThemeTypo,
    val shapes: ThemeShapes
) {
    companion object {
        val colors: ThemeColors
            @ReadOnlyComposable
            @Composable
            inline get() = LocalTheme.current.colors

        val typo: ThemeTypo
            @ReadOnlyComposable
            @Composable
            inline get() = LocalTheme.current.typo

        val shapes: ThemeShapes
            @ReadOnlyComposable
            @Composable
            inline get() = LocalTheme.current.shapes
    }
}