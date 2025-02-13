package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
        // sleep 메소드는 블로킹 메소드다. delay 메소드를 주석처리하고 sleep메소드를 실행해보면 longJob의 로그가 계속 찍힌다. 그 이유는 sleep 메소드에는 코루틴의 중단 확인 시점이 존재하지 않기 때문이다.
        //sleep(1000)

        // 코루틴의 중단 확인 시점이 존재하는 메소드다.
        delay(1000)
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin()
    executeAfterJobCancelled2()
}

fun executeAfterJobCancelled2() {
    println("longJob 코루틴 취소 후 실행되야하는 동작")
}