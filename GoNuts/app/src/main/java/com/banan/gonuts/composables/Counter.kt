package com.banan.gonuts.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground
import com.banan.gonuts.ui.theme.onPrimary


@Composable
    fun CounterDesign(
        onClickPlus: () -> Unit = {},
        onClickMinus: () -> Unit = {},
        quantity: Int = 1,
    ) {
        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ButtonCounter(
                text = "-",
                modifier = Modifier
                    .size(45.dp)
                    .customShadow(shape = RoundedCornerShape(15.dp))
                    .background(color = onPrimary)
                    .clip(RoundedCornerShape(15.dp)),
                onClick = onClickMinus
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(45.dp)
                    .customShadow(shape = RoundedCornerShape(15.dp))
                    .background(color =  onPrimary)
                    .clip(RoundedCornerShape(15.dp)),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = quantity.toString(),
                    textAlign = TextAlign.Center,
                    style = Typography.bodyLarge,
                )

            }
            ButtonCounter(
                text = "+",
                modifier = Modifier
                    .size(45.dp)
                    .customShadow(shape = RoundedCornerShape(15.dp))
                    .background(color =  onPrimary)
                    .clip(RoundedCornerShape(15.dp)),
                onClick = onClickPlus
            )
        }
    }

@Composable
fun ButtonCounter(
    modifier: Modifier = Modifier,
                   onClick: () -> Unit = {},
                   text: String,){

        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        IconButton(
            onClick = onClick,
            modifier = modifier.background(
                color = if (isPressed) onBackground else Color.Transparent,
            ),
            interactionSource = interactionSource
        ) {
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = Typography.bodyLarge,
                color = if (isPressed) onPrimary else onBackground
            )
        }
    }



