package AlgorithsmExample;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int inputTime = 0;
        int answer = 1;
        int [] block;
        int comparison = 0;
        Scanner in = new Scanner(System.in);
        inputTime = in.nextInt();
        block = new int[inputTime];
        for(int i=0; i<inputTime; i++){
            block[i] = in.nextInt();
        }
        comparison = block[inputTime-1];
        for(int i=block.length-1; i>=0; i--){
            if(block[i] > comparison){
                answer++;
                comparison = block[i];
            }
        }
        System.out.println(answer);
    }
}
