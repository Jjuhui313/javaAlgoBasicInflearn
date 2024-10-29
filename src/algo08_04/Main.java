package algo08_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-04 중복순열 구하기(DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int[] arr;
    public static int N, M;

    public static void dfs(int L) {
        if (L == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                arr[L] = i;
                dfs(L + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
    }
}
