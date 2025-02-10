package AlgorithsmExample

// https://school.programmers.co.kr/learn/courses/30/lessons/120830
class Quiz10 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val totalLamb = 12000 * n
        val totalBevarge = 2000 * k
        val bonus = n / 10
        answer = totalLamb + totalBevarge
        answer = answer - bonus * 2000
        return answer
    }
}

fun main() {
    val quiz10 = Quiz10()
    quiz10.solution(10, 3)

}