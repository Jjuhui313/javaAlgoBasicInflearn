package algo06_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 06-10 마구간 정하기
 *
 * 결정 알고리즘을 이용하여 문제 풀어보기
 * */

public class Main {
    public static int count(int[] arr, int dist) {
        int answer = 1;
        int endPoint = arr[0];
        for (int x : arr) {
            if (endPoint + dist <= x) {
                endPoint = x;
                answer++;
            }
        }
        return answer;
    }
    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int left = 1, right = arr[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (count(arr, mid) < c) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, C, arr));

    }
}
