package com.salir.myui.theme.defaults

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.salir.myui.theme.typo.ThemeTypo

internal val defaultThemeTypo = ThemeTypo(
    label = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.25.sp
    ),
    body = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    title = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp
    ),
    header = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.25.sp
    )
)