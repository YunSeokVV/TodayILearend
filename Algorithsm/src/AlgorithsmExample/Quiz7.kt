package AlgorithsmExample

//https://school.programmers.co.kr/learn/courses/30/lessons/159994
// 스스로 해결하지 못한 문제.
class Quiz7 {
    // 내가 풀었던 풀이. (당연히 틀렸다.)
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var idx1 = 0
        var idx2 = 0

        for(item in goal) {
            if(idx1 < cards1.size && cards1[idx1] == item) {
                idx1++
            } else if(idx2 < cards2.size && cards2[idx2] == item) {
                idx2++
            } else {
                return "No"
            }
        }
        return "Yes"
    }

    fun gptSolution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var index1 = 0 // cards1의 현재 위치
        var index2 = 0 // cards2의 현재 위치

        // goal의 각 단어를 순서대로 확인
        for (word in goal) {
            if (index1 < cards1.size && cards1[index1] == word) {
                // cards1에서 현재 단어를 사용
                index1++
            } else if (index2 < cards2.size && cards2[index2] == word) {
                // cards2에서 현재 단어를 사용
                index2++
            } else {
                // cards1이나 cards2에서 단어를 찾을 수 없음
                return "No"
            }
        }
        return "Yes"
    }


}

fun main() {
    val quiz = Quiz7()
    val cards1: ArrayList<String> = arrayListOf("i", "drink", "water")
    val cards2: ArrayList<String> = arrayListOf("want", "to")
    val goal: Array<String> = arrayOf("i", "want", "to", "drink", "water")

//    quiz.solution(cards1, cards2, goal)
}