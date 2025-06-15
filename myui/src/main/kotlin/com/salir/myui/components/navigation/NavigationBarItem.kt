package com.salir.myui.components.navigation

import androidx.compose.ui.graphics.painter.Painter

class NavigationBarItem<T>(
    val destination: T,
    val label: String,
    val icon: Painter
)