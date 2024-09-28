package com.example.fooddex.service

import com.example.fooddex.model.PokemonResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexService {

//    @GET("pokemon")
//    suspend fun fetchPokemonList(
//        @Query("limit") limit: Int = 20,
//        @Query("offset") offset: Int = 0,
//    ): ApiResponse<PokemonResponse>


    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): ApiResponse<PokemonResponse>

}