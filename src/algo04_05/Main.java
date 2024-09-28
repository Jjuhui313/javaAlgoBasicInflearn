package algo04_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 04-05 k번째 큰 수
 *
 * TreeSet 사용해서 풀어보기
 * */

public class Main {
    public static int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int y = j + 1; y < n; y++) {
                    ts.add(arr[i] + arr[j] + arr[y]);
                }
            }
        }

        int count = 0;
        for (Integer t : ts) {
            count++;
            if (count == k) {
                return t;
            }
        }
        return answer;
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
