import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N+1];
		
		// dp[i]: i자리 이친수의 개수 
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
		    // dp[i-1] 끝이 0 -> 1, 1 -> 0 추가 
		    // dp[i-2] 끝이 10인 경우에 마지막 자리에 0 추가  
		    dp[i] = dp[i-1] + dp[i-2]; 
		}
		
		System.out.println(dp[N]);
	}
}