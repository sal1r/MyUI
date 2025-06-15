package com.salir.myui.components.navigation

import android.widget.Space
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salir.myui.R
import com.salir.myui.components.Text
import com.salir.myui.theme.AppTheme
import com.salir.myui.theme.Theme
import com.salir.myui.theme.colors.disabled

@Composable
fun <T> BottomNavigationBar(
    items: List<NavigationBarItem<T>>,
    onItemClick: (NavigationBarItem<T>) -> Unit,
    currentDestination: T
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(Theme.colors.container)
    ) {
        items.forEach { item ->
            val color by animateColorAsState(
                targetValue = if (item.destination == currentDestination) Theme.colors.primary
                    else Theme.colors.onBackground.disabled,
                animationSpec = tween(150)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(onClick = { onItemClick(item) }, indication = null, interactionSource = null),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = item.icon,
                    contentDescription = item.label,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.label,
                    color = color
                )
            }
        }
    }
}


@Preview
@Composable
private fun BottomNavigationBarPreview() {
    AppTheme {
        BottomNavigationBar(
            items = listOf(
                NavigationBarItem(
                    destination = "screen 1",
                    icon = painterResource(R.drawable.ic_launcher_background),
                    label = "screen 1"
                ),
                NavigationBarItem(
                    destination = "screen 2",
                    icon = painterResource(R.drawable.ic_launcher_background),
                    label = "screen 2"
                ),
            ),
            onItemClick = {},
            currentDestination = "screen 1"
        )
    }
}