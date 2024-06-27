package com.example.promoapp.Promo.presentation.PromoScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.domain.model.attributes
import com.example.promoapp.Promo.presentation.util.Component.MyTopAppbar
import com.example.promoapp.ui.theme.PromoAppTheme

@Composable
internal fun DetailPromo(
    promo: Promo
) {
    DetailContent(promo)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailContent(
    promo: Promo
){
    val theDescriptor = promo.attributes.desc
    val cleanDesc = theDescriptor.replace("\n","\\\n")

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppbar(tittle = "Promos")
        }
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 100.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = promo.attributes.title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = promo.attributes.lokasi
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = promo.attributes.desc_promo
                )

                Text(
                    text = promo.attributes.name_promo
                )
            }

            Text(
                modifier = Modifier.offset(y = 20.dp).fillMaxWidth(),
                text = cleanDesc,
                textAlign = TextAlign.Right
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    val samplePromo = Promo(
        id = 1,
        attributes = attributes(
            title = "Summer Sale",
            count = 100,
            alt = 50,
            desc = "The leather jacked showed the scars of being his favorite for years. It wore those scars with pride, feeling that they enhanced his presence rather than diminishing it. The scars gave it character and had not overwhelmed to the point that it had become ratty. The jacket was in its prime and it knew it.",
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


    PromoAppTheme {
        DetailContent(
            promo = samplePromo
        )
    }
}
