import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static List<Integer> result;
    static int[][] map;
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        N = maps.length ; // 세로 
        M = maps[0].length(); // 가로 
        
        map = new int[M][N];
        visited = new boolean[M][N];
            
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                String now = String.valueOf(maps[i].charAt(j));
                if(now.equals("X")) {
                    map[j][i] = 0;
                } else {
                    int c = maps[i].charAt(j) - '0';
                    map[j][i] = c;
                }
            }
        }
        result = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    int sum = dfs(i, j);
                    result.add(sum);
                }
            }
        }
        Collections.sort(result);
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        if(result.size() == 0) answer = new int[]{-1};
        return answer;
    }
    
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
                sum += dfs(nx, ny);
            }
        }
        return sum;
    }
    
    static boolean isInRange(int x, int y) {
        if(x < 0 || x >= M) return false;
        if(y < 0 || y >= N) return false;
        return true;
    }
}