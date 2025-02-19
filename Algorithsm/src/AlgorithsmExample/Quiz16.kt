package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/181920?language=kotlin
class Quiz16 {
    fun solution(start_num: Int, end_num: Int): IntArray {
        val idx = end_num - start_num +1
        var answer: IntArray = IntArray(idx)
        var start = start_num
        for(i in 0 until idx) {
            answer[i] = start
            start++
        }
        return answer
    }
}

fun main(){
    val quiz16 = Quiz16()
    quiz16.solution(3, 10)
}