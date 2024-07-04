package algo02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 02-04 피보나치 수열
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    public static StringBuilder solution1(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        return sb;
    }

    public static void solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution1(n));
        solution2(n);

    }
}
