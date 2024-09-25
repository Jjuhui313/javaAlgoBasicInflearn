package algo04_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 04-01 학급 회장
 *
 * HashMap 사용해서 풀어보기!
 * */

public class Main {
    public static char solution1(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char key : hm.keySet()) {
            if (max < hm.get(key)) {
                max = hm.get(key);
                answer = key;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        System.out.println(solution1(N, S));
    }
}
