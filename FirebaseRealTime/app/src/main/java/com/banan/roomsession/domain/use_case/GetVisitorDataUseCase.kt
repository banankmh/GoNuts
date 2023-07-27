package com.banan.roomsession.domain.use_case

import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.repo.RoomRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVisitorDataUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(): Flow<Visitor?> {
        return roomRepo.getVisitorData()
    }
}