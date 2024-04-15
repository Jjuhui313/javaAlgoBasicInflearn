package algo01_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-07 회문 문자열
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {

    //첫 번째 방법 : StringBuilder의 메서드 사용하여 풀이한 방법
    public static String solution1(String s) {
        String answer = "NO";
        s = s.toUpperCase();
        String str = new StringBuilder(s).reverse().toString();

        if (s.equals(str)) {
            answer = "YES";
        }

        return answer;
    }

    //두 번째 방법 : 문자열 절반까지만 탐색해 짝지어 비교하는 방법
    public static String solution2(String s) {
        String answer = "YES";
        s = s.toUpperCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                answer = "NO";
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution1(s));
        System.out.println(solution2(s));

    }
}
