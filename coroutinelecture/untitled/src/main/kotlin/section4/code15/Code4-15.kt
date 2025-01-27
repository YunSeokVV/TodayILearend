package org.example.section4.code15

import kotlinx.coroutines.*

fun main() = runBlocking <Unit>{
    val whileJob : Job = launch (Dispatchers.Default) {
        //while(true) {
        while (this.isActive) {
            println("작업중")
            //delay(1)
            yield()
        }
    }
    delay(100L)
    whileJob.cancel()
}