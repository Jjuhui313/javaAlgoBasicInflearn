package algo02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 02-05 소수(에라토스테네스 체)
 *
 * 에러토스테네스 체를 사용하여 소수의 갯수 구하기
 * */

public class Main {
    public static int solution1(int n) {
        int count = 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            for (int j = i * 2; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution1(n));
    }
}
