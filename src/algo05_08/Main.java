package algo05_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 05-08 응급실
 *
 * Queue 사용해서 풀어보기
 * */

class Person {
    public int idx;
    public int risk;

    public Person(int idx, int risk) {
        this.idx = idx;
        this.risk = risk;
    }

}
public class Main {
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person temp = q.poll();

            for (Person p : q) {
                if (temp.risk < p.risk) {
                    q.offer(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) {
                answer++;
                if (temp.idx == m) {
                    return answer;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, M, arr));
    }
}
