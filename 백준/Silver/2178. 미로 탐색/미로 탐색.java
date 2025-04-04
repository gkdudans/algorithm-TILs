import java.util.*;
import java.io.*;

public class Main
{
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // x 방향배열 
    static int[] dy = { 0, 0, -1, 1 }; // y 방향배열 
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    static int depth = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				A[i][j] = s.charAt(j) - '0';
			}
		}
		
		/* OR,
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		*/
		
		visited[0][0] = true;
		queue.add(new int[]{0, 0});
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
		
	}

		public static void BFS(int x, int y) {
	        A[0][0] = 1; // depth 1

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
            
                // 상하좌우 탐색 
                for (int i = 0; i < 4; i++) {
                    int m = now[0] + dx[i];
                    int n = now[1] + dy[i];
                    
                    // 해당 칸이 배열을 벗어나지 않는지 
                    if (0 <= m && m < N && 0 <= n && n < M) {
                        // 방문하지 않은 칸이면서 방문 가능한지 
                        if (!visited[m][n] && A[m][n] == 1) {
                            queue.add(new int[]{m, n});
                            visited[m][n] = true;
                            A[m][n] = A[now[0]][now[1]] + 1; // depth 누적 
                        }
                    }
                }
            }

	}

}