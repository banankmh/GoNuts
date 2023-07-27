package com.banan.roomsession.screens.create_visitor.view_model

data class CreateVisitorUiState(
    val visitorName:String = "",
    val isVisitorCreated: Boolean = false,
    val error: String? = null,
    )

