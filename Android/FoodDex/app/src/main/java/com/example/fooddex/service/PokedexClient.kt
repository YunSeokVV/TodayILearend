package com.example.fooddex.service

import com.example.fooddex.model.PokemonResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class PokedexClient @Inject constructor(
    private val pokedexService: PokedexService
) {
    suspend fun fetchPokemonList(page : Int) : ApiResponse<PokemonResponse> =
        pokedexService.fetchPokemonList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )

    companion object {
        private const val PAGING_SIZE = 20
    }
}