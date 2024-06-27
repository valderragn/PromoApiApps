package com.example.promoapp.Promo.presentation.PromoScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.domain.model.attributes
import com.example.promoapp.ui.theme.PromoAppTheme


@Composable
fun PromoCard(
    modifier: Modifier,
    promo: Promo,
    onClick: () -> Unit
){
    Card(
        onClick = { onClick },
        modifier = Modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(contentColor = Color.Black)
    ) {
        Column(
            modifier= Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = promo.attributes.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
            Text(
                text = promo.attributes.desc_promo,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement  = Arrangement.SpaceBetween
            ){
                Text(
                    text = promo.attributes.name_promo,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = promo.attributes.lokasi,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val samplePromo = Promo(
        id = 1,
        attributes = attributes(
            title = "Summer Sale",
            count = 100,
            alt = 50,
            desc = "Get discounts on selected items!",
            desc_promo = "Limited time offer",
            latitude = "40.7128",
            longitude = "-74.0060",
            lokasi = "New York",
            nama = "My Promo Store",
            name_promo = "Summer2023",
            createdAt = "2023-06-01",
            updatedAt = "2023-06-15"
        )
    )


//    PromoAppTheme {
//        PromoCard(
//            modifier = Modifier.fillMaxSize(),
//            promo = samplePromo,
//            onClick = {onPromoCardClicked(them)})
//    }
}