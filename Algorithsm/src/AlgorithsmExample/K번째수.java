package AlgorithsmExample;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
//https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {
    public static void main(String[] args) {

        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands ={{2,5,3}, {4,4,1}, {1,7,3}};

        K번째수 k = new K번째수();
        int[] reesult = k.solution(array, commands);
        System.out.println(reesult);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){

            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];


            start = start -1;
            end = end -1;
            List<Integer> tmp = new ArrayList<>();
            for(int x = 0; x < array.length; x++){
                if(x >= start && x <= end){
                    tmp.add(array[x]);
                }
            }
            Collections.sort(tmp);
            answer[i] = tmp.get(idx-1);
        }
        return answer;
    }

}
