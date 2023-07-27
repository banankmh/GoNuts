package com.banan.gonuts.screens.details

import androidx.lifecycle.ViewModel
import com.banan.gonuts.screens.home.OffersDonutUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(OffersDonutUiState())
    val state = _state.asStateFlow()


    fun increaseQuantity() {
        if (state.value.origin >=0) {
            _state.update {
                it.copy(
                        quantity = (it.quantity + 1),
                        origin = (it.origin* it.quantity)
                    )

            }
        }

    }

    fun decreaseQuantity() {
        if (state.value.quantity > 1) {
            _state.update {
                it.copy(
                        quantity = (it.quantity - 1),
                        origin = (it.origin / it.quantity)

                )
            }
        }
    }

}