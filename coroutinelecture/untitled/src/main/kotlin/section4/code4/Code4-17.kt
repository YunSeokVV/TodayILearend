package org.example.section4.code4

//import kotlinx.coroutines.*
//fun main() = runBlocking<Unit> {
//    val whileJob : Job = launch (Dispatchers.Default) {
//        while(this.isActive) {
//            println("작업 중")
//            yield()
//        }
//    }
//    delay(100L)
//    whileJob.cancel() // 코루틴 취소
//}