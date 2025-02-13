package org.example.section4.code4

import kotlinx.coroutines.*
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob : Job = launch(start = CoroutineStart.LAZY) {
        println("${getElapsedTime(startTime)}밀리초. launch 코루틴 지연 실행")
    }
    delay(3000L)
    lazyJob.start() // 결과 : wlsks tlrks : 3012 밀리초밀리초. launch 코루틴 지연 실행
}

fun getElapsedTime(startTime : Long) : String = "wlsks tlrks : ${System.currentTimeMillis() - startTime} 밀리초"