package com.example.cryptoapp.models

data class Asset (
    val id: String,
    val name: String,
    val symbol:String,
    val price:String,
    val percentage:Double
)