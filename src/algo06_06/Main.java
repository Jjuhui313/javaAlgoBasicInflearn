package algo06_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 06-06 장난꾸러기
 *
 * clone()과 정렬을 이용하여 풀어보기
 * */


public class Main {
    public static StringBuilder solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] copy = arr.clone();
        Arrays.sort(copy);

        for (int i = 0; i < n; i++) {
            if (copy[i] != arr[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}
