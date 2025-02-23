package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/120845
class Quiz17 {
    fun solution(box: IntArray, n: Int): Int {
        var answer: Int = 0
        val result = IntArray(3)
        box.forEachIndexed { index, it ->
            result[index] = it / n
            println(index)
        }

        answer = result.reduce{acc, num -> acc * num}

        return answer
    }
}

fun main() {
    val quiz17 = Quiz17()
    val data = intArrayOf(10, 8, 6)
    val result = quiz17.solution(data, 3)
    println(result)
}