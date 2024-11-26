package algo09_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 09-04 최대 수입 스케쥴(PriorityQueue 응용문제)
 *
 * Greedy로 풀어보기
 * */

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;

    Lecture(int money, int time) {
        this.money = money;
        this.date = time;
    }
    @Override
    public int compareTo(Lecture l) {
        return l.date - this.date;
    }
}
public class Main {
    public static int N, max = Integer.MIN_VALUE;
    public static int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i  >= 1; i--) {
            for (; j < N; j++) {
                if (arr.get(j).date < i) break;
                q.offer(arr.get(j).money);
            }
            if (!q.isEmpty()) answer += q.poll();

        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Lecture(m, d));
            if (d > max) {
                max = d;
            }

        }

        System.out.println(solution(arr));
    }
}
