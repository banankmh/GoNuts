package com.banan.gonuts.composables

import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground80
import com.banan.gonuts.ui.theme.onPrimary

@Composable
fun ButtonItem(text : String, modifier: Modifier = Modifier, onClick:() -> Unit, textColor: Color = onBackground80, backgroundColor: Color = onPrimary) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier.fillMaxWidth(),
        contentPadding=ButtonDefaults.ContentPadding
    ){
        Text(
            text = text,
            style = Typography.titleSmall,
            color = textColor
        )
    }
}