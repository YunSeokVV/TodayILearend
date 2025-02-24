package org.example.section8

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch(Dispatchers.IO) {
        val dbResultsDeferred : List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async {
                delay(1000L)
                println("${it}로 부터 데이터를 가져오는데 성공")
                return@async "[${it}data"
            }
        }
        val dbResults : List<String> = dbResultsDeferred.awaitAll() // 모든 코루틴이 완료될때까지 대기

        println(dbResults)
    }
    parentJob.cancel()  // 부모 코루틴에 취소 요청
}