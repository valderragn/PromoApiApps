package com.example.promoapp.di

import com.example.promoapp.Promo.data.remote.PromoApi
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.util.Constant.BASE_URL
import com.example.promoapp.util.Constant.YOUR_ACCESS_TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePromoApi(): PromoApi{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
            .build().create(PromoApi::class.java)
    }
}