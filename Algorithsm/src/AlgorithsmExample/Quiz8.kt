package AlgorithsmExample
//https://school.programmers.co.kr/learn/courses/30/lessons/120888
class Quiz8 {
    fun solution(my_string: String): String {
        var answer: String = ""
        var isDuplicateArray = CharArray(my_string.length)

        for (i in my_string.indices) {
            var isDuplicate = false
            for (j in isDuplicateArray.indices) {
                if (my_string[i] == isDuplicateArray[j]) {
                    isDuplicate = true
                    break
                }
            }

            if (!isDuplicate) {
                isDuplicateArray[i] = my_string[i]
                answer += my_string[i]
            }
        }

        return answer
    }
}

fun main() {
    val quiz8 = Quiz8()
    quiz8.solution("people")

}