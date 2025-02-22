package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/181931
class Quiz17 {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        var currentNum = a
        included.forEach { it ->
            if(it){
                answer += currentNum
            }
            currentNum += d
        }
        return answer
    }

    fun solution2(a: Int, d: Int, included: BooleanArray) = included.indices.filter {
        included[it] }.sumOf { a + d * it }

}

fun main() {
    val quiz17 = Quiz17()
    val included = booleanArrayOf(true, false, false, true, true)
    quiz17.solution(3, 4, included)
}