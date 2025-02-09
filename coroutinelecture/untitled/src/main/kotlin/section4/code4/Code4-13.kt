package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
        delay(1000)
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin()
    executeAfterJobCancelled2()
}

fun executeAfterJobCancelled2() {
    println("longJob 코루틴 취소 후 실행되야하는 동작")
}