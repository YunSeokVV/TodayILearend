package AlgorithsmExample;

import java.util.Scanner;

// https://www.acmicpc.net/problem/17608
// 백준에서 풀게된 스택관련문제다. 근데 나는 스택을 안쓰고 풀었다. 스택을 어떻게 활용해야지 이 문제를 쉽게 풀 수 있는지 잘 모르겠다.
//문제 해결까지 걸린 시간 : 54분

//==내가 생각한 알고리즘==
//1. n개의 볼록 개수를 입력한다.
//2. 사용자가 입력한 값을 배열total의 size 값으로 설정한다.
//3. 사용자가 입력한 값들을 total 배열안에 순서대로 담는다.
//4. 변수 comparison 에 배열의 마지막 idx 안의 값을 담는다.
//5. 배열을 뒤쪽에서 부터 검색을 시작한다.
//6. 만약 i번째 idx안의 값이 comparison보다 크면 answer 값을 +1 시킨다. 그리고 변수 comparison i번째 idx값을 담는다.


public class Stick {
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
            //System.out.print(block[i]);
            if(block[i] > comparison){
                answer++;
                comparison = block[i];
            }
        }

        System.out.println(answer);
    }
}
