package algo08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-01 합이 같은 부분집합(DFS : 아마존 인터뷰)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N, total = 0;

    public static String answer = "NO";
    public static boolean flag = false;

    public static void dfs(int L, int sum, int[] arr) {
        if (flag || (sum > total / 2)) return;

        if (L == N) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        dfs(0, 0, arr);
        System.out.println(answer);
    }
}
