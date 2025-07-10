class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        int[] A = new int[n];
        boolean[][] dp = new boolean[n][n];
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            A[i] = s.charAt(i) - 'a';
        }
        
        // dp[i][j]: i~j 구간이 팰린드롬이면 true
        // 점화식: dp[i][j] = true, when A[i] = A[j] && dp[i+1][j-1] = true
        // len을 기준으로 반복문을 실행
        for(int len=1; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i + len - 1;
                if(A[i] == A[j]) {
                    if(len <= 2) {
                        dp[i][j] = true;
                        answer = Math.max(answer, len);
                    }
                    else if(dp[i+1][j-1]) {
                        dp[i][j] = true;
                        answer = Math.max(answer, len);
                    }
                }
            }
        }

        return answer;
    }
}