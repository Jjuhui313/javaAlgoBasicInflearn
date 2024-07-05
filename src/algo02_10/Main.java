package algo02_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 02-10 봉우리
 *
 * 2가지 방법으로 풀어보기
 * */

public class Main {
    public static int solution2 (int[][] arr) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                boolean isTop = true;

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < arr.length && y >= 0 && y < arr.length && arr[x][y] >= arr[i][j]) {
                        isTop = false;
                        break;
                    }
                }
                if (isTop) answer++;
            }
        }
        return answer;
    }

    public static int solution1 (int[][] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arr[i].length; j++) {
                if (i > 0) {
                    max = Math.max(arr[i][j],arr[i - 1][j]); //위
                    if (arr[i][j] == arr[i - 1][j] || max != arr[i][j]) continue;
                }
                if (i < arr.length - 1) {
                    max = Math.max(arr[i][j], arr[i + 1][j]); // 아래
                    if (arr[i][j] == arr[i + 1][j] || max != arr[i][j]) continue;
                }
                if (j > 0) {
                    max = Math.max(arr[i][j], arr[i][j - 1]); //왼쪽
                    if (arr[i][j] == arr[i][j - 1] || max != arr[i][j]) continue;
                }
                if (j < arr[i].length - 1) {
                    max = Math.max(arr[i][j], arr[i][j + 1]); //오른쪽
                    if (arr[i][j] == arr[i][j + 1] || max != arr[i][j]) continue;
                }
                answer++;
            }
        }
            return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution1(arr));
        System.out.println(solution2(arr));

    }
}
