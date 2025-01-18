package AlgorithsmExample

// 머쓱이보다 키 큰 사람
// https://school.programmers.co.kr/learn/courses/30/lessons/120585
class Quiz1 {
    fun solution(array: IntArray, height: Int): Int {
        var answer: Int = 0
        for(item in array) {
            if(height < item) {
                answer++
            }
        }
        return answer
    }
}

fun main() {
    val array: IntArray = intArrayOf(149, 180, 192, 170)
    val quiz1 = Quiz1()
    quiz1.solution(array, 167)
}