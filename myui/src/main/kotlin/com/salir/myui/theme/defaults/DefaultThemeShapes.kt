package com.salir.myui.theme.defaults

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.shapes.ThemeShapes

internal val defaultThemeShapes = ThemeShapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp),
    absolute = CircleShape
)