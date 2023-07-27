package com.banan.roomsession.screens.create_visitor.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banan.roomsession.domain.use_case.CreateVisitorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateVisitorViewModel  @Inject constructor(
    private val createVisitorUseCase: CreateVisitorUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CreateVisitorUiState())
    val state = _state.asStateFlow()

    fun onNameChange(newName: String) {
        _state.update { it.copy(visitorName = newName) }
    }

    fun createVisitor() {
        tryToExecute(
            call = {
                createVisitorUseCase(_state.value.visitorName,)
            },
            onSuccess =::onCreateVisitorSuccess,
            onError = ::onCreateVisitorPlayerError
        )
    }
    private fun onCreateVisitorSuccess(unit: Unit) {
        _state.update { it.copy(isVisitorCreated = true)
        }
    }
    fun clearIsCreated() {
        _state.update { it.copy(isVisitorCreated = false) }
    }

    private fun onCreateVisitorPlayerError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message) }
    }
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

