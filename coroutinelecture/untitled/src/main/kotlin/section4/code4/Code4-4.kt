package org.example.section4.code4
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {

    // 작업이 오래 걸리는고 스레드가 오랜기간 자원을 점유해야 하는 경우는 Default 를 사용해야 한다.ex. 아래와 같은 이미지 변환작업시.
    val convertImgJob : Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("${Thread.currentThread().name} 1번 이미지 변환 작업 완")
    }

    val convertImgJob2 : Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("${Thread.currentThread().name} 2번 이미지 변환 작업 완")
    }

    convertImgJob.join()
    convertImgJob2.join()

    val updateImageJob : Job = launch(Dispatchers.IO) {
        println("${Thread.currentThread().name} 1번, 2번 이미지 업로드 완료")
    }

}