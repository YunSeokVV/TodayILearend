package com.example.fooddex.repository

import androidx.annotation.WorkerThread
import com.example.fooddex.model.Pokemon
import com.example.fooddex.network.Dispatcher
import com.example.fooddex.network.PokedexAppDispatchers
import com.example.fooddex.service.PokedexClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainActivityRepositoryImpl @Inject constructor(
    private val pokedexClient: PokedexClient,
    @Dispatcher(PokedexAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
): MainActivityRepository {

    @WorkerThread
    override fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        //fetches a list of [Pokemon] from the network and getting [ApiResponse] asynchronously.
        val response = pokedexClient.fetchPokemonList(page = page)
        response.suspendOnSuccess {
            val pokemons = data.results
            pokemons.forEach { pokemon -> pokemon.page = page }
            //pokemonDao.insertPokemonList(pokemons.asEntity())
            //emit(pokemonDao.getAllPokemonList(page).asDomain())
            emit(pokemons)
        }.onFailure {
            onError(message())
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)
}