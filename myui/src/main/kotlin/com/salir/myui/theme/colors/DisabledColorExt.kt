package com.salir.myui.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.salir.myui.theme.Theme


val Color.disabled
    @Composable get() = copy(alpha = Theme.colors.disabledAlpha)