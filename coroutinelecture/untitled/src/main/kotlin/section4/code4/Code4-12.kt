package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin()
    executeAfterJobCancelled()
}

fun executeAfterJobCancelled() {
    println("longJob 코루틴 이후에 실행되야하는 메소드임")
}