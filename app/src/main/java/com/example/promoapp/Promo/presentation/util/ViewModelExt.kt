package com.example.promoapp.Promo.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promoapp.util.Event
import com.example.promoapp.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}