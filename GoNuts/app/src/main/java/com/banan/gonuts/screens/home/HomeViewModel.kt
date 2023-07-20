package com.banan.gonuts.screens.home

import androidx.lifecycle.ViewModel
import com.banan.gonuts.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getOffersDonut()
        getDonuts()
    }


    private fun getOffersDonut() {
        _state.update {
            it.copy(
                offersDonut = listOf(
                    OffersDonutUiState(
                        donatName = "Strawberry Wheel",
                        donatDescription = "These Baked Strawberry Donuts are filled with fresh strawberries jhg jlk ",
                        donatImage = R.drawable.donut_strawberry_4,
                        origin = 20f,
                        copun = 16f,
                    ),
                    OffersDonutUiState(
                        donatName = "Chocolate Glaze",
                        donatDescription = "Moist and fluffy baked chocolate donuts full of chocolate flavor. ",
                        donatImage = R.drawable.donut_chocolate_2,
                        origin = 30f,
                        copun = 26f,
                    ),
                    OffersDonutUiState(
                        donatName = "Strawberry Wheel",
                        donatDescription = "These Baked Strawberry Donuts are filled with fresh strawberries jhg jlk ",
                        donatImage = R.drawable.donut_strawberry_4,
                        origin = 10f,
                        copun = 5f,
                    ),
                    OffersDonutUiState(
                        donatName = "Chocolate Glaze",
                        donatDescription = "Moist and fluffy baked chocolate donuts full of chocolate flavor. ",
                        donatImage = R.drawable.donut_chocolate_2,
                        origin = 28f,
                        copun = 26f,
                    ),


                )
            )
        }
    }

    private fun getDonuts() {
        _state.update {
            it.copy(
                donuts = listOf(
                    DunantsUiState(
                        donatImage = R.drawable.donut_strawberry_1,
                        donatName = "Strawberry Wheel",
                        donatDescription = "These Baked Strawberry Donuts are filled with fresh strawberries jhg jlk ",
                         price = 16f,
                    ),
                    DunantsUiState(
                        donatImage = R.drawable.donut_strawberry_2,
                        donatName = "Chocolate Glaze",
                        donatDescription = "Moist and fluffy baked chocolate donuts full of chocolate flavor. ",
                        price = 26f,
                    ),
                    DunantsUiState(
                        donatImage = R.drawable.donut_strawberry_3,
                        donatName = "Strawberry Wheel",
                        donatDescription = "These Baked Strawberry Donuts are filled with fresh strawberries jhg jlk ",
                        price = 5f,
                    ),
                    DunantsUiState(
                        donatImage = R.drawable.donut_strawberry_1,
                        donatName = "Chocolate Glaze",
                        donatDescription = "Moist and fluffy baked chocolate donuts full of chocolate flavor. ",
                        price = 26f,
                    ),


                    )
            )
        }
    }
}