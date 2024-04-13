package algo01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 01-01 문자 찾기
*
* toUpperCase() / toLowerCase() 쓰지 않고 해결할 것
* */

public class Main {

    public static int solution(String s, char c) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch - 'A' == c - 'A') || (ch - 'A' == c - 'a') || (ch - 'a' == c - 'A') || (ch - 'a' == c - 'a')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = br.readLine().charAt(0);

        System.out.println(solution(s, c));
    }
}
