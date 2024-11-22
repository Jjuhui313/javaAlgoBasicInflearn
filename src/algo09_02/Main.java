package algo09_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 09-01 회의실 배정
 *
 * Greedy로 풀어보기
 * */

class Time implements Comparable<Time> {
    public int s;
    public int e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time t) {
        if (this.e == t.e) {
            return this.s - t.s;
        } else {
            return this.e - t.e;
        }
    }
}
public class Main {

    public static int solution(ArrayList<Time> arr, int n) {
        int answer = 0;
        Collections.sort(arr);
        int end = 0;

        for (Time time : arr) {
            if (time.s >= end) {
                answer++;
                end = time.e;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s, e));
        }

        System.out.println(solution(arr, N));
    }
}
