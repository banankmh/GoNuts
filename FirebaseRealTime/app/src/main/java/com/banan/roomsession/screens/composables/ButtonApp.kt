package com.banan.roomsession.screens.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.banan.roomsession.ui.theme.Purple40
import com.banan.roomsession.ui.theme.PurpleGrey80

@Composable
fun ButtonApp(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    //  var isLoading= false

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Purple40,
            disabledContainerColor = PurpleGrey80,
            disabledContentColor = Purple40,
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
//        if (isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier.size(32.dp),
//                color = DarkOnBackground87
//            )
//        } else {
//
//        }

    }
}

