package algo08_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-13 섬나라 아일랜드
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int N;
    public static int answer = 0;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void dfs(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny, board);
            }
        }
    }

    public static void solution(int[][] board) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    dfs(i, j, board);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr);
        System.out.println(answer);

    }
}
