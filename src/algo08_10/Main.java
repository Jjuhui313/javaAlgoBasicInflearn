package algo08_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 08-10 미로탐색(DFS)
 *
 * DFS로 풀어보기
 * */

public class Main {
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int answer = 0;

    public static void dfs(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dfs(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }
}
