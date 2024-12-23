package baekjoon;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class N1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArray = scanner.nextLine().toUpperCase().toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();

        for(Character alpha : charArray) {
            countMap.put(alpha, countMap.getOrDefault(alpha, 0) + 1);
        }

        char maxValue = '?';
        int maxCount = 0;
        boolean isDuplicate = false;

        for (Map.Entry<Character, Integer> count : countMap.entrySet()) {
            final Character key = count.getKey();
            final int value = count.getValue();
            if (maxCount < value) {
                maxValue = key;
                maxCount = value;
                isDuplicate = false;
            } else if (maxCount == value) {
                isDuplicate = true;
            }
        }

        System.out.println(isDuplicate ? "?" : maxValue);
    }
}
