package algo05_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 05-04 후위식 연산(postfix)
 *
 * stack 사용해서 후위연산식 풀어보기
 * */

public class Main {
    public static int solution1(String s) {
        Stack<Integer> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                st.push(c - '0');
            } else {
                int a = st.pop();
                int b = st.pop();
                if (c == '+') {
                    st.push(b + a);
                } else if (c == '-') {
                    st.push(b - a);
                } else if (c == '*') {
                    st.push(b * a);
                } else {
                    st.push(b / a);
                }
            }
        }
        return st.pop();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        System.out.println(solution1(S));
    }
}
