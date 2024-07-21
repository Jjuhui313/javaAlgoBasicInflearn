package algo02_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 02-12 멘토링
 *
 * */

public class Main {
    public static int solution(int N, int M, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int count = 0;

                for (int k = 0; k < M; k++) {
                    int ni = 0;
                    int nj = 0;
                    for (int t = 0; t < N; t++) {
                        if (arr[k][t] == i) {
                            ni = t;
                        }
                        if (arr[k][t] == j) {
                            nj = t;
                        }
                    }
                    if (ni > nj) {
                        count++;
                    }
                }
                if (count == M) {
                    answer++;
                }
            }
        }

        return answer;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, M, arr));
    }
}
