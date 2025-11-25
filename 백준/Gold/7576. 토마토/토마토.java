import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int M;
    static int N;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int[][] tomato = new int[M][N];
		int[][] day = new int[M][N];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int j=0; j<N; j++) {
		    st = new StringTokenizer(br.readLine());
		    for(int i=0; i<M; i++) {
		        tomato[i][j] = Integer.parseInt(st.nextToken());
		        if(tomato[i][j] == 1) {
		            queue.add(new int[]{i, j});
		            day[i][j] = 0;
		        } else {
		            day[i][j] = Integer.MAX_VALUE;
		        }
		    }
		}
		
		while(!queue.isEmpty()) {
		    int[] now = queue.poll();
		    
		    for(int i=0; i<4; i++) {
		        int nx = now[0] + dx[i];
		        int ny = now[1] + dy[i];
		        
		        if(isInRange(nx, ny) && tomato[nx][ny] == 0 && day[nx][ny] > day[now[0]][now[1]] + 1) {
		            day[nx][ny] = day[now[0]][now[1]] + 1;
		            queue.add(new int[]{nx, ny});
		            max = Math.max(max, day[nx][ny]);
		        }
		    }
		}
		
		for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if(tomato[i][j] == 0 && day[i][j] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max);
	}
	
	static boolean isInRange(int x, int y) {
	    if(x >= M || x < 0) return false;
	    if(y >= N || y < 0) return false;
	    return true;
	}
}