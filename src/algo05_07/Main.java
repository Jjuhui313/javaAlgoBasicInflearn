package algo05_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 05-07 교육과정 설계
 *
 * Queue 사용해서 풀어보기
 * */

public class Main {
    public static String solution1(String sub, String s) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        for (char c : sub.toCharArray()) {
            q.offer(c);
        }

        for (char c : s.toCharArray()) {
            if (q.contains(c)) {
                if (q.peek() == c) {
                    q.poll();
                } else {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sub = br.readLine();
        String s = br.readLine();

        System.out.println(solution1(sub, s));
    }
}
