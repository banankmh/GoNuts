package com.banan.roomsession.domain.use_case

import android.util.Log
import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class CreateRoomUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(visitorId: String) {
        val visitor = roomRepo.getVisitorDataById(visitorId)
        Log.e("CreateRoomUseCase",visitor.toString())
        roomRepo.createRoom(
            Room(
                id = visitorId,
                visitors = listOf(visitor?.copy(isAdmin = true)?: throw Throwable("Visitors not found"),)
            )
        )
        Log.e("CreateRoomUseCase",visitor.toString())
    }
}