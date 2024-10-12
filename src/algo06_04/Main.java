package algo06_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 06-04 Least Recently Used
 *
 * 삽입 정렬을 이용하여 LRU 카카오 캐쉬 변형 문제 풀어보기
 * */

public class Main {
    public static int[] solution(int s, int[] arr) {
        int[] cache = new int[s];

        for (int i : arr) {
            int pos = -1;
            for (int j = 0; j < s; j++) {
                if (cache[j] == i) {
                    pos = j;
                }
            }

            if (pos == -1) {
                for (int j = s - 1; j >= 1; j--) {
                    cache[j] = cache[j - 1];
                }
            } else {
                for (int j = pos; j >= 1; j--) {
                    cache[j] = cache[j - 1];
                }
            }
            cache[0] = i;
        }
        return cache;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(S, arr)) {
            System.out.print(i + " ");
        }
    }
}
