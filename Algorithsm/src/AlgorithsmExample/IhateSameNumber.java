package AlgorithsmExample;

import java.util.ArrayList;
import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12906#
//2시간20분 걸린 문제. 입력값 두개만 통과하고 틀린걸로 나옴.
public class IhateSameNumber {
    ArrayList<Integer> delete_idx = new ArrayList<>();
    ArrayList<Integer> answerList = new ArrayList<>();


    public static void main(String[] args) {
        int[] answer = {1,1,3,3,0,1,1};
        int[] answer2 = {4,4,4,3,3};

        IhateSameNumber ihateSameNumber = new IhateSameNumber();
        ihateSameNumber.solution(answer2);
    }

    public int[] solution(int []arr) {
        int[] answer = arr;

        for(int i=0; i<answer.length;i++)
            answerList.add(answer[i]);

        for(int i=0; i<answer.length; i++){
//            if(i+1 == answer.length)
//                break;
            if(answer[i] == answer[i+1]){
                for(int j=i; j<answer.length; j++){
//                    System.out.println("i 값 "+i);
//                    System.out.println("j 값 "+j);
                    if(j+1 == answer.length)
                        break;
                    //서로 같은거
                    if(answer[j] == answer[j+1]){
                        System.out.println("answer["+j+"]");
                        delete_idx.add(j);
                    }
                }
            }
                if(i == 0)
                break;
        }

        System.out.println(answerList);


        for(int i=delete_idx.size()-1; i>=0; i--){
            System.out.println((int)delete_idx.get(i));
            answerList.remove((int)delete_idx.get(i));
        }

        //answerList.remove(0);
        System.out.println(answerList);
        //answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        int[] solution = new int[answerList.size()];
        for(int i=0; i<answerList.size();i++){
            solution[i] = answerList.get(i);
        }

        System.out.println("Hello Java "+solution);

        for(int i=0; i<solution.length;i++){
            System.out.println(solution[i]);
        }

        return solution;
    }
}
