package com.example.promoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.example.promoapp.Promo.presentation.PromoScreen.PromoListScreen
import com.example.promoapp.Promo.presentation.PromoScreen.PromoViewModel
import com.example.promoapp.ui.theme.PromoAppTheme
import com.example.promoapp.util.Event
import com.example.promoapp.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PromoAppTheme {
                val viewModel: PromoViewModel = hiltViewModel()

                // Observe navigation event
                viewModel.navigateToDetailActivity.observe(this) { promo ->
                    val intent = Intent(this, detailActivity::class.java)
                    intent.putExtra("promoData", promo.toString())
                    startActivity(intent)
                }

                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(state = Lifecycle.State.STARTED){
                        EventBus.events.collect { event ->
                            if(event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize().fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PromoListScreen()
                }
            }
        }
    }
}
