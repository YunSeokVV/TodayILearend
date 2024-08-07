package AlgorithsmExample;

import java.util.ArrayList;
import java.util.Stack;

public class 같은_숫자는_싫어2 {
    public static void main(String[] args) {
        int[] answer = {1, 1, 3, 3, 0, 1, 1};
        int[] answer2 = {4, 4, 4, 3, 3};

        같은_숫자는_싫어2 ihateSameNumber = new 같은_숫자는_싫어2();
        ihateSameNumber.solution(answer);
    }

    public ArrayList solution(int[] arr) {
        ArrayList<Integer> answer2 = new ArrayList<>();
        Stack<Integer> stackInt = new Stack<>();

        for (int i = arr.length - 1; i>=0; i--) {
            stackInt.push(arr[i]);
        }

        int tmp = stackInt.peek();
        answer2.add(tmp);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == tmp){

            } else {
                answer2.add(arr[i]);
                tmp = arr[i];
            }
        }
        return answer2;
    }
}
