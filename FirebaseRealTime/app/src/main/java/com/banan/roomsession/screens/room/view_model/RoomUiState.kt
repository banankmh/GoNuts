package com.banan.roomsession.screens.room.view_model

import com.banan.roomsession.repo.RoomState
import com.banan.roomsession.screens.create_room.view_model.VisitorUiState

data class RoomUiState(
    val isRoomCreated: Boolean = false,
    val isRoomJoined: Boolean = false,
    val visitor: VisitorUiState = VisitorUiState(),
    val roomId: String = "",
    val visitorId: String = "",
    val visitors : List<VisitorUiState> =  emptyList(),
    val error :String? = "",
    val isAdmin: Boolean = false,
    val showSessionIdBox : Boolean = false,
    val isSessionClosed: Boolean = false,
    val roomState: RoomState = RoomState.PAUSED,
    val showDialog: Boolean = false,
    val showImage : Boolean = true
    )
