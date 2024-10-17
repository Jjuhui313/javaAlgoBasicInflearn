package algo07_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 07-01 재귀함수
 *
 * 재귀함수 풀어보기
 * */

public class Main {
    public static void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n);
    }
}
