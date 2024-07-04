package algo02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 02-07 점수계산
 *
 * */

public class Main {
    public static int solution1 (int[] arr) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[T];
        int idx = 0;
        while (T-- > 0) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution1(arr));
    }
}
