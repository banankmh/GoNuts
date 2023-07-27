package com.banan.roomsession.screens.room.view_model

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banan.roomsession.domain.model.Room
import com.banan.roomsession.domain.use_case.GetRoomDataUseCase
import com.banan.roomsession.domain.use_case.GetVisitorIdUseCase
import com.banan.roomsession.domain.use_case.UpdateImageStateUseCase
import com.banan.roomsession.domain.use_case.UpdateRoomStateUseCase
import com.banan.roomsession.screens.create_room.view_model.VisitorMapper
import com.banan.roomsession.screens.room.RoomArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val getRoomDataUseCase: GetRoomDataUseCase,
    private val getVisitorIdUseCase: GetVisitorIdUseCase,
    private val visitorMapper: VisitorMapper,
    private val updateImageStateUseCase: UpdateImageStateUseCase,
    private val updateRoomStateUseCase: UpdateRoomStateUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = MutableStateFlow(RoomUiState())
    val state = _state.asStateFlow()

    private val sessionId = RoomArgs(savedStateHandle = savedStateHandle).id

    init {
        getRoomData(sessionId)
        Log.e("init", state.value.visitor.toString())

    }
    /// region room

    private fun getRoomData(id: String) {
        tryToExecute(
            call = { getRoomDataUseCase(id) },
            onSuccess = ::onRoomDataSuccess,
            onError = ::onGetSessionDataError
        )
    }

    private fun onRoomDataSuccess(roomFlow: Flow<Room>) {
        _state.update { it.copy(error = null) }
        viewModelScope.launch {
            val visitorId = getVisitorIdUseCase()
            roomFlow.collect { room ->
                val isAdmin = room.visitors
                    .firstOrNull { it.id == visitorId }?.isAdmin ?: false
                Log.e("onRoomDataSuccess",isAdmin.toString())
                _state.update {
                    it.copy(
                        visitors = room.visitors.map{ visitor -> visitorMapper.map(visitor) },
                        roomId = room.id,
                        roomState = room.state,
                        isAdmin = isAdmin,
                        visitorId = visitorId,
                        showImage = room.imageState
                    )
                }
            }
        }
        Log.e("onRoomDataSuccess", state.value.visitor.toString())

    }

    private fun onGetSessionDataError(throwable: Throwable) {
        _state.update {
            it.copy(
                isSessionClosed = true,
                error = throwable.message
            )
        }
    }

     fun showImage(){
         tryToExecute(
             call = { updateImageStateUseCase(state.value.roomId,true) },
             onSuccess = { _state.update { it.copy(showImage = true) } },
             onError = { throw Throwable("Error")}
         )
     }

     fun hideImage(){
         tryToExecute(
             call = { updateImageStateUseCase(state.value.roomId,false) },
             onSuccess = { _state.update { it.copy(showImage = false) } } ,
             onError = { throw Throwable("Error")}
         )

     }

    /// endregion


    private fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }

}