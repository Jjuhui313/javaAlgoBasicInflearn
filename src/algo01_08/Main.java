package algo01_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-08 유효한 팰린드롬
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    //첫 번째 방법 : 절반까지 탐색해 짝지어 비교하는 방법
    public static String solution1(String s) {
        String answer = "YES";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toUpperCase().toCharArray();
        for (char c : arr) {
            if ((c >= 'A' && c <= 'Z')) {
                sb.append(c);
            }
        }

        String str = sb.toString();
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(str.length() - i - 1))) {
                answer = "NO";
            }
        }

        return answer;
    }

    //두 번째 방법 : replaceAll()과 정규식 사용하여 equals로 비교하는 방법
    public static String solution2(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String str = new StringBuilder(s).reverse().toString();
        if (s.equals(str)) {
            answer = "YES";
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
