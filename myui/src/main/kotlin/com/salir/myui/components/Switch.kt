package com.salir.myui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.disabled

@Composable
fun Switch(
    isActive: Boolean,
    onActiveChanged: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .border(width = 2.dp, color = Theme.colors.primary, shape = Theme.shapes.absolute)
            .clip(Theme.shapes.absolute)
            .background(Theme.colors.background)
            .clickable(onClick = { onActiveChanged(!isActive) }, interactionSource = remember { MutableInteractionSource() }, indication = null)
            .padding(4.dp)
            .width(48.dp)
    ) {
        val xOffset by animateDpAsState(targetValue = if (isActive) 24.dp else 0.dp, animationSpec = tween(150))
        val color by animateColorAsState(if (isActive) Theme.colors.primary else Theme.colors.onBackground.disabled, animationSpec = tween(150))

        Box(
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = xOffset.roundToPx(),
                        y = 0
                    )
                }
                .size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(Theme.shapes.absolute)
                    .background(color)
            )
        }
    }
}


@Preview
@Composable
private fun SwitchPreview() {
    var isActive by remember { mutableStateOf(false) }
    AppTheme {
        Switch(
            isActive = isActive,
            onActiveChanged = { isActive = it }
        )
    }
}