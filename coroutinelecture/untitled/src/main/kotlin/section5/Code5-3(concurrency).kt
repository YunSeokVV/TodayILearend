package org.example.section5

import kotlinx.coroutines.*

// 일을 순차적으로 처리해야 하는 경우도 있다. 이럴때 동시성을 이용해 문제를 해결하면 된다.
//가끔 양식 레스토랑에 가서 코스요리를 먹어본적이 있을 것이다. 보통 아래와 같은 순서로 음식이 나온다.
//에피타이저(빵, 스프) -> 샐러드 -> 생선요리 -> 스테이크 -> 후식(아이스크림, 커피 등)
fun main() = runBlocking<Unit> {
    val appetiteDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "검정 고무신"
    }
    val result1 = appetiteDeferred.await()

    val saladDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "짱구"
    }
    val result2 = saladDeferred.await()

    val fishCookDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "진격의 거인"
    }
    val result3 = fishCookDeferred.await()

    val steakDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "톰과제리"
    }
    val result4 = steakDeferred.await()

    println("result1 = $result1")
    println("result2 = $result2")
    println("result3 = $result3")
    println("result4 = $result4")
}