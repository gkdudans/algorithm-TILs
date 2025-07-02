import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][N];
        int[] row = new int[N];
        int[] col = new int[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            row[i] = r;
            col[i] = c;
        }
        

        // dp[i][j]: i번째부터 j번째 행렬까지 곱할 때의 최소 곱셈 횟수 
        // len: 곱하는 행렬 개수 - 1 (즉, len=1이면 두 개의 행렬 곱)
        for(int len=1; len<N; len++) { 
            for(int i=0; i+len<N; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE; 
                
                // k를 돌면서 dp[i][j]의 최솟값을 찾음 
                for(int k=i; k<j; k++) {
                    // len=3인 예시: dp[0][3]을 채우기 위한 연산 
                    // k=0) (A)(BCD), dp[0][0] + dp[1][3] + 5x3x7
                    // k=1) (AB)(CD), dp[0][1] + dp[2][3] + 5×2×7
                    // k=2) (ABC)(D), dp[0][2] + dp[3][3] + 5×6×7
                    int cost = dp[i][k] + dp[k+1][j] + row[i]*col[k]*col[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        System.out.println(dp[0][N-1]);
	}
}