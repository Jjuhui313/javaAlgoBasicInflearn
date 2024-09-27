package algo04_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 04-03 매출액의 종류
 *
 * HashMap과 sliding window를 모두 사용해서 두 가지 방법으로 풀어보기
 * */

public class Main {
    public static ArrayList<Integer> solution2(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int lt = 0;

        for (int i = 0; i < k - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (int rt = k - 1; rt < n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0) {
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;

    }
    public static StringBuilder solution1(int n, int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int lt = 0;
        for (int i = 0; i < k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(hm.size()).append(" ");
        for (int rt = k; rt < n; rt++) {
            if (hm.get(arr[lt]) != 0) {
                hm.put(arr[lt], hm.get(arr[lt]) - 1);
            }
            if (hm.get(arr[lt]) == 0){
                hm.remove(arr[lt]);
            }
            lt++;
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            sb.append(hm.size()).append(" ");
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(N, K, arr));

        for (int x : solution2(N, K, arr)) {
            System.out.print(x + " ");
        }
    }
}
