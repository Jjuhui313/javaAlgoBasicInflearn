package algo08_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-09 조합 구하기
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M;
    public static int[] combi;

    public static void dfs(int L, int s) {
        if (L == M) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= N; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        dfs(0, 1);
    }
}
