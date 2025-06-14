package com.salir.myui.components

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.disabled
import kotlinx.coroutines.flow.asFlow

// TODO: add progress state inside Composable
@Composable
fun Slider(
    progress: Float,
    onProgressChanged: (Float) -> Unit,
    onEndProgressChange: () -> Unit = {},
    range: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier
) {
    val prog = progress / range.endInclusive

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(Theme.shapes.absolute)
                .background(Theme.colors.onBackground.disabled)
        ) {
            Box(
                modifier = Modifier
                    .height(6.dp)
                    .clip(Theme.shapes.absolute)
                    .background(Theme.colors.primary)
                    .fillMaxWidth(prog)
            )
        }
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 2.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { offset: Offset ->
                            onProgressChanged((offset.x / size.width * range.endInclusive).coerceIn(range))
                        }
                    )
                }
        ) {
            val handlePos by rememberUpdatedState(maxWidth * prog)

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .offset {
                        IntOffset(
                            x = (handlePos - 8.dp).roundToPx(),
                            y = 0
                        )
                    }
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures(
                            onDragStart = {},
                            onHorizontalDrag = { change, amount ->
                                change.consume()
                                onProgressChanged(((handlePos.toPx() + amount) / maxWidth.toPx() * range.endInclusive).coerceIn(range))
                            },
                            onDragEnd = onEndProgressChange,
                            onDragCancel = onEndProgressChange
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .width(8.dp)
                        .clip(Theme.shapes.absolute)
                        .background(Theme.colors.primary)
                )
            }
        }
    }
}


@Preview
@Composable
private fun SliderPreview() {
    var progress by remember { mutableFloatStateOf(30f) }
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        ) {
            Slider(
                progress = progress,
                onProgressChanged = { progress = it },
                range = 0f..100f,
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(300.dp)
            )
        }
    }
}