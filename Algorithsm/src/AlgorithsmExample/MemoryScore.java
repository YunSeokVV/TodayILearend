package AlgorithsmExample;

import java.util.HashMap;

public class MemoryScore {
    public static void main(String[] args) {
      String testName1[] = {"may", "kein", "kain", "radi"};
      int yearning1[] = {5, 10, 1, 3};
      String photo1[][] = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

      String testName2[] = {"kali", "mari", "don"};
      int yearning2[] = {11, 1, 55};
      String photo2[][] = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

      String testName3[] = {"may", "kein", "kain", "radi"};
      int yearning3[] = {5, 10, 1, 3};
      String photo3[][] = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

      MemoryScore memoryScore = new MemoryScore();
      memoryScore.solution(testName2, yearning2, photo2);
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> scores = new HashMap<>();
        for(int i = 0; i< name.length; i++){
            scores.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++){
                if(scores.get(photo[i][j]) != null){
                    sum = sum + scores.get(photo[i][j]);
                }
            }
            answer[i] = sum;

        }
        return answer;
    }
}
