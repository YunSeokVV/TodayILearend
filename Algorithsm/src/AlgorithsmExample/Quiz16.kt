package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/120821
class Quiz16 {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = IntArray(num_list.size)
        var idx = num_list.size -1
        for(i in 0 until num_list.size) {
            answer[i] = num_list[idx]
            idx--
        }
        return answer
    }

    // 더 나은 방법으로 reversedArray 를 쓰는 방법도 있다.
    fun solution2(num_list: IntArray): IntArray = num_list.reversedArray()

}

fun main() {
    val quiz = Quiz16()
    val testData = intArrayOf(1,2,3,4,5)
    val result = quiz.solution(testData)
    result.forEach {
        println(it)
    }
}