package algo01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 01-05 특정 문자 뒤집기
 *
 * Character.isAlphabetic() 사용하지 않고 풀어보기
* */
public class Main {

    public static StringBuilder solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = s.toCharArray();
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            if (!((s.charAt(front) >= 'A' && s.charAt(front) <= 'Z') || (s.charAt(front) >= 'a' && s.charAt(front) <= 'z'))) {
                front++;
            } else  if (!((s.charAt(back) >= 'A' && s.charAt(back) <= 'Z') || (s.charAt(back) >= 'a' && s.charAt(back) <= 'z'))) {
                back--;
            } else {
                char temp = cArr[front];
                cArr[front] = cArr[back];
                cArr[back] = temp;
                front++;
                back--;
            }
        }
        for (char c : cArr) {
            sb.append(c);
        }
        sb.append("\n");

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
