package com.example.fooddex.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

// todo : 이 클래스가 어떤 역할을 하는건지 잘 모르겠다.
@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val pokedexAppDispatchers: PokedexAppDispatchers)

enum class PokedexAppDispatchers {
    IO,
}
