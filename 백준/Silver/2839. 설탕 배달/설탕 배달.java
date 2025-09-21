import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = -1;
		dp[2] = -1;
		
		for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 3 && dp[i-3] != -1) min = Math.min(min, dp[i-3] + 1);
            if (i >= 5 && dp[i-5] != -1) min = Math.min(min, dp[i-5] + 1);
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        
        System.out.println(dp[N]);
	}
}