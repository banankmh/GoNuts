package com.banan.gonuts.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.blackShade
import com.banan.gonuts.ui.theme.onPrimary
import com.banan.gonuts.ui.theme.primary


    @Composable
    fun CounterDesign(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .background(color = onPrimary, shape = RoundedCornerShape(15.dp))
                .padding(15.dp)
                .shadow(elevation = 50.dp, spotColor = blackShade)
        ) {
            Text(
                text = text,
                style = Typography.bodyLarge,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }



@Preview(showSystemUi = true)
@Composable
fun CounterDesignpr(){
    CounterDesign("-",{})
}
