package algo01_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-06 중복 문자 제거
 *
 * 2가지 방법으로 풀어보기
 * */
public class Main {

    //첫 번째 방법 : contains() 메서드를 이용한 방법
    public static StringBuilder solution1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!sb.toString().contains(String.valueOf(c))) {
                sb.append(c);
            }
        }
        sb.append("\n");
        return sb;
    }

    //두 번째 방법 : indexOf() 메서드를 이용한 방법
    public static StringBuilder solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i) {
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution1(s));
        System.out.println(solution2(s));
    }
}
