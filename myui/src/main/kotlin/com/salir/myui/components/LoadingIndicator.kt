package com.salir.myui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LoadingIndicator() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (PI / 2f).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )
    val color = Theme.colors.primary

    Canvas(
        modifier = Modifier.size(48.dp)
    ) {
        for (i in 0 until 8) {
            val angle = i * PI / 4 + angle

            drawCircle(
                brush = SolidColor(color),
                radius = 4.dp.toPx(),
                center = Offset(
                    x = (center.x + 20.dp.toPx() * cos(angle)).toFloat(),
                    y = (center.y + 20.dp.toPx() * sin(angle)).toFloat()
                )
            )
        }
    }
}


@Preview
@Composable
private fun LoadingIndicatorPreview() {
    AppTheme {
        LoadingIndicator()
    }
}