package algo06_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 06-09 뮤직비디오
 *
 * 결정 알고리즘을 이용하여 문제 풀어보기
 * */

public class Main {
    public static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            } else {
                sum += i;
            }
        }
        return cnt;
    }
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();


        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
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

        System.out.println(solution(N, M, arr));

    }
}
