package com.banan.roomsession.domain.use_case

import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.repo.RoomRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoomDataUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(sessionId: String): Flow<Room> {
        return roomRepo.getRoom(sessionId)
    }
}