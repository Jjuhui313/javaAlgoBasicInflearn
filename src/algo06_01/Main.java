package algo06_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 06-01 선택 정렬
 *
 * 선택 정렬을 이용하여 풀어보기
 * */

public class Main {
    public static int[] solution(int n, int[] arr) {

        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(N, arr)) {
            System.out.print(i + " ");
        }
    }
}
