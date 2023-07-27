package com.banan.roomsession.screens.create_room

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.roomsession.R
import com.banan.roomsession.screens.create_room.view_model.CreateJoinRoomUiState
import com.banan.roomsession.screens.create_room.view_model.CreateRoomViewModel
import com.banan.roomsession.screens.create_visitor.EnterUserNameBox
import com.banan.roomsession.screens.room.navigateToRoom
import com.banan.roomsession.ui.theme.PurpleGrey80

@Composable
fun CreateRoomScreen(
    navController: NavController,
    createRoomViewModel: CreateRoomViewModel = hiltViewModel()
) {
    val state by createRoomViewModel.state.collectAsState()
    val context = LocalContext.current

    CreateRoomContent(
        state = state,
        onClickCreateRoom = createRoomViewModel::onClickCreateRoom,
        onClickJoinRoom = { roomId ->/*
            if (state.visitor.id != roomId && roomId.isNotBlank() && roomId == state.roomId) {
                navController.navigateToRoom(roomId)
            } else {
                Toast.makeText(context, "Rejoining the room is not allowed", Toast.LENGTH_SHORT)
                    .show()
            }*/

            createRoomViewModel.onClickJoinRoom(roomId)
        },
        onSessionIdChange = createRoomViewModel::onRoomIdChange,
        showEnterRoomId = createRoomViewModel::showEnterRoomId,
        hideDialog = createRoomViewModel::hideEnterDialog,
        onDoneClick = createRoomViewModel::onDoneClick
    )
    DisposableEffect(key1 = state.isRoomCreated) {
        if (state.isRoomCreated) {
            Log.e("DisposableEffect", state.visitor.isAdmin.toString())
            navController.navigateToRoom(state.visitor.id)
        }
        onDispose { createRoomViewModel.clearIsRoomCreated() }
    }

    DisposableEffect(key1 = state.isRoomJoined) {
        if (state.isRoomJoined) {
            Log.e("DisposableEffect", state.visitor.isAdmin.toString())
            navController.navigateToRoom(state.roomId)
        }
        onDispose { createRoomViewModel.clearIsRoomCreated() }
    }
}

@Composable
fun CreateRoomContent(
    state: CreateJoinRoomUiState,
    onClickCreateRoom: () -> Unit,
    onClickJoinRoom: (String) -> Unit,
    showEnterRoomId: () -> Unit,
    hideDialog: () -> Unit,
    onDoneClick: () -> Unit,
    onSessionIdChange: (String) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .scale(3.5f)
                .padding(top = 48.dp)
        )

        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = "Welcome Ya ${state.visitor.name}", fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onClickCreateRoom,
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()
        )
        {
            Text(text = "Create Room")
        }

        Button(
            onClick = showEnterRoomId,
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = PurpleGrey80,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Join Room")
        }

        if (state.showSessionIdBox) {
            EnterUserNameBox(
                text = state.roomId,
                onNameChange = { onSessionIdChange(it) }
            )

            Button(
                onClick = {
                    Log.e("join room", state.roomId)
                    onClickJoinRoom(state.roomId)
                },
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey80,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Join Room")
            }
        }
        if (state.showDialog) {
            AlertDialog(
                onDismissRequest = hideDialog,
                title = { Text(text = "Room Created") },
                text = { Text(text = "Room ID: ${state.visitor.id}") },
                confirmButton = {
                    TextButton(onClick = {
                        hideDialog()
                        onDoneClick()
                    }) { Text(text = "Done") }
                },
                dismissButton = {
                    TextButton(onClick = hideDialog) { Text(text = "Dismiss") }
                }
            )
        }
    }
}

