package com.banan.roomsession.firebase.remote

import com.banan.roomsession.domain.model.Visitor
import kotlinx.coroutines.flow.Flow

interface VisitorDataBase {

    suspend fun createVisitor(visitor: Visitor)

    suspend fun getVisitorById(id: String): Visitor?

    suspend fun getVisitors(): Flow<List<Visitor?>>

    suspend fun getVisitorFLowById(id: String): Flow<Visitor?>

    suspend fun updateVisitorState(id: String, isAdmin: Boolean)

}