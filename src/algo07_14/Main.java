package algo07_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 07-14 최단거리(BFS)
 *
 * BFS로 풀어보기
 * */

public class Main {

    public static int N, M, answer = 0;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] check;
    public static int[] dis;

    public static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        check[V] = true;
        dis[V] = 0;
        q.offer(V);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nv : graph.get(cur)) {
                if (!check[nv]) {
                    check[nv] = true;
                    q.offer(nv);
                    dis[nv] = dis[cur] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        check = new boolean[N + 1];
        dis = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
        }
        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
