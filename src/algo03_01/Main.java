package algo03_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 03-01 두 배열 합치기
 *
 * 투 포인터로 풀어보기
 * */

public class Main {

    public static StringBuilder solution(int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        while (p1 < a.length && p2 < b.length){
            if (a[p1] > b[p2]) {
                sb.append(b[p2]).append(" ");
                p2++;
            } else {
                sb.append(a[p1]).append(" ");
                p1++;
            }
        }

        if (p1 == a.length) {
            for (int i = p2; i < b.length; i++) {
                sb.append(b[i]).append(" ");
            }
        } else {
            for (int i = p1; i < a.length; i++) {
                sb.append(a[i]).append(" ");
            }
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aArr = new int[N];

        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] bArr = new int[M];

        for (int i = 0; i < M; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(aArr, bArr));


    }
}
