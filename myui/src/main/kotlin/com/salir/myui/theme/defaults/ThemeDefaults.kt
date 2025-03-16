package com.salir.myui.theme.defaults

import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.ThemeColors
import com.salir.myui.theme.shapes.ThemeShapes
import com.salir.myui.theme.typo.ThemeTypo

object ThemeDefaults {
    val lightColors: ThemeColors  = defaultLightThemeColors
    val darkColors: ThemeColors = defaultLightThemeColors // TODO: rewrite
    val shapes: ThemeShapes = defaultThemeShapes
    val typo: ThemeTypo = defaultThemeTypo

    val lightTheme: Theme = Theme(
        colors = lightColors,
        typo = typo,
        shapes = shapes
    )

    val darkTheme: Theme = Theme(
        colors = darkColors,
        typo = typo,
        shapes = shapes
    )
}