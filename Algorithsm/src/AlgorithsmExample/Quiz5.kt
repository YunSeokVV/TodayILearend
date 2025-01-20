package AlgorithsmExample

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/120822
class Quiz5 {
    fun solution(my_string: String): String {
        var answer = StringBuilder()

        var splitedChar = my_string.toCharArray()

        for(i in my_string.length-1 downTo 0) {
            answer.append(splitedChar[i])
        }


        return answer.toString()
    }

    // 다른사람 풀이인데 확실히 내장함수 알고 모르고가 하늘과 땅차이인듯.
    //fun solution2(my_string: String): String = my_string.reversed()
}

fun main() {
    val str = "jaron"
    val solution = Quiz5()
    solution.solution(str)

}