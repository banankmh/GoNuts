package com.banan.roomsession.domain.use_case

import com.banan.roomsession.repo.RoomRepo
import com.banan.roomsession.repo.RoomState
import javax.inject.Inject

class UpdateRoomStateUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(id: String, roomState: RoomState) {
        roomRepo.updateRoomState(id, roomState)
    }
}
