package com.banan.roomsession.firebase

import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.firebase.remote.VisitorDataBase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class VisitorImpl@Inject constructor(
    @Named("visitors") private val firebaseDatabase: DatabaseReference
) : VisitorDataBase {
    override suspend fun createVisitor(visitor: Visitor) {
        firebaseDatabase.child(visitor.id).setValue(visitor).await()
    }

    override suspend fun getVisitorById(id: String): Visitor? {
        return firebaseDatabase.child(id).get().await().getValue(Visitor::class.java)
    }

    override suspend fun getVisitors(): Flow<List<Visitor?>> = callbackFlow {

        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val visitors = snapshot.children.map {
                    it.getValue(Visitor::class.java)
                }
                trySend(visitors)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }

        firebaseDatabase.addValueEventListener(valueEventListener)
        awaitClose { firebaseDatabase.removeEventListener(valueEventListener) }
    }

    override suspend fun getVisitorFLowById(id: String): Flow<Visitor?> = callbackFlow {
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val visitor = snapshot.getValue(Visitor::class.java)
                trySend(visitor)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }

        }
        firebaseDatabase.child(id).addValueEventListener(valueEventListener)
        awaitClose { firebaseDatabase.removeEventListener(valueEventListener) }
    }

    override suspend fun updateVisitorState(id: String, isAdmin: Boolean) {
        firebaseDatabase.child(id).child(IS_ADMIN).setValue(isAdmin).await()
    }

    companion object {
        private const val IS_ADMIN = "admin"

    }

}