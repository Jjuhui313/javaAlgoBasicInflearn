package algo08_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 08-04 동전교환
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, M;
    public static int min = Integer.MAX_VALUE;

    public static void dfs(int L, int sum, Integer[] arr) {
        if (sum > M) return;
        if (L >= min) return;
        if (sum == M) {
            min = Math.min(min, L);
        } else {

            for (int i = 0; i < N; i++) {
                dfs(L + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        M = Integer.parseInt(br.readLine());

        dfs(0, 0, arr);
        System.out.println(min);
    }
}
