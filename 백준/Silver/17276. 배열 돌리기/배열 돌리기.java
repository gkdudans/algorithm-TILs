import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int steps = Math.abs(d) / 45;   
            boolean clockwise = d > 0;      
            steps %= 8;                        

            int[][] A = new int[n + 1][n + 1];
            // 배열 입력 받기 
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] res = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    res[i][j] = A[i][j];
                }
            }

            int mid = n / 2 + 1;

            for (int step = 0; step < steps; step++) {
                int[][] temp = new int[n + 1][n + 1];
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= n; c++) {
                        temp[r][c] = res[r][c];
                    }
                }

                if (clockwise) {
                    // 시계 방향 
                    for (int j = 1; j <= n; j++) {
                        // 주대각선 -> 중앙열
                        temp[j][mid] = res[j][j];
                        // 중앙열 -> 부대각선
                        temp[j][n + 1 - j] = res[j][mid];
                        // 부대각선 -> 중앙행
                        temp[mid][j] = res[n + 1 - j][j];
                        // 중앙행 -> 주대각선
                        temp[j][j] = res[mid][j];
                    }
                } else {
                    // 반시계 방향
                    for (int j = 1; j <= n; j++) {
                        // 주대각선 -> 중앙행
                        temp[mid][j] = res[j][j];
                        // 중앙행 -> 부대각선
                        temp[n + 1 - j][j] = res[mid][j];
                        // 부대각선 -> 중앙열
                        temp[n + 1 - j][mid] = res[n + 1 - j][j];
                        // 중앙열 -> 주대각선
                        temp[j][j] = res[j][mid];
                    }
                }
                res = temp;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sb.append(res[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
