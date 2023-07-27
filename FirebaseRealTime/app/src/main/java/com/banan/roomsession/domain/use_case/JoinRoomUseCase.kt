package com.banan.roomsession.domain.use_case

import android.annotation.SuppressLint
import android.util.Log
import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class JoinRoomUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    @SuppressLint("SuspiciousIndentation")
    suspend operator fun invoke(roomId: String, visitorId: String) {
        val visitor = roomRepo.getVisitorDataById(visitorId)
        if (roomRepo.isRoomExists(roomId)) {
            roomRepo.joinSession(roomId, visitor ?: throw Throwable("Visitor not found"))
        } else {
            throw Throwable("Room Not Found")
        }
        Log.e("JoinRoomUseCase", roomId)

    }
}