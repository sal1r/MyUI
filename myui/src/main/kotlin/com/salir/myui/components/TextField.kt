package com.salir.myui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.LocalContentColor
import com.salir.myui.theme.typo.LocalTextStyle

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    minLines: Int = 1,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = Theme.typo.body.copy(color = Theme.colors.onBackground),
        cursorBrush = SolidColor(Theme.colors.primary),
        interactionSource = interactionSource,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
//        modifier = modifier,
        minLines = minLines,
        maxLines = maxLines,
        decorationBox = { innerTextField ->
            val color by animateColorAsState(
                targetValue = if (isFocused) Theme.colors.primary else Theme.colors.onBackground,
                animationSpec = tween(150)
            )

            Column {
                label?.let { label ->
                    Box(
                        modifier = Modifier.padding(start = 2.dp)
                    ) {
                        CompositionLocalProvider(
                            LocalTextStyle provides Theme.typo.label,
                            LocalContentColor provides color
                        ) {
                            label.invoke()
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))
                }
                Box(
                    modifier = modifier
                        .clip(Theme.shapes.small)
                        .border(
                            width = 2.dp,
                            color = color,
                            shape = Theme.shapes.small
                        )
                        .padding(horizontal = 8.dp, vertical = 10.dp)
                ) {
                    innerTextField()
                }
            }
        }
    )
}

@Preview
@Composable
private fun TextFieldPreview() {
    var value by remember { mutableStateOf("TextField") }
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = value,
                onValueChange = { value = it },
                label = {
                    Text(text = "Label")
                }
            )
        }
    }
}