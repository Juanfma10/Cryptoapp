package com.example.cryptoapp.models

import kotlinx.serialization.Serializable

@Serializable
data class AssetResponse (
    val data: List<Asset>
)