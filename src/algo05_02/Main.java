package algo05_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 05-02 괄호문자제거
 *
 * stack 사용해서 풀어보기
 * */

public class Main {
    public static String solution2(String s) {
        String answer = "";
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (st.pop() != '(');
            }
            else st.push(c);
        }

        for (int i = 0; i < st.size(); i++) {
            answer += st.get(i);
        }
        return answer;
    }
    public static StringBuilder solution1(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (st.isEmpty()) {
                    continue;
                }
                while (true) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }

        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution1(s));
        System.out.println(solution2(s));
    }
}
