package algo08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-05 순열 구하기
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int[] answer;
    public static boolean[] check;
    public static void dfs(int L) {
        if (L == M) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (!check[arr[i]]) {
                    check[arr[i]] = true;
                    answer[L] = arr[i];
                    dfs(L + 1);
                    check[arr[i]] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        check = new boolean[11];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
    }
}
