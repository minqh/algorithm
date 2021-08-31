package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class level1 {
    public static void main(String[] args) {
        String[] participant = {"a", "a", "a", "b", "c", "d"};
        String[] completion = {"a", "a", "c", "b", "d"};
        System.out.println(solution(participant, completion));
        System.out.println(solution2(participant, completion));
    }

    /*
    테스트 1 〉	통과 (36.80ms, 81.1MB)
    테스트 2 〉	통과 (70.24ms, 88.2MB)
    테스트 3 〉	통과 (89.20ms, 96.6MB)
    테스트 4 〉	통과 (76.03ms, 98MB)
    테스트 5 〉	통과 (78.05ms, 95.1MB)*/
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(String part : participant) map.put(part, map.getOrDefault(part, 0) + 1);
        for(String comp : completion) map.put(comp, map.get(comp)-1);
        for(String part : participant) {
            if(map.get(part) > 0) {
                answer = part;
                break;
            }
        }
        return answer;
    }

    /*
    테스트 1 〉	통과 (145.97ms, 81.6MB)
    테스트 2 〉	통과 (210.05ms, 89.1MB)
    테스트 3 〉	통과 (371.34ms, 93.6MB)
    테스트 4 〉	통과 (292.75ms, 95.4MB)
    테스트 5 〉	통과 (289.83ms, 95.6MB)*/
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i = 0; i < participant.length-1; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return answer;
    }
}
