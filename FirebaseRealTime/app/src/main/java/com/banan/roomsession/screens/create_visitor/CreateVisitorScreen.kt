package com.banan.roomsession.screens.create_visitor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.roomsession.screens.composables.ButtonApp
import com.banan.roomsession.screens.create_room.navigateToCreateRoom
import com.banan.roomsession.screens.create_visitor.view_model.CreateVisitorViewModel

@Composable
fun CreateVisitorScreen(
    viewModel: CreateVisitorViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = state.isVisitorCreated) {
        if (state.isVisitorCreated) {
            navController.navigateToCreateRoom()
            viewModel.clearIsCreated()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize()
                .padding(horizontal = 24.dp),

            ) {
            Spacer(modifier = Modifier.height(80.dp))
            EnterUserNameBox(
                text = state.visitorName,
                onNameChange = viewModel::onNameChange,
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonApp(
                text = "Continue",
                onClick = viewModel::createVisitor,
                enabled = state.visitorName.isNotBlank()
            )
        }
    }
}