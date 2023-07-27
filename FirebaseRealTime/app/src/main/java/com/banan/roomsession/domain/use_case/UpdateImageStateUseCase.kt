package com.banan.roomsession.domain.use_case

import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class UpdateImageStateUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(roomId: String, imageState: Boolean) {
        roomRepo.updateImageState(roomId, imageState)
    }

}