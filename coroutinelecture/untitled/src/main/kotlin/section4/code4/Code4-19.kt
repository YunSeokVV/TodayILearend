package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job : Job = launch (start = CoroutineStart.LAZY) {
        delay(1000L)
    }
    println(job)
    printJobState(job)
}