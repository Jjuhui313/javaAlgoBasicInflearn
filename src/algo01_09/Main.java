package algo01_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-09 숫자만 추출
 *
 * 3가지 방법으로 풀어보기
 * */
public class Main {
    public static int solution1(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = s.toCharArray();
        boolean isFirstZero = true;
        for (char c : cArr) {
            if (c >= '0' && c <= '9') {
                if (c != '0') {
                    isFirstZero = false;
                }
                if (!isFirstZero) {
                    sb.append(c);
                }
            }
        }

        return Integer.parseInt(String.valueOf(sb));
    }

    public static int solution2(String s) {
        String answer = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) answer += c;
        }
        return Integer.parseInt(answer);
    }

    public static int solution3(String s) {
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c >= 48 && c <= 57) answer = answer * 10 + (c - 48);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputS = br.readLine();
        System.out.println(solution1(inputS));
        System.out.println(solution2(inputS));
        System.out.println(solution3(inputS));
    }
}
