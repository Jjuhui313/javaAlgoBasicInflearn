package algo07_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 07-02 재귀함수를 이용한 이진수 출력
 *
 * 재귀함수를 활용하여 입력받은 십진수를 이진수로 변환하는 문제 풀어보기
 * */

public class Main {
    public static void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n / 2);
        System.out.print(n % 2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n);
    }
}
