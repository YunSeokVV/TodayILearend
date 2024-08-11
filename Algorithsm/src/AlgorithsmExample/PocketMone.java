package AlgorithsmExample;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
public class PocketMone {
    public static void main(String[] args) {
        PocketMone pocketMone = new PocketMone();
        int nums [] = {3,1,2,3};
        int nums2 [] = {3,3,3,2,2,4};
        int nums3 [] = {3,3,3,2,2,2};

        pocketMone.solution(nums);
    }

    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> sort = new HashMap<Integer, Integer>();

        for (int num : nums) {
            sort.put(num, sort.getOrDefault(num, 0) + 1);
        }

        if(sort.size() >= nums.length/2){
            answer = nums.length/2;
        } else{
            answer = sort.size();
        }
        return answer;
    }
}
