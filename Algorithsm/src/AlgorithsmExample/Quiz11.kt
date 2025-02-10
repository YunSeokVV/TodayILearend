package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/120817
class Quiz11{
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0

        numbers.forEach { number ->
            answer = answer + number
        }

        answer = answer / numbers.size
        return answer
    }
}

fun main() {
    val test1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val quiz11 = Quiz11()
    quiz11.solution(test1)
}