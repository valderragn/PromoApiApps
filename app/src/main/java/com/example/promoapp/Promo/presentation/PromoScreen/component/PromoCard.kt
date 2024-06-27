package com.example.promoapp.Promo.presentation.PromoScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.presentation.PromoScreen.PromoViewModel


@Composable
fun PromoCard(
    promo: Promo,
    viewModel: PromoViewModel
){
    Card(
        onClick = { viewModel.onPromoCardClicked(promo) },
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
