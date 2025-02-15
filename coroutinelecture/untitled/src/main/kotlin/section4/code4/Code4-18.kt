package org.example.section4.code4

import kotlinx.coroutines.*


fun main() = runBlocking<Unit> {
    val job : Job = launch {
        delay(1000L)
    }

    // toString 메소드로 job의 상태값을 확인하면 JobSupport 객체에서 디버깅 용도로 만드는 문자열(toDebugString())을 사용하는 것이라서 직접 코드에서 사용하기는 어렵다.
    println(job)
    printJobState(job)
}

fun printJobState(job: Job) {
    println(
        "Job State \n" +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted}\n"
    )
}