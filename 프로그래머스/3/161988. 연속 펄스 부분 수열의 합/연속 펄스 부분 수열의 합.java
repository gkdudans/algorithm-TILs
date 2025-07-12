class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;

        long dp[][] = new long[n][2];

        dp[0][0] = sequence[0]; 
        dp[0][1] = -sequence[0];

        // dp[i][0]: 마지막 연산이 더하기인 최대 누적 합
        // dp[i][1]: 마지막 연산이 빼기인 최대 누적 합
        for(int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], 0) + sequence[i];
            dp[i][1] = Math.max(dp[i-1][0], 0) - sequence[i];
        }

        for(long[] col : dp) {
             answer = Math.max(answer, Math.max(col[0], col[1]));
        }

        return answer;
    }
}