import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N, M, T;
    static int[][][] time; // [x][y][g]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        time = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(time[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 1, 1, 0, 0 }); // x, y, 시간, g
        time[1][1][0] = 0;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], t = now[2], g = now[3];

            if (t > T) continue; 
            if (x == N && y == M) {
                answer = Math.min(answer, t);
                break; 
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isInRange(nx, ny)) continue;

                int ng = g;
                if (map[nx][ny] == 2) ng = 1; 

                if (map[nx][ny] != 1 || g == 1) { 
                    if (time[nx][ny][ng] > t + 1) {
                        time[nx][ny][ng] = t + 1;
                        queue.add(new int[] { nx, ny, t + 1, ng });
                    }
                }
            }
        }

        if (answer <= T) System.out.println(answer);
        else System.out.println("Fail");
    }

    static boolean isInRange(int x, int y) {
        if (x <= 0 || x > N)
            return false;
        if (y <= 0 || y > M)
            return false;
        return true;
    }
}
