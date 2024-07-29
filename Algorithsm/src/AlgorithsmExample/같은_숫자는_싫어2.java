package AlgorithsmExample;

import java.util.Stack;

public class 같은_숫자는_싫어2 {
    public static void main(String[] args) {
        int[] answer = {1,1,3,3,0,1,1};
        int[] answer2 = {4,4,4,3,3};

        같은_숫자는_싫어2 ihateSameNumber = new 같은_숫자는_싫어2();
        ihateSameNumber.solution(answer2);
    }

    public int[] solution(int []arr) {
        int[] answer = arr;
        Stack<Integer> stackInt = new Stack<>();

        for(int i=answer.length-1;i>=0;i--){
            stackInt.push(answer[i]);
        }

        for(int i=0;i<stackInt.size();i++){
            if(stackInt.get(i) == stackInt.get(i+1)){
                stackInt.pop();
            }
        }

        System.out.print("stack"+stackInt +" ");

        return answer;
    }
}
