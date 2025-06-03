import java.util.*;

class Solution {
   public int solution(int[][] triangle) {
        int n = triangle.length;

        // DP 배열 초기화: triangle과 같은 구조의 배열 생성
        int[][] dp = new int[n][n];

        // 삼각형의 바닥 숫자들은 DP 배열에 그대로 복사
        for(int i=0; i<n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        // 아래에서 위로 올라가며 DP 수행
        for(int row=n-2; row>=0; row--) {
            for(int col=0; col<=row; col++) {
                dp[row][col] = triangle[row][col] + Math.max(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }

        return dp[0][0];
    }
}
