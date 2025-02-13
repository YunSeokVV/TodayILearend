package org.example.section4.code4

import kotlinx.coroutines.*
fun main() = runBlocking<Unit> {
    val longJob : Job = launch(Dispatchers.Default) {
        Thread.sleep(1000)  // sleep은 blocking 메소드임. 코루틴의 일시 중단 시점이 존재하지 않는다.
        println("longJob 코루틴의 동작")
    }

    longJob.cancel()
    callAfterCancelCoroutine()
}

fun callAfterCancelCoroutine() {
    println("이 로그는 코루틴이 실행 취소되고나서 보여야함")
}