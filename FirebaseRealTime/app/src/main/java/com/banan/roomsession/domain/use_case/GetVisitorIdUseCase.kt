package com.banan.roomsession.domain.use_case

import android.util.Log
import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class GetVisitorIdUseCase @Inject constructor(
    val roomRepo: RoomRepo
) {
    suspend operator fun invoke(): String {
        Log.e("GetVisitorIdUseCase",roomRepo.getVisitorById())
        return roomRepo.getVisitorById()
    }
}