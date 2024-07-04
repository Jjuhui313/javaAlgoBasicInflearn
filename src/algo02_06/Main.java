package algo02_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 02-06 뒤집은 소수
 *
 * */

public class Main {
    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static StringBuilder solution1(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] charArr = arr[i].toCharArray();
            int left = 0;
            int right = charArr.length - 1;

            while (left < right) {
                char temp = charArr[left];
                charArr[left] = charArr[right];
                charArr[right] = temp;

                left++;
                right--;
            }
            int num = Integer.parseInt(new String(charArr));

            if (isPrime(num)) {
                sb.append(num).append(" ");
            }

        }
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[T];
        int idx = 0;
        while (T-- > 0) {
            arr[idx++] = st.nextToken();
        }
        System.out.println(solution1(arr));
    }
}
