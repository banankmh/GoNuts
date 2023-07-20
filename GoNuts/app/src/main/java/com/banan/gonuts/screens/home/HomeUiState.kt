package com.banan.gonuts.screens.home

data class HomeUiState(
    val offersDonut: List<OffersDonutUiState> = emptyList(),
    val donuts: List<DunantsUiState> = emptyList(),
)

data class OffersDonutUiState(
    val donatName: String = "",
    val donatDescription: String = "",
    val donatImage: Int = 0,
    val origin: Float = 0f,
    val copun: Float = 0f,
    var quantity:Int= 1,
)

data class DunantsUiState(
    val donatImage: Int = 0,
    val donatName: String = "",
    val donatDescription: String="",
    val price: Float =0f,
)