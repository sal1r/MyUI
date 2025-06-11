package com.salir.myui.theme.indication

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.max

class BubbleIndicationNode(
    private val interactionSource: InteractionSource
): Modifier.Node(), DrawModifierNode {
    private var pressPosition: Offset = Offset.Zero
    private val animatedScale = Animatable(0.1f)
    private val animatedAlpha = Animatable(0.5f)
    private val animationSpec = tween<Float>(1000)


    override fun onAttach() {
        coroutineScope.launch {
            /*
            При использовании collectLatest вместо collect может быть не обработано первое
            нажатие в том случае, если мы используем перегрузку Modifier.clickable() без передачи
            своего InteractionSource. В таком случае создание IndicationNode происходит лениво
            ПОСЛЕ того, как событие PressInteraction.Press поступит в InteractionSource.
             */
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        pressPosition = interaction.pressPosition

                        animatedAlpha.snapTo(0.5f)
                        animatedScale.snapTo(0.1f)

                        launch { animatedAlpha.animateTo(
                            targetValue = 0f,
                            animationSpec = animationSpec
                        ) }
                        launch { animatedScale.animateTo(
                            targetValue = 1f,
                            animationSpec = animationSpec
                        ) }
                    }
                }
            }
        }
    }

    override fun ContentDrawScope.draw() {
        drawContent()
        drawCircle(
            color = Color(0xFF000000),
            center = pressPosition,
            radius = max(size.width, size.height) * animatedScale.value,
            alpha = animatedAlpha.value
        )
    }
}