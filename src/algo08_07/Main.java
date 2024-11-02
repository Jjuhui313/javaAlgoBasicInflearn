package algo08_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-07 조합의 경우수(메모이제이션)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int[][] dy = new int[35][35];

    public static int dfs(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        System.out.println(dfs(N, R));

    }
}
