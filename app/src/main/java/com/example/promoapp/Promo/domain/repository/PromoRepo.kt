package com.example.promoapp.Promo.domain.repository

import arrow.core.Either
import com.example.promoapp.Promo.domain.model.NetworkError
import com.example.promoapp.Promo.domain.model.Promo

interface PromoRepo {

    suspend fun getPromo(): Either<NetworkError, List<Promo>>

    suspend fun getDetail(promo: Promo)
}