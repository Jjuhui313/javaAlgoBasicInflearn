package algo03_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 03-02 공통원소 구하기
 *
 * 2가지 방법으로 풀어보기
 * */


public class Main {
    public static ArrayList<Integer> solution2(int[] A, int[] B) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        int pA = 0;
        int pB = 0;

        while(pA < A.length && pB < B.length) {
            if (A[pA] == B[pB]) {
                arr.add(A[pA++]);
                pB++;
            } else if (A[pA] < B[pB]) {
                pA++;
            } else {
                pB++;
            }
        }

        return arr;
    }
    public static StringBuilder solution1(int[] A, int[] B) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);
        Arrays.sort(B);
        int pA = 0;
        int pB = 0;

        while (pA < A.length && pB < B.length) {
            if (A[pA] != B[pB]) {
                if (A[pA] < B[pB]) {
                    pA++;
                } else {
                    pB++;
                }
            } else {
                sb.append(A[pA]).append(" ");
                pA++;
            }
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(A, B));
        for (int i : solution2(A, B)) {
            System.out.print(i + " ");
        }
    }
}
