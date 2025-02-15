package AlgorithsmExample

// https://school.programmers.co.kr/learn/courses/30/lessons/120909
// 스스로 해결하지 못한 문제
class Quiz14 {
    fun solution(A: String, B: String): Int {
        var aStr = A

        for (i in A.indices) {
            if (aStr == B) return i // 현재 문자열이 B와 같으면 회전 횟수 반환

            // 오른쪽으로 한 칸 회전
            aStr = aStr.last() + aStr.substring(0, aStr.length - 1)

            println("회전 $i: $aStr") // 디버깅용 출력
        }
        return -1 // 회전해도 만들 수 없는 경우
    }
}

fun main() {
    val quiz = Quiz14()
    quiz.solution("hello", "ohell")
}