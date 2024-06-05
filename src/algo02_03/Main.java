package algo02_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 02-03 가위 바위 보
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    public static StringBuilder solution1(int[] arrA, int[] arrB) {
        StringBuilder sb = new StringBuilder();
        String s;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > arrB[i]) {
                s = "A";
            } else if (arrA[i] == arrB[i]) {
                s = "D";
            } else {
                s = "B";
            }

            if (arrA[i] == 3 && arrB[i] == 1) {
                s = "B";
            } else if (arrA[i] == 1 && arrB[i] == 3) {
                s = "A";
            }

            sb.append(s).append("\n");
        }
        return sb;
    }

    public static StringBuilder solution2(int[] arrA, int[] arrB) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == arrB[i]) sb.append("D");
            else if (arrA[i] == 1 && arrB[i] == 3) sb.append("A");
            else if (arrA[i] == 2 && arrB[i] == 1) sb.append("A");
            else if (arrA[i] == 3 && arrB[i] == 2) sb.append("A");
            else sb.append("B");
            sb.append("\n");
        }
        return sb;
    }

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        int[] arrB = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(arrA, arrB));
        System.out.println(solution2(arrA, arrB));

    }
}
