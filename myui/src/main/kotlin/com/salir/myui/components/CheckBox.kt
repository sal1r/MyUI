package com.salir.myui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.salir.myui.R
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme

@Composable
fun CheckBox(
    isActive: Boolean,
    onActiveChanged: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .border(width = 2.dp, color = Theme.colors.primary, shape = Theme.shapes.small)
            .clip(Theme.shapes.small)
            .background(Theme.colors.container)
            .clickable(onClick = { onActiveChanged(!isActive) }, interactionSource = remember { MutableInteractionSource() }, indication = null)
            .padding(4.dp)
            .size(24.dp)
    ) {
        AnimatedVisibility(
            visible = isActive,
            enter = fadeIn(tween(150)) + scaleIn(tween(150), 0.9f),
            exit = fadeOut(tween(150)) + scaleOut(tween(150), 0.9f),
        ) {
            Image(
                painter = painterResource(R.drawable.ic_check),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Theme.colors.primary),
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }
}


@Preview
@Composable
private fun CheckBoxPreview() {
    var isActive by remember { mutableStateOf(false) }
    AppTheme {
        CheckBox(
            isActive = isActive,
            onActiveChanged = { isActive = it }
        )
    }
}