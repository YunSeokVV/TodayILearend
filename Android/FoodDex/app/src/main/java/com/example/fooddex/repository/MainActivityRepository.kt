package com.example.fooddex.repository

import androidx.annotation.WorkerThread
import com.example.fooddex.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface MainActivityRepository {
    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<List<Pokemon>>
}