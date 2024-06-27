package com.example.promoapp.Promo.data.repo

import arrow.core.Either
import com.example.promoapp.Promo.data.mapper.toNetworkError
import com.example.promoapp.Promo.data.remote.PromoApi
import com.example.promoapp.Promo.domain.model.NetworkError
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.domain.repository.PromoRepo
import javax.inject.Inject

class PromoRepoImp @Inject constructor(
    private val promoApi: PromoApi
):PromoRepo {
    override suspend fun getPromo(): Either<NetworkError, List<Promo>> {
        return Either.catch {
            promoApi.getPromos().data
        }.mapLeft { it.toNetworkError()
        }
    }

    override suspend fun getDetail(promo: Promo) {

    }
}