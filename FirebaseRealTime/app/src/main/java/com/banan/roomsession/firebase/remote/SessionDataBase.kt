package com.banan.roomsession.firebase.remote

import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.repo.RoomState
import kotlinx.coroutines.flow.Flow

interface SessionDataBase {

    suspend fun createSession(room: Room)

    suspend fun getSession(id: String): Flow<Room>

    suspend fun joinSession(id: String, visitor: Visitor)

    suspend fun updateRoomState(id: String, roomState: RoomState)

    suspend fun isRoomExists(id: String): Boolean

    suspend fun updateImageState(id: String, state: Boolean)

}