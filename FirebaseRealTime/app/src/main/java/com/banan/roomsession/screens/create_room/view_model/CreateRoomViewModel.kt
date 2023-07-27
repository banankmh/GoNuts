package com.banan.roomsession.screens.create_room.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banan.roomsession.domain.model.Visitor
import com.banan.roomsession.domain.use_case.CreateRoomUseCase
import com.banan.roomsession.domain.use_case.GetVisitorDataUseCase
import com.banan.roomsession.domain.use_case.JoinRoomUseCase
import com.banan.roomsession.domain.use_case.UpdateRoomStateUseCase
import com.banan.roomsession.domain.use_case.UpdateVisitorStateUseCase
import com.banan.roomsession.repo.RoomState
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
class CreateRoomViewModel @Inject constructor(
    private val getVisitorDataUseCase: GetVisitorDataUseCase,
    private val joinRoomUseCase: JoinRoomUseCase,
    private val createRoomUseCase: CreateRoomUseCase,
    private val updateVisitorStateUseCase: UpdateVisitorStateUseCase,
    private val updateRoomStateUseCase: UpdateRoomStateUseCase,
    private val visitorMapper: VisitorMapper,

    ) : ViewModel(), CreateJoinRoomListener {
    private val _state = MutableStateFlow(CreateJoinRoomUiState())
    val state = _state.asStateFlow()

    init {
        getVisitorData()
    }

    /// region visitorData
    private fun getVisitorData() {
        tryToExecute(
            call = { getVisitorDataUseCase() },
            onSuccess = ::onGetVisitorDataSuccess,
            onError = ::onGetVisitorDataError
        )
    }

    private fun onGetVisitorDataSuccess(visitor: Flow<Visitor?>) {
        viewModelScope.launch {
            visitor.collect { player -> _state.update {
                    it.copy(
                        visitor = visitorMapper.map(player!!),
                        error = null,
                    )
                } }
        }
    }

    private fun onGetVisitorDataError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message) }
    }

    ///endregion

    /// region createRoom
    override fun onClickCreateRoom() {
        tryToExecute(
            call = {
                createRoomUseCase(_state.value.visitor.id)
                updateVisitorStateUseCase(_state.value.visitor.id, true)
            },
            onSuccess = ::onCreateRoomSuccess,
            onError = ::onCreateRoomError
        )
    }

    private fun onCreateRoomSuccess(unit: Unit) {
        _state.update { it.copy(showDialog = true, isAdmin = true) }
    }

    fun clearIsRoomCreated() {
        _state.update { it.copy(isRoomCreated = false) }
    }

    private fun onCreateRoomError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message) }
        Log.e("onCreateSessionError", throwable.message.toString())

    }
    /// endregion

    /// region joinSession
    override fun onClickJoinRoom(sessionId: String) {
        _state.update { it.copy(showSessionIdBox = true) }
        tryToExecute(
            call = {
                joinRoomUseCase(visitorId = _state.value.visitor.id, roomId = sessionId)
                updateVisitorStateUseCase(_state.value.visitor.id, false)
                updateRoomStateUseCase(sessionId, RoomState.IN_PROGRESS)
                Log.e("onClickJoinRoom", _state.value.visitor.id)
            },
            onSuccess = ::onJoinSessionSuccess,
            onError = ::onJoinSessionError
        )
    }

    private fun onJoinSessionSuccess(unit: Unit) {
        _state.update { it.copy(showSessionIdBox = true, isRoomJoined = true) }
        Log.e("onJoinSessionSuccess", "hello")
    }

    private fun onJoinSessionError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message) }
        Log.e("onJoinSessionError", throwable.message.toString())
    }

    fun showEnterRoomId() {
        _state.update { it.copy(showSessionIdBox = true) }
    }

    fun hideEnterRoomId() {
        _state.update { it.copy(showSessionIdBox = false) }
    }

    fun hideEnterDialog() {
        _state.update { it.copy(showDialog = false) }
    }

    fun onRoomIdChange(sessionId: String) {
        _state.update { it.copy(roomId = sessionId) }
    }

    fun onDoneClick(){
        _state.update { it.copy(isRoomCreated = true) }
        Log.e("onDone",state.value.visitor.isAdmin.toString())
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

interface CreateJoinRoomListener {
    fun onClickCreateRoom()
    fun onClickJoinRoom(sessionId: String)
}