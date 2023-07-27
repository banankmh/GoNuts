package com.banan.roomsession.domain.use_case

import android.util.Log
import com.banan.roomsession.repo.RoomRepo
import javax.inject.Inject

class UpdateVisitorStateUseCase @Inject constructor(
    private val roomSession: RoomRepo
) {
    suspend operator fun invoke(id: String, isAdmin: Boolean) {
        Log.e("before UpdateVisitorStateUseCase",isAdmin.toString())
        roomSession.updateVisitorState(id, isAdmin)
        Log.e("after UpdateVisitorStateUseCase",isAdmin.toString())
    }
}