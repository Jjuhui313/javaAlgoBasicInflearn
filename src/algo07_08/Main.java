package algo07_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 07-08 송아지 찾기 1(BFS: 상태트리 탐색)
 *
 * bfs로 문제 풀어보기
 * */

public class Main {
    public static int[] dis = {1, -1, 5};
    public static boolean[] check;
    public static Queue<Integer> q = new LinkedList<>();

    public static int bfs(int s, int e) {
        int L = 0;
        q.offer(s);
        check[s] = true;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for (int j = 0; j < 3; j++) {
                    int nx = cur + dis[j];
                    if (nx == e) {
                        return L + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && !check[nx]) {
                        check[nx] = true;
                        q.offer(nx);
                    }
                }

            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        check = new boolean[10001];

        System.out.println(bfs(S, E));
    }
}
