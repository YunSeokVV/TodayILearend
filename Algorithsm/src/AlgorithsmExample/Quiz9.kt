package AlgorithsmExample
//https://school.programmers.co.kr/learn/courses/30/lessons/120913
class Quiz9 {
    fun solution(my_str: String, n: Int): Array<String> {
        var length = 0
        length = my_str.length/n
        if(my_str.length % n > 0) {
            length++
        }
        var answer: Array<String> = Array<String>(length){""}

        var idx = 0
        for(i in 0 until my_str.length) {
            answer[idx] = answer[idx] + my_str.get(i)
            // n 의 배수일때만 조건문으로 솎아낸다
            if((i + 1) % n == 0) {
                // n의 배수이면 다음 배열에 저장해야됨
                idx++
            }
        }
        return answer
    }
}

fun main() {
    val my_str1 = "abc1Addfggg4556b"    // ["abc1Ad", "dfggg4", "556b"]
    val my_str2 = "abcdef123"

    val quiz9 = Quiz9()
    quiz9.solution(my_str2, 3)
}