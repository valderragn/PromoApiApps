package com.example.promoapp.Promo.data.mapper

import android.util.Log
import coil.network.HttpException
import com.example.promoapp.Promo.domain.model.ApiError
import com.example.promoapp.Promo.domain.model.NetworkError
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError{
    Log.d("NETWORKAPI", "toNetworkError: " + this.message.toString())
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}