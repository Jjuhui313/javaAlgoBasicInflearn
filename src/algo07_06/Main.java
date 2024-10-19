package algo07_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 07-06 부분집합 구하기(DFS)
 *
 * DFS로 공집합 제외 부분집합 구하기 문제 풀어보기
 * */

public class Main {
    public static int N;
    public static int[] check;
    public static void dfs(int L) {
        if (L == N + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (check[i] == 1) {
                    tmp.append(i).append(" ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            check[L] = 1;
            dfs(L + 1);
            check[L] = 0;
            dfs(L + 1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new int[N + 1];
        dfs(1);
    }
}
