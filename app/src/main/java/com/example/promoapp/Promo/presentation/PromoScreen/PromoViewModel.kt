package com.example.promoapp.Promo.presentation.PromoScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promoapp.Promo.domain.model.Promo
import com.example.promoapp.Promo.domain.repository.PromoRepo
import com.example.promoapp.Promo.presentation.util.sendEvent
import com.example.promoapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(
    private val promoRepo: PromoRepo
): ViewModel() {

    private val _state = MutableStateFlow(PromoViewState())
    private val _navigateToDetailActivity = MutableLiveData<Promo>()
    val state = _state.asStateFlow()
    val navigateToDetailActivity: LiveData<Promo> = _navigateToDetailActivity

    init {
        getPromos()
    }

    fun getPromos(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            promoRepo.getPromo()
                .onRight { promos ->
                    _state.update {
                        it.copy(promos = promos)
                    }
                }.onLeft { error ->
                    _state.update {
                        it.copy(
                            error = error.error.message
                        )
                    }
                    sendEvent(Event.Toast(error.error.message))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }

    fun onPromoCardClicked(promo: Promo) {
        _navigateToDetailActivity.value = promo
    }

}