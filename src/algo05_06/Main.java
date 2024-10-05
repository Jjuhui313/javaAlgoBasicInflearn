package algo05_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 05-06 공주 구하기
 *
 * Queue 사용해서 풀어보기
 * */

public class Main {
    public static int solution1(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int j = 1; j < k; j++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution1(N, K));
    }
}
