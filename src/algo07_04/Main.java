package algo07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 07-04 피보나치 재귀(메모이제이션)
 *
 * 메모리제이션 활용하여 피보나치 수열 문제 풀어보기
 * */

public class Main {
    public static int[] fibo;
    public static int dfs(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = dfs(n - 2) + dfs(n - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];
        dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
