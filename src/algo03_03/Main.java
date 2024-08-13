package algo03_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 03-02 공통원소 구하기
 *
 * sliding window 방식으로 풀어보기
 * */
public class Main {
    public static int solution(int N, int K, int[] arr) {
        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        int result = sum;
        for (int i = K; i < arr.length; i++) {
            sum += (arr[i] - arr[i - K]);
            result = Math.max(result, sum);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, arr));
    }
}
