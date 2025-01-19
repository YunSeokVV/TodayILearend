package AlgorithsmExample

class Quiz3 {
    fun solution(a: Int, b: Int, c: Int): Int {
        var answer: Int = 0

        if(a!=b && b !=c && c!=a) {
            // 세 숫자가 모두 다르면
            answer = a+b+c
        } else if((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
            // 세 숫자 중 어느 두 숫자는 같고 나머지는 다른 숫자는 다르다면
            answer = (a+b+c)*(((a*a) + (b*b) + (c*c)))
        } else if(a==b && b==c && b==c) {
            // 세 숫자가 모두 같을떄
            answer = (a+b+c) * (((a*a) + (b*b) + (c*c))) * (((a*a*a) + (b*b*b) + (c*c*c)))
        }

        return answer
    }
}

fun main() {
    // 배열선언
    val arr = intArrayOf(0,1,2,3,4)

    // 이중배열
    val queries = arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,2),
        intArrayOf(2,3))

    val solution = Quiz2()
    solution.solution(arr, queries)


}