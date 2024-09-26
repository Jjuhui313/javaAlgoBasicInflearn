package algo04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 04-02 아나그램
 *
 * HashMap 사용해서 두 가지 방법으로 풀어보기
 * */

public class Main {
    public static String solution2(String w1, String w2) {
        String answer = "YES";
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : w1.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (char c : w2. toCharArray()) {
            if (!hm.containsKey(c) || hm.get(c) == 0) {
                return "NO";
            }
            hm.put(c, hm.get(c) - 1);
        }
        return answer;
    }
    public static String solution1(String w1, String w2) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : w1.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (char c : w2.toCharArray()) {
            if(hm.getOrDefault(c, 0) == 0) {
                return "NO";
            }
            hm.put(c, hm.get(c) - 1);
        }

        for (Integer value : hm.values()) {
            if (value != 0) {
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        System.out.println(solution1(word1, word2));
        System.out.println(solution2(word1, word2));
    }
}
