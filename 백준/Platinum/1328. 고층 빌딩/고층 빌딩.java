import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		long[][][] dp = new long[N+1][L+1][R+1];
		int MOD = 1000000007;
		
		dp[1][1][1] = 1;
		
		for(int i=2; i<=N; i++) {
		    for(int j=1; j<=L; j++) {
		        for(int k=1; k<=R; k++) {
		            // i번째 빌딩 삽입 위치
		              // 왼쪽 끝: L++, N-1 && L-1인 경우의 수와 같음 
		              // 오른쪽 끝: R++, N-1 && R-1인 경우의 수와 같음 
		              // 중간: 가장 큰 N을 삽입하므로 (N-1인 경우의 수)*(i-2)와 같음 
		            long temp = (dp[i-1][j][k] * (i - 2)) % MOD;  // 곱셈 오버플로우 방지
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + temp) % MOD;
		        }
		    }
		}
		
		System.out.println(dp[N][L][R]);
	}
}