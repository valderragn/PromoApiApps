package com.example.promoapp.Promo.domain.model

data class dataPromo(
    val data : List<Promo>
)

data class Promo(
    val id : Int,
    val attributes: attributes
)

data class attributes(
    val title: String,
    val count: Int,
    val alt: Int,
    val desc: String,
    val desc_promo: String,
    val latitude: String,
    val longitude: String,
    val lokasi: String,
    val nama: String,
    val name_promo: String,
    val createdAt: String,
    val updatedAt: String
)