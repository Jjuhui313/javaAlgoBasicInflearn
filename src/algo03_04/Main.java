package algo03_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 03-04 연속 부분수열
 *
 * sliding window, two pointers 방식을 혼합하여 풀어보기
 * 2가지 방식으로 풀어봄!
 * */

public class Main {
    private static int solution2(int N, int M, int[] arr) {
        int count = 0;
        int lp = 0;
        int sum = 0;

        for (int rp = 0; rp < N; rp++) {
            sum += arr[rp];
            if (sum == M) {
                count++;
            }
            while (sum >= M) {
                sum -= arr[lp++];
                if (sum == M) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int solution1(int N, int M, int[] arr) {
        int count = 0;
        int lp = 0, rp = 0;
        int sum = arr[lp];

        while (true) {
            if (sum < M) {
                rp++;
                if (rp < N) sum += arr[rp];
                else break;
            } else if (sum > M) {
                sum -= arr[lp];
                lp++;
            } else {
                count++;
                sum -= arr[lp];
                lp++;
            }
        }


        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(N, M, arr));
        System.out.println(solution2(N, M, arr));
    }
}
