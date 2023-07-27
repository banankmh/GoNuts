package com.banan.roomsession.domain.model

import com.banan.roomsession.repo.RoomState

data class Room(
    val id: String = "",
    val visitors: List<Visitor> = emptyList(),
    val state: RoomState = RoomState.PAUSED,
    val imageState: Boolean = false,
)
