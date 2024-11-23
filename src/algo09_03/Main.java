package algo09_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
 * 09-03 결혼식
 *
 * Greedy로 풀어보기
 * */

class Time implements Comparable<Time> {
    public int time;
    public char state;

    Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time t) {
        if (this.time == t.time) {
            return this.state - t.state;
        } else {
            return this.time - t.time;
        }
    }
}

public class Main {

    public static int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int count = 0;
        for (Time time : arr) {
            if (time.state == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
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
            arr.add(new Time(s, 's'));
            arr.add(new Time(e, 'e'));

        }

        System.out.println(solution(arr));
    }

}
