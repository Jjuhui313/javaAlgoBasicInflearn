package algo09_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 09-05 다익스트라 알고리즘
 *
 * 다익스트라 알고리즘으로 풀어보기
 * */

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static int N, M;
    public static ArrayList<ArrayList<Edge>> graph;
    public static int[] dis;

    public static void solution(int V) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(V, 0));
        dis[V] = 0;
        while (!q.isEmpty()) {
            Edge temp = q.poll();
            int now = temp.vex;
            int nowCost = temp.cost;
            if (nowCost > dis[now]) continue;
            for (Edge e : graph.get(now)) {
                if (dis[e.vex] > nowCost + e.cost) {
                    dis[e.vex] = nowCost + e.cost;
                    q.offer(new Edge(e.vex, nowCost + e.cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        solution(1);

        for (int i = 2; i <= N; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }
}
