class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        int MOD = 1000000007;
        
        dp[0] = 1;
        
        // dp[i]: i원을 거슬러 줄 방법의 수 
        // bottom-up 방식 사용
        for(int coin : money) {
            for(int i=coin; i<=n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        
        return dp[n];
    }
}