import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] cost;
    static int N;
    
    public int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N][4];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<4; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        for(int i=0; i<4; i++) {
            cost[0][0][i] = 0;
        }
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                
                if(isInRange(x, y) && board[x][y] == 0) {
                    int nextCost = cost[now[0]][now[1]][now[2]] + 100;
                    
                     if (!(now[0] == 0 && now[1] == 0) && now[2] / 2 != i / 2) {
                         nextCost += 500;
                     }
                   
                    if(nextCost <= cost[x][y][i]) {
                        cost[x][y][i] = nextCost;
                        queue.add(new int[]{x, y, i});
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            answer = Math.min(answer, cost[N-1][N-1][i]);
        }
        return answer;
    }
    
    static boolean isInRange(int x, int y) {
        if(x < 0 || x >= N) return false;
        if(y < 0 || y >= N) return false;
        return true;
    }
}