package org.example.section8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)
            println("[${getElapsedTime(startTime)} 자식 코루틴 실행 완료")
        }
        println("[${getElapsedTime(startTime)} 부모 코루틴이 실행하는 마지막 코드")
    }

    parentJob.invokeOnCompletion {  // 부모 코루틴이 완료될 시 호출되는 콜백 등록
        println("[${getElapsedTime(startTime)} 부모 코루틴이 실행완료")
    }

}
private fun getElapsedTime(startTime : Long) : String = "지난 시간 : ${System.currentTimeMillis()-startTime} ms"