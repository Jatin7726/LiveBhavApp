package com.example.mcxpriceappp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mcxpriceappp.api.Metals
import com.example.mcxpriceappp.api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchPrices()
    }

    fun fetchPrices() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val response = RetrofitClient.apiService.getLatestPrices(
                    //apiKey = "N72YA1YJRBMWRFLHDTHC862LHDTHC",
                    apiKey = "IIDDQLHDRFPKX4KKAW8B301KKAW8B",
                    currency = "INR",
                    unit = "g"
                )
                _uiState.value = UiState.Success(response.metals,
                    usdToInr = response.currencies.usd,
                    eurToInr = response.currencies.eur,
                    aedToInr = response.currencies.aed
                )
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
    fun refreshData() {
        fetchPrices() // Reuse the fetchPrices logic for refreshing
    }
}

sealed class UiState {
    object Loading : UiState()
    data class Success(val metals: Metals,
                       val usdToInr: Double,
                       val eurToInr: Double,
                       val aedToInr: Double
    ) : UiState()
    data class Error(val message: String) : UiState()

}