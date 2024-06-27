package com.example.promoapp.Promo.data.remote

import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.domain.model.dataPromo
import retrofit2.http.GET

interface PromoApi {

    @GET("promos")
    suspend fun getPromos(): dataPromo
}