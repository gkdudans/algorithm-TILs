import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<int[]> flowers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cost = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i=2; i<=N-1; i++) {
            for (int j=2; j<=N-1; j++) {
                flowers.add(new int[]{i, j});
            }
        }
        
        dfs(0, 0, new int[3][]);
        System.out.println(min);
    }
  
    // comb: 좌표 3개 저장용 버퍼 / 전역 상태 X (원복할 필요 없음)
    static void dfs(int count, int start, int[][] comb) {
        if (count == 3) {
            updateMin(comb);
            return;
        }
        
        for (int i=start; i<flowers.size(); i++) {
            comb[count] = flowers.get(i); // 덮어쓰기 
            dfs(count+1, i+1, comb);
        }
        
    }
    
    // count가 3인 경우만 min 업데이트 
    static void updateMin(int[][] comb) {
        boolean[][] visited = new boolean[N+1][N+1];
        int sum = 0;
        
        for(int[] count : comb) {
            // 중심 좌표 
            int x = count[0];
            int y = count[1];
            
            if(visited[x][y]) return;
            visited[x][y] = true;
            sum += cost[x][y];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i]; 
                
                // 꽃잎이 겹치는 경우 updateMin을 빠져나오기 위해 return 
                if(visited[nx][ny]) return;
                visited[nx][ny] = true;
                
                sum += cost[nx][ny];
            }
        }
    
        min = Math.min(min, sum);
    }
}