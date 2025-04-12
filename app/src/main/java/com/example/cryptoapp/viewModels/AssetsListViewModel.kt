package com.example.cryptoapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.models.Asset
import com.example.cryptoapp.services.CoinCapApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AssetsListViewModel @Inject constructor(
    private val apiService: CoinCapApiService
): ViewModel(){
    //TOODO: ADD LOADING
    private val _assets= MutableStateFlow<List<Asset>>(emptyList())
    val assets:

}