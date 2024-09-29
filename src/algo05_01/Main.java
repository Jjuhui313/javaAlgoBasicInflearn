package algo05_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 05-01 올바른 괄호
 *
 * stack 사용해서 풀어보기
 * */

public class Main {
    public static String solution1(String s) {
        String answer = "NO";
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (st.isEmpty()) {
                    return "NO";
                }
                st.pop();
            } else {
                st.push(c);
            }
        }

        if (st.isEmpty()) {
            return "YES";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution1(s));
    }
}
