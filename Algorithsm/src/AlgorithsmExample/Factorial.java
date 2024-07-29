package AlgorithsmExample;
/*
    재귀함수를 공부하기 위해 만든 예제이다. 공부하는데 도움이 됐던 예제 사이트는 아래와 같다.
    https://marobiana.tistory.com/79
*/

public class Factorial {
    public static void main(String[] args) {

        int result = 0;
        Factorial factorial = new Factorial();
        result = factorial.factorial(4);
        System.out.println("result "+result);
    }

    public int factorial(int input){
        if(input <= 1){
            return 1;
        }

        return input * factorial(input-1);
    }

}
