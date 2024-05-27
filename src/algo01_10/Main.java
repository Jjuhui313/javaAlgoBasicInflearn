package algo01_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 01-10 가장 짧은 문자거리
 *
 * 2가지 방법으로 풀어보기
 * */
public class Main {
    public static StringBuilder solution1(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int indexE1 = Integer.MAX_VALUE;
        int indexE2;
        int index = 0;
        for (char c : s.toCharArray()) {
            int i = s.indexOf(c, index);
            indexE2 = s.indexOf(t.charAt(0), i);
            int indexE1Abs =  Math.abs(indexE1 - i);
            int indexE2Abs =  Math.abs(indexE2 - i);
            if (indexE1Abs < indexE2Abs) {
                sb.append(indexE1Abs);
            } else if (indexE1 == i || indexE2 == i) {
                sb.append(0);
                indexE1 = indexE2;
            } else {
                sb.append(indexE2Abs);
            }
            sb.append(" ");
            index++;
        }

        return sb;
    }

    public static StringBuilder solution2(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[s.length()];
        int temp = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                temp = 0;
            } else {
                temp++;
            }
            arr[i] = temp;
        }

        temp = 1001;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(0)) {
                temp = 0;
            } else {
                temp++;
            }
            arr[i] = Math.min(arr[i], temp);
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String t = st.nextToken();
        System.out.println(solution1(s, t));
        System.out.println(solution2(s, t));

    }
}
