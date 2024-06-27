package com.example.promoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.presentation.PromoScreen.DetailPromo
import com.example.promoapp.ui.theme.PromoAppTheme
import com.google.gson.Gson

class detailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val promoDataString = intent.getStringExtra("promoData")
        val promo = Gson().fromJson(promoDataString, Promo::class.java)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PromoAppTheme {
                DetailPromo(promo = promo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PromoAppTheme {

    }
}