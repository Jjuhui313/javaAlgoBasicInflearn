package algo02_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 02-08 등수구하기
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    public static StringBuilder solution2 (ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            int count = 1;
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j) > arr.get(i)) count++;
            }
            sb.append(count).append(" ");
        }
        return sb;
    }
    public static StringBuilder solution1 (ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        int[] rankArr = new int[arr.size()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                max = Math.max(arr.get(i), arr.get(j));
                if (max == arr.get(i) && max != arr.get(j)) {
                    rankArr[i]++;
                } else if (max == arr.get(i) && max == arr.get(j)) {
                    rankArr[i]++;
                    rankArr[j]++;
                } else {
                    rankArr[j]++;
                }
            }
        }

        for (int i = 0; i < rankArr.length; i++) {
            sb.append(rankArr.length - rankArr[i]).append(" ");
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        while(T-- > 0) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution1(arr));
        System.out.println(solution2(arr));


    }
}
