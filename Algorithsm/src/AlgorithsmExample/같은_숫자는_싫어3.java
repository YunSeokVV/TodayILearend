package AlgorithsmExample;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
//같은 문제를 두번 풀었다. 그렇게 어려운 문제가 아니니까 굳이 자료구조를 써야하나? 하는 생각이 들었다. 스택/큐 문제니까 그걸 써야하는건데...
//주변 지인들에게 들은 코딩테스트 공부에서 중요한 꿀팁은..
// 1. 다 풀고나서 다른 사람의 풀이를 꼭 보라고 했다.
// 2. 면접자리면 자료구조 모르냐고 대차게 까인다니까 반드시 활용해라고 한다.

// 다음부터는.. 출제의 의도대로 제대로 자료구조를 활용해서 풀어보자. 이렇게 야매로 푸는건 오늘이 마지막인걸로 합세.
// (물론 못풀겠으면 자료구조 안쓰더라도 일단 답이라도 구하고)
public class 같은_숫자는_싫어3 {
    public static void main(String[] args) {
        int[] answer = {1,1,3,3,0,1,1};
        int[] answer2 = {4,4,4,3,3};

        같은_숫자는_싫어3 ihateSameNumber = new 같은_숫자는_싫어3();
        ihateSameNumber.solution(answer2);
    }

    public ArrayList solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int tmp = arr[0];
        answer.add(tmp);
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != tmp){
                tmp = arr[i];
                answer.add(tmp);

            }
        }
        System.out.println(answer);

        return answer;
    }
}