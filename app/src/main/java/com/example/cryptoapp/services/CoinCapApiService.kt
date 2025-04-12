package com.example.cryptoapp.services

import com.example.cryptoapp.models.Asset
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class CoinCapApiService @Inject constructor(
    private val client: HttpClient
){
    suspend fun getAssets(): List<Asset>{
        val response: HttpResponse=client.get (urlString = "")
        return response.body()
    }

}