package com.banan.roomsession.repo

import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.domain.model.Visitor
import kotlinx.coroutines.flow.Flow

interface RoomRepo {
    suspend fun createRoom(room: Room)

    suspend fun getRoom(id: String): Flow<Room>

    suspend fun joinSession(id: String, visitor: Visitor)

    suspend fun createVisitor(visitor: Visitor)

    suspend fun getVisitorData(): Flow<Visitor?>

    suspend fun getVisitorDataById(visitorId: String): Visitor?

    suspend fun getVisitorById(): String

    suspend fun getVisitors(): Flow<List<Visitor?>>

    suspend fun updateVisitorState(visitorId: String, isAdmin: Boolean)

    suspend fun updateRoomState(id: String, roomState: RoomState)

    suspend fun isRoomExists(id: String): Boolean

    suspend fun updateImageState(id: String, state: Boolean)

}

enum class RoomState {
    PAUSED, END, IN_PROGRESS
}