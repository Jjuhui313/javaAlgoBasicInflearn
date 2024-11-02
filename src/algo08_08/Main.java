package algo08_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-08 수열 추측하기
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, F;
    public static int[] b, p, check;
    public static boolean flag = false;
    public static int[][] dy = new int[35][35];

    public static int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public static void dfs(int L, int sum) {
        if (flag) return;
        if (L == N) {
            if (sum == F) {
                for (int i : p) {
                    System.out.print(i + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        b = new int[N];
        p = new int[N];
        check = new int[N + 1];
        for (int i = 0; i < N; i++) {
            b[i] = combi(N - 1, i);
        }
        dfs(0, 0);
    }
}
