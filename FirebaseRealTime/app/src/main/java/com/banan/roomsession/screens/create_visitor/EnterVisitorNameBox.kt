package com.banan.roomsession.screens.create_visitor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banan.roomsession.ui.theme.Purple40
import com.banan.roomsession.ui.theme.PurpleGrey80


@Composable
fun EnterUserNameBox(
    text: String,
    onNameChange: (String) -> Unit,
) {

    val colors = Purple40
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color =  PurpleGrey80,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text ="Enter ur name",
                fontSize = 24.sp,
                color = Color.Black,
            )
            UserNameRow(
                text = text,
                onNameChange = onNameChange,
            )
        }
    }
}

@Composable
fun UserNameRow(
    text: String,
    onNameChange: (String) -> Unit,
) {


    Row(
        Modifier
            .padding(24.dp)
            .background(color = Purple40, shape = RoundedCornerShape(100.dp))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = text,
            onValueChange = onNameChange,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(0.8f),
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White
            ),
            singleLine = true
        )
    }
}