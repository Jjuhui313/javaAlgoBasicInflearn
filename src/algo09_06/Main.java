package algo09_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 09-06 친구인가? (Disjoint-Set : Union&Find)
 *
 * Union&Find 알고리즘으로 풀어보기
 * */

public class Main {
    public static int[] uF;
    public static int Find(int v) {
        if (v == uF[v]) return v;
        else return uF[v] = Find(uF[v]);
    }

    public static void Union(int a, int b) {
        int fA = Find(a);
        int fB = Find(b);
        if (fA != fB) uF[fA] = fB;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        uF = new int[N + 1];
        for (int i = 1; i <= N; i++) uF[i] = i;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Union(x, y);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fA = Find(a);
        int fB = Find(b);

        if (fA == fB) System.out.println("YES");
        else System.out.println("NO");

    }
}
