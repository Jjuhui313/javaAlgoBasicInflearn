package algo07_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 07-12 경로 탐색(인접행렬: DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M, answer = 0;
    public static boolean[][] graph;
    public static boolean[] check;

    public static void dfs(int v) {
        if (v == N) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (graph[v][i] && !check[i]) {
                    check[i] = true;
                    dfs(i);
                    check[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = true;
        }

        check[1] = true;
        dfs(1);
        System.out.println(answer);

    }
}
