package algo06_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 06-08 이분 탐색
 *
 * 이분 탐색을 이용하여 문제 풀어보기
 * */

public class Main {
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) {
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
