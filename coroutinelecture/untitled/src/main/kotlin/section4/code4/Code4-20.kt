package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job : Job = launch {
        delay(1000L)
    }
    // join 메소드를 실행하면 runBlocking 코루틴이 launch가 다 실행될때까지 일시중단. 이후 재게되서 로그 출력.
    job.join()  // launch 코루틴이 실행 안료될떄까지 일시중단
    println(job)
    printJobState(job)
}