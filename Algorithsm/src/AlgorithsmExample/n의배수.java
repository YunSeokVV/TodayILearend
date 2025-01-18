package AlgorithsmExample;

import java.util.ArrayList;
public class n의배수 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/120905
    //더 나은 해결책 https://school.programmers.co.kr/learn/courses/30/lessons/120905/solution_groups?language=java
    public static int[] solution(int n, int[] numlist) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] answer;

        for(int i = 0; i< numlist.length; i++) {
            if(numlist[i]%n == 0) {
                result.add(numlist[i]);
            }
        }

        answer = new int[result.size()];

        for(int i= 0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] numList2 = {1, 9, 3, 10, 13, 5};
        int[] numList3 = {2, 100, 120, 600, 12, 12};
        //int[] result = solution(3, numlist);
        int[] result = solution(5, numList2);
        //int[] result = solution(12, numList3);

        for(int i =0; i< result.length; i++) {
            System.out.print(result[i]+" ");
        }

    }

}
