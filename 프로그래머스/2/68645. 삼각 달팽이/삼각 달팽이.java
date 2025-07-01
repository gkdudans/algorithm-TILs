class Solution {
    static int dx[] = {0, 1, -1};
    static int dy[] = {1, 0, -1};
    
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        int[] answer = new int[max];
        int[][] triangle = new int[n][n];
        int x = 0, y = 0;
        int dir = 0;
        
        triangle[y][x] = 1;
        for(int i=2; i<=max; i++) {
            while(true) {
                x += dx[dir];
                y += dy[dir];

                // 배열의 경계를 벗어나는 경우 
                if(y < 0 || y >= n || x < 0 || x >= n || triangle[y][x] != 0) {
                    x -= dx[dir];
                    y -= dy[dir];
                    dir = (dir + 1) % 3; // 반시계 방향
                }
                else {
                    break;
                }
            }
            triangle[y][x] = i;
        }
        
        int now = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) { 
                if (triangle[i][j] != 0 || (i == 0 && j == 0)) {
                    answer[now++] = triangle[i][j];
                }
            }
        }
        return answer;
    }
}