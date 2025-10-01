import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dx = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];  
        boolean[][] wind = new boolean[N + 1][M + 1]; 
        boolean[][][] visited = new boolean[N + 1][M + 1][4]; 

        List<int[]> start = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    start.add(new int[]{i, j}); 
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // 에어컨 시작점
        for (int[] s : start) {
            wind[s[0]][s[1]] = true;
            for (int d = 0; d < 4; d++) {
                visited[s[0]][s[1]][d] = true;
                queue.add(new int[]{s[0], s[1], d});
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int dir = now[2];

            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (!isInRange(ny, nx)) continue;

            if (visited[ny][nx][dir]) continue;
            visited[ny][nx][dir] = true; 
            wind[ny][nx] = true;

            int num = map[ny][nx];
            switch (num) {
                case 0:
                    queue.add(new int[]{ny, nx, dir});
                    break;

                case 1: 
                    if (dir == 0 || dir == 2)
                        queue.add(new int[]{ny, nx, dir});
                    break;

                case 2: 
                    if (dir == 1 || dir == 3)
                        queue.add(new int[]{ny, nx, dir});
                    break;

                case 3: 
                    queue.add(new int[]{ny, nx, dir ^ 3});
                    break;

                case 4: 
                    queue.add(new int[]{ny, nx, dir ^ 1});
                    break;

                case 9: 
                    queue.add(new int[]{ny, nx, dir});
                    break;
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (wind[i][j]) {
                    count++;
                } 
            }
        }
        System.out.println(count);
    }

    static boolean isInRange(int y, int x) {
        return (y >= 1 && y <= N && x >= 1 && x <= M);
    }
}
