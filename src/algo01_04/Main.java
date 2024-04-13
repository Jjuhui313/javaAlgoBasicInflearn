package algo01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 01-04 단어 뒤집기
 *
 * 3가지 방법으로 풀어보기
 * */

public class Main {

    //첫 번째 풀이 (단순풀이 - 이중 for문)
    public static StringBuilder solution1(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.get(i).length() - 1; j >= 0; j--) {
                sb.append(arr.get(i).charAt(j));
            }
            sb.append("\n");
        }

        return sb;
    }

    //두 번째 풀이 (앞 뒤로 짝을 지어 뒤바꾸기)
    public static StringBuilder solution2(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        List<String> answer = new ArrayList<>();
        for (String s : arr) {
            char[] cArr = s.toCharArray();
            int front = 0;
            int back = s.length() - 1;
            while (front < back) {
                char temp = cArr[front];
                cArr[front] = cArr[back];
                cArr[back] = temp;
                front++;
                back--;
            }
            answer.add(String.valueOf(cArr));
        }
        for (String s : answer) {
            sb.append(s).append("\n");
        }
        return sb;
    }

    //세 번째 풀이 (StringBuilder의 메서드를 사용한 풀이)
    public static StringBuilder solution3(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            String str = new StringBuilder(s).reverse().toString();
            sb.append(str).append("\n");
        }
        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        while (T-- > 0) {
            String s = br.readLine();
            arr.add(s);
        }

        System.out.println(solution1(arr));
        System.out.println(solution2(arr));
        System.out.println(solution3(arr));

    }
}
