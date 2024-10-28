package algo08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-03 최대점수 구하기(DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M = 0;
    public static int max = Integer.MIN_VALUE;
    public static int[] time, point;

    public static void dfs(int L, int pSum, int tSum, int[] point, int[] time) {
        if (tSum > M) return;
        if (L == N) {
            max = Math.max(max, pSum);
        } else {
            dfs(L + 1, pSum + point[L], tSum + time[L], point, time);
            dfs(L + 1, pSum, tSum, point, time);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        point = new int[N];
        time = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0,0, point, time);
        System.out.println(max);

    }
}
