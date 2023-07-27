package com.banan.roomsession.screens.create_room.view_model

import com.banan.roomsession.domain.model.Visitor
import javax.inject.Inject

class VisitorMapper @Inject constructor() {
    fun map(input: Visitor): VisitorUiState {
        return VisitorUiState(
            id = input.id,
            name = input.name,
            isAdmin = input.isAdmin
        )
    }
}
