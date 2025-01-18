package org.example.section3.code1

//runBlocking의 동작과 반환값
//runBlocking의 역할:
//코루틴 빌더 중 하나로, 코루틴을 시작하고 해당 코루틴이 완료될 때까지 현재 스레드를 차단합니다.
//즉, runBlocking은 메인 스레드를 차단하며 내부의 코루틴 실행이 완료될 때까지 기다립니다.
//runBlocking의 반환값:
//마지막 표현식의 결과값을 반환합니다.
//예제에서 runBlocking의 본문에 launch가 있지만, launch는 결과를 반환하지 않는 함수입니다. 따라서 runBlocking의 반환값은 Unit이 됩니다.

import kotlinx.coroutines.*
val singleThreadDispatcher : CoroutineDispatcher = newSingleThreadContext("SingleThread")
fun main() = runBlocking<Unit> {
    launch(singleThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}