import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m]; // 각 위치까지의 최단 거리 저장
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작 위치
        visited[0][0] = true;
        dist[0][0] = 0;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentD = dist[currentX][currentY]; 
            
            for(int i=0; i<4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(isInBounds(nextX, nextY, n, m) 
                   && !visited[nextX][nextY]
                   && maps[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    dist[nextX][nextY] = currentD+1; 
                }
            }
        }
        
            if(dist[n-1][m-1] != 0) {
                return dist[n-1][m-1] + 1; 
            } else {
                return -1;
            } 
    }
    static boolean isInBounds(int x, int y, int n, int m) {
        if(x >= n || x < 0) return false;
        if(y >= m || y < 0) return false;
        return true;
    }
}
 