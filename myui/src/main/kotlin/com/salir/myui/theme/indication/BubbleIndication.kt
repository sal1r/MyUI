package com.salir.myui.theme.indication

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.ui.node.DelegatableNode


class BubbleIndication: IndicationNodeFactory {

    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return BubbleIndicationNode(interactionSource)
    }

    override fun equals(other: Any?): Boolean = other === this

    override fun hashCode(): Int = -1

}