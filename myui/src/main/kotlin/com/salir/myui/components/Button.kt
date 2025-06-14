package com.salir.myui.components

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.LocalContentColor
import com.salir.myui.theme.typo.LocalTextStyle

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .clip(Theme.shapes.medium)
            .background(Theme.colors.primary)
            .clickable(onClick = onClick, interactionSource = interactionSource, indication = LocalIndication.current)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CompositionLocalProvider(
            LocalContentColor provides Theme.colors.onPrimary,
            LocalTextStyle provides Theme.typo.body
        ) {
            content.invoke(this)
        }
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    AppTheme {
        Button(
            onClick = {}
        ) {
            Text(
                text = "Button"
            )
        }
    }
}
