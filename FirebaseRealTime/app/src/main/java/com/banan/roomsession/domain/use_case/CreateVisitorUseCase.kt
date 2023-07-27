package com.banan.roomsession.domain.use_case

import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class CreateVisitorUseCase @Inject constructor(
    private val roomRepo: RoomRepo
) {
    suspend operator fun invoke(name: String) {
            val visitorId = System.currentTimeMillis().toString()
            val visitor = Visitor(id = visitorId, name = name)
            roomRepo.createVisitor(visitor)
        }
    }
