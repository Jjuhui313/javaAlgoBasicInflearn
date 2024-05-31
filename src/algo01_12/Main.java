package algo01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 01-12 암호
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    public static StringBuilder solution1(int n, String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (n > index) {
            String tempBinary = "";
            String tempS = s.substring(index * 7, index * 7 + 7);
            for (char c : tempS.toCharArray()) {
                if (c == '#') {
                    tempBinary += "1";
                } else {
                    tempBinary += "0";
                }
            }
            sb.append((char) Integer.parseInt(tempBinary, 2));
            index++;
        }
        return sb;
    }

    public static StringBuilder solution2 (int n, String s) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            String temp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            sb.append((char) num);
            s = s.substring(7);
            n--;
        }
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(solution1(n, s));
        System.out.println(solution2(n, s));
    }
}
