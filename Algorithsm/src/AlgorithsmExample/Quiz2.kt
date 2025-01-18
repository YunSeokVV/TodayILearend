package AlgorithsmExample

class Quiz2 {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for(i in queries.indices ) {
            val query = queries[i]
            for(j in query.indices) {
                val value = query[j]
                print(j)
                arr[j] = value + 1
            }
        }

        // 배열 출력문
        arr.forEach {
            print(" ${it}")
        }

        return arr
    }

    fun gptSolution(arr: IntArray, queries: Array<IntArray>): IntArray {
        // 각 query에 대해 처리
        for (query in queries) {
            val (start, end) = query // 범위 가져오기
            for (i in start..end) { // 해당 범위의 요소를 1씩 증가
                arr[i] += 1
            }
        }
        return arr
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