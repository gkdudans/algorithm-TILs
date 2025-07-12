class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length; 
        int m = board[0].length; 
        int[][] D = new int[n+1][m+1];
        
        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0]; // 1이면 적, 2면 아군
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1) {
                D[r1][c1] -= degree; // 좌상단 
                D[r1][c2+1] += degree; // 우상단 
                D[r2+1][c1] += degree; // 좌하단
                D[r2+1][c2+1] -= degree; // 우하단 
            } else {
                D[r1][c1] += degree; // 좌상단 
                D[r1][c2+1] -= degree; // 우상단 
                D[r2+1][c1] -= degree; // 좌하단
                D[r2+1][c2+1] += degree; // 우하단 
            }
        }
        
        // 좌 -> 우
        for(int i=0; i<n; i++) {
            for(int j=1; j<m; j++) {
                D[i][j] = D[i][j-1] + D[i][j];    
            }
        }
            
            // 상 -> 하
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                D[i][j] = D[i-1][j] + D[i][j];    
            }
        }
            
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] + D[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}