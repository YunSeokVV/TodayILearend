package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/120909
class Quiz13 {
    fun solution(n: Int): Int {
        var answer = 0

        val tmp = Math.sqrt(n.toDouble())
        if(tmp == tmp.toInt().toDouble()) {
            answer = 1
        } else {
            answer = 2
        }

        return answer
        }
    }

fun main() {
    val quiz = Quiz13()
    quiz.solution(144)
}