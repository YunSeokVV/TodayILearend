package org.example.section4.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    val updateTokenJob = launch(Dispatchers.IO) {
        println("토큰 업데이트 시작 ${Thread.currentThread().name}")
        delay(100)
        println("토큰 업데이트 완료 ${Thread.currentThread().name} \n 이 시점부터 네트워크 작업이 시작되야함")
    }
    // netWorkCallJob 실행전 upDateTokenJob.join 실행.
    updateTokenJob.join()

    val netWorkCallJob = launch(Dispatchers.IO) {
        println("서브스레드에서 네트워크 작업 진행중 ${Thread.currentThread().name}")
    }



}