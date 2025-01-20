package AlgorithsmExample
// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/120912
class Quiz4 {
    fun solution(array: IntArray): Int {
        var answer: Int = 0

        array.forEach { it ->
            val str = it.toString()
            val splitedChar = str.toCharArray()

            for(char in splitedChar){
             if(char == '7') {
                 answer += 1
             }
            }
        }

        println(answer)
        return answer
    }
}

fun main() {
    val array = intArrayOf(7, 77, 17)
    val solution = Quiz4()
    solution.solution(array)


}