package com.banan.roomsession.repo

import android.util.Log
import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.firebase.local.VisitorDataStorageImpl
import com.banan.roomsession.firebase.remote.SessionDataBase
import com.banan.roomsession.firebase.remote.VisitorDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepoImpl @Inject constructor(
    private val storeVisitorData: VisitorDataStorageImpl,
    private val sessionDataBase: SessionDataBase,
    private val visitorDataBase: VisitorDataBase
) : RoomRepo {
    override suspend fun createRoom(room: Room) {
        Log.e("before createSession", room.toString())
        sessionDataBase.createSession(room)
        Log.e("after createSession", room.toString())
    }

    override suspend fun getRoom(id: String): Flow<Room> {
        Log.e("before getSession", sessionDataBase.getSession(id).toString())
        return sessionDataBase.getSession(id)
    }

    override suspend fun joinSession(id: String, visitor: Visitor) {
        sessionDataBase.joinSession(id, visitor)
    }

    override suspend fun createVisitor(visitor: Visitor) {
        val visitorId = storeVisitorData.getVisitorById()
        if (visitorId == null) {
            storeVisitorData.saveVisitorId(visitor.id)
        } else {
            storeVisitorData.clearVisitorId()
            storeVisitorData.saveVisitorId(visitor.id)
        }
        visitorDataBase.createVisitor(visitor)
    }

    override suspend fun getVisitorData(): Flow<Visitor?> {
        val id = storeVisitorData.getVisitorById()!!
        return visitorDataBase.getVisitorFLowById(id)
    }

    override suspend fun getVisitorDataById(visitorId: String): Visitor? {
        Log.e("getVisitorDataById Imp", visitorDataBase.getVisitorById(visitorId).toString())
        return visitorDataBase.getVisitorById(visitorId)
    }

    override suspend fun getVisitorById(): String {
        return storeVisitorData.getVisitorById()!!
    }

    override suspend fun getVisitors(): Flow<List<Visitor?>> {
        return visitorDataBase.getVisitors()
    }

    override suspend fun updateVisitorState(visitorId: String, isAdmin: Boolean) {
        visitorDataBase.updateVisitorState(visitorId, isAdmin)
    }

    override suspend fun updateRoomState(id: String, roomState: RoomState) {
        sessionDataBase.updateRoomState(id, roomState)
    }

    override suspend fun isRoomExists(id: String): Boolean {
        return sessionDataBase.isRoomExists(id)
    }

    override suspend fun updateImageState(id: String, state: Boolean) {
        sessionDataBase.updateImageState(id, state)
    }
}