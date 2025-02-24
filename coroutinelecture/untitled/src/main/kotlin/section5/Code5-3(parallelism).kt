package org.example.section5

import kotlinx.coroutines.*
// 우리가 웹툰앱을 만든다고 생각해보자. 검정고무신, 짱구, 진격의 거인, 톰과제리 이 네개의 만화의 썸네일을 다운받아서 화면에 표시해야 한다.
//이런 경우는 값을 순차적으로 받아야할 필요가 없다. 병렬적으로 전부 다운을 요청하고 되는대로 받아온뒤에 앱에서 썸네일로 보여주면 된다.
fun main() = runBlocking<Unit> {
    val blackShoesDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "검정 고무신"
    }

    val zzangGUDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "짱구"
    }

    val attackOnTitanDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "진격의 거인"
    }

    val tomAndJerryDeferred : Deferred<String> = async(Dispatchers.IO) {
        delay(1000)
        return@async "톰과제리"
    }

    val result1 = blackShoesDeferred.await()
    val result2 = zzangGUDeferred.await()
    val result3 = attackOnTitanDeferred.await()
    val result4 = tomAndJerryDeferred.await()

    println("result1 = $result1")
    println("result2 = $result2")
    println("result3 = $result3")
    println("result4 = $result4")

    // 반드시 위의 방식을 써야 할 필요는 없다. 코루틴에서는 모든 응답값을 한번에 편하게 받으라고 awaitAll() 메소드를 제공해준다.
    val allResult : List<String> = awaitAll(blackShoesDeferred, zzangGUDeferred, attackOnTitanDeferred, tomAndJerryDeferred)

    allResult.forEach { result ->
        print("${result} ")
    }
}