package com.banan.roomsession.firebase

import android.util.Log
import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.firebase.remote.SessionDataBase
import com.banan.roomsession.repo.RoomState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.snapshots
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class SessionImpl @Inject constructor(
    @Named("sessions") private val sessionDatabaseReference: DatabaseReference,
) : SessionDataBase {

    override suspend fun createSession(room: Room) {
        Log.e("beforeSessionImpl ", room.toString())
        sessionDatabaseReference.child(room.id).setValue(room).await()
        Log.e("afterSessionImpl ", room.toString())
    }


    override suspend fun getSession(id: String): Flow<Room> = callbackFlow {
        val ref = sessionDatabaseReference.child(id)
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val room = snapshot.getValue(Room::class.java)
                if (room == null) close()
                else
                    trySend(room)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        ref.addValueEventListener(valueEventListener)
        awaitClose { ref.removeEventListener(valueEventListener) }
    }

    override suspend fun joinSession(id: String, visitor: Visitor) {
        sessionDatabaseReference.child(id).child("visitors").child("1")
            .setValue(visitor)
            .await()
    }

    override suspend fun isRoomExists(id: String): Boolean {
        val snapshot = sessionDatabaseReference.child(id).get().await()
        return snapshot.exists()
    }


    override suspend fun updateRoomState(id: String, roomState: RoomState) {
        sessionDatabaseReference.child(id).child(STATE).setValue(roomState).await()
        Log.e("updateRoomState", roomState.toString())
    }

    override suspend fun updateImageState(id: String, state: Boolean) {
        sessionDatabaseReference.child(id).child(IMAGE_STATE).setValue(state).await()
    }

    companion object {
        private const val STATE = "state"
        private const val IMAGE_STATE = "imagestate"

    }

}