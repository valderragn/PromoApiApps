package com.example.promoapp.Promo.presentation.PromoScreen

import com.example.promoapp.Promo.domain.model.Promo
import java.lang.Error

data class PromoViewState(
    val isLoading: Boolean =false,
    val promos: List<Promo> = emptyList(),
    val error: String? = null
)
