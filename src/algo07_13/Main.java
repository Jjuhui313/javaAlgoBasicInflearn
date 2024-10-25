package algo07_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 07-13 경로 탐색(인접리스트: DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M, answer = 0;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] check;

    public static void dfs(int V) {
        if (V == N) {
            answer++;
        } else {
            for (int nv : graph.get(V)) {
                if (!check[nv]) {
                    check[nv] = true;
                    dfs(nv);
                    check[nv] = false;
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
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
        }

        check[1] = true;
        dfs(1);
        System.out.println(answer);
    }
}
