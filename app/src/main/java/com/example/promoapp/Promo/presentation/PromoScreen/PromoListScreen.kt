package com.example.promoapp.Promo.presentation.PromoScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.promoapp.Promo.presentation.PromoScreen.component.PromoCard
import com.example.promoapp.Promo.presentation.util.Component.LoadingDialog
import com.example.promoapp.Promo.presentation.util.Component.MyTopAppbar

@Composable
internal fun PromoListScreen(
    viewModel: PromoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    PromoContent(state = state, viewModel)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PromoContent(
    state: PromoViewState,
    viewModel: PromoViewModel
){
    LoadingDialog(isLoading = state.isLoading)
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppbar(tittle = "Promos")
        }
    ){
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 100.dp)
            ) {
            items(state.promos) { them ->
                PromoCard(them, viewModel)
            }
        }
    }
}