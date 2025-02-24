package org.example.section7

import kotlinx.coroutines.*

fun main() {
    val coroutineName : CoroutineName = CoroutineName("Coroutine name")

    val dispatcher : CoroutineDispatcher = Dispatchers.IO

    val job : Job = Job()

    val coroutineExceptionHandler = CoroutineExceptionHandler (
        handler = { coroutineContext, throwable ->
            // 예외처리
        }
    )

}