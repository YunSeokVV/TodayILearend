package com.example.fooddex.model
import com.squareup.moshi.Json
data class Pokemon(
    var page: Int = 0,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url") val url: String,
)