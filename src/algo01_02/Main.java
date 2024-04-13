package algo01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-02 대소문자 변환
 *
 * toUpperCase() / toLowerCase() / isUpperCase() / isLowerCase() 쓰지 않고 해결할 것
 * */

public class Main {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                answer.append(Character.toChars(c + 32));
            } else {
                answer.append(Character.toChars(c - 32));
            }
        }

        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
