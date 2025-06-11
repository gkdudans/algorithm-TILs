import java.util.*;

public class Main
{
    static long MOD = 10007; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    long[] dp = new long[n+2];
	    
	    dp[1] = 1;
	    dp[2] = 2;
	    for(int i=3; i<=n; i++) {
	        dp[i] = (dp[i-1] + dp[i-2]) % MOD;
	    }
	    
	    System.out.println(dp[n]);
	}
}