package AlgorithsmExample
// https://school.programmers.co.kr/learn/courses/30/lessons/120831
class Quiz12 {
    fun solution(n: Int): Int {
        var answer: Int = 0

        for(i in 0..n) {
            if(i%2 == 0) {
                answer = answer + i
            }
        }

        return answer
    }
}