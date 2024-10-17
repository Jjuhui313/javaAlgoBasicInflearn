package algo07_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 07-03 팩토리얼
 *
 * 재귀함수를 활용하여 팩토리얼 문제 풀어보기
 * */

public class Main {
    public static int dfs(int n) {
        if (n == 1) {
            return 1;
        }

        return n * dfs(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dfs(n));
    }
}
