package algo05_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 05-05 쇠막대기
 *
 * stack 사용해서 풀어보기
 * */

public class Main {
    public static int solution1(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')'){
                char before = s.charAt(i - 1);
                st.pop();
                if (before == '(') {
                    answer += st.size();
                } else if (before == ')') {
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        System.out.println(solution1(S));
    }
}
