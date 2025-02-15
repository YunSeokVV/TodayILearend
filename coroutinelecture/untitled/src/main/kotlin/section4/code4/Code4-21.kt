package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job : Job = launch {
        while (true) {
            // 작업이 실행중임
        }
    }
    job.cancel() // 코루틴 취소 요청. -> Cancelling 상태로 전환.
    println(job)
    printJobState(job)

    val job2 : Job = launch {
        while (true) {
            yield()
        }
    }

    job2.cancelAndJoin()
    println(job2)
    printJobState(job)
}