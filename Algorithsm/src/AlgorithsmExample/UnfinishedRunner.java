package AlgorithsmExample;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 완주하지 못한 선수
//https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
//동명이인응로 중복되는 데이터를 걸러내야 한다는 생각을 전혀하지 못했다. 아래 세개의 테스트 케이스에서는 그것을 감안하지 않아도 됐지만 같은 이름의 사람이 세명이상인 시점부터 내가 처음 짰던 로직은 망가진다.
//아래 링크를 많이 참고했다.
//https://coding-grandpa.tistory.com/76

public class UnfinishedRunner {
    public static void main(String[] args) {
        String[] participantArray1 = {"leo", "kiki", "eden"};
        String[] completionArray1 = {"leo", "kiki", "eden"};
        String[] participantArray2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completionArray2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participantArray3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completionArray3 = {"stanko", "ana", "mislav"};


        UnfinishedRunner unfinishedRunner = new UnfinishedRunner();
        unfinishedRunner.solution(participantArray3, completionArray3);

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participants = new HashMap<String, Integer>();
        for(int i =0; i<participant.length; i++){
            participants.put(participant[i], participants.getOrDefault(participant[i], 0) + 1);
        }

        for(String runner : completion){
           participants.put(runner, participants.get(runner)-1);
        }

        Iterator<Map.Entry<String, Integer>> iter = participants.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

}
