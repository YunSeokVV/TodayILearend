package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=kotlin
// jointToString() 함수를 배우는 좋은 계기가 됐다. 리스트안의 모든 값들을 이어 붙여서 문자열로 만들어주는 역할을 하는 메소드다.
class Quiz15 {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        // 홀수
        var oddSumList = mutableListOf<Int>()

        // 짝수
        var evenSumList = mutableListOf<Int>()

        num_list.forEach { num ->
            if(num % 2 == 0){
                // 짝수
                evenSumList.add(num)
            } else {
                // 홀수
                oddSumList.add(num)
            }
        }

        // 문자열을 정수로 변환
        val oddInt = oddSumList.joinToString("").toInt()
        val evenInt = evenSumList.joinToString("").toInt()
        answer = oddInt + evenInt
        return answer
    }
}

fun main(){
    val testData = intArrayOf(3, 4, 5, 2, 1)
    val quiz15 = Quiz15()
    quiz15.solution(testData)
}