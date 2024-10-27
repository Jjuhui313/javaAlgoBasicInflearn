package algo08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-02 바둑이 승차(DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int C, N = 0;
    public static int max = Integer.MIN_VALUE;

    public static void dfs(int L, int sum, int[] arr) {
        if (sum > C) return;
        if (L == N) {
            max = Math.max(max, sum);
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, arr);
        System.out.println(max);
    }
}
