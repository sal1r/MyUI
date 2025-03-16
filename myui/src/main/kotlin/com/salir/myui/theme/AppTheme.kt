package com.salir.myui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.salir.myui.theme.colors.LocalContentColor
import com.salir.myui.theme.defaults.ThemeDefaults
import com.salir.myui.theme.typo.LocalTextStyle

@Composable
fun AppTheme(
    theme: Theme = ThemeDefaults.lightTheme,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTheme provides theme,
        LocalContentColor provides theme.colors.onBackground,
        LocalTextStyle provides theme.typo.body
    ) {
        content.invoke()
    }
}