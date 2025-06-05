class Solution {
    static int[][] dp; // dp[y][x]는 (1, 1)에서 (x, y)까지 오는 최단 경로 개수 
    static boolean[][] isWater;
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1]; // 1-based 사용
        isWater = new boolean[n+1][m+1];
        
        // isWater 채우기
        for(int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            isWater[y][x] = true;
        }
        
        // 시작점: 집
        dp[1][1] = 1;
        

        for(int y=1; y<=n; y++) {
            for(int x=1; x<=m; x++) {
                // 물에 잠긴 지역이면 0
                if(isWater[y][x]) dp[y][x] = 0;
                
                // dp[y][x] = dp[y-1][x] + dp[y][x-1]
                else {
                    // 위 -> 아래 
                    if(y > 1) dp[y][x] = (dp[y][x] + dp[y-1][x]) % MOD;
                    
                    // 왼 -> 오
                    if(x > 1) dp[y][x] = (dp[y][x] + dp[y][x-1]) % MOD;
                }
                
            }
        }
        
        
        int answer = dp[n][m];
        return answer;
    }
}