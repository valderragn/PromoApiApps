package com.example.promoapp.di

import com.example.promoapp.Promo.data.repo.PromoRepoImp
import com.example.promoapp.Promo.domain.repository.PromoRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPromoRepo(impl: PromoRepoImp): PromoRepo

}