package algo01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-03 문장 속 단어
 *
 * */
public class Main {
    public static String solution(String[] arr) {
        int max = Integer.MIN_VALUE;
        String maxString = "";
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            if (len > max) {
                max = len;
                maxString = arr[i];
            }
        }

        return maxString;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        System.out.println(solution(arr));
    }
}
