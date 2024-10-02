package algo05_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 05-03 크레인 인형뽑기(카카오)
 *
 * stack 사용해서 풀어보기
 * */

public class Main {
    public static int solution(int[][] board, int[] arr) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        for (int pos : arr) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!st.isEmpty() && st.peek() == tmp) {
                        answer += 2;
                        st.pop();
                    } else {
                        st.push(tmp);
                    }
                    break;
                }
            }
        }


        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(board, arr));
    }
}
