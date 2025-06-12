import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n+1];  
		int[] dp = new int[n+1]; // i번째에서 끝나는 최대 연속합 
		st = new StringTokenizer(br.readLine());
		
		num[0] = 0;
		dp[0] = 0;
		int maxSum = -Integer.MAX_VALUE;  
		
		for(int i=1; i<=n; i++) {
		    num[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i]: 이전까지의 연속합에 지금 원소를 더할지, 새로 시작할지 결정 
		// maxSum: 최대 연속합 결정         
		for(int i=1; i<=n; i++) {
		    dp[i] = Math.max(dp[i-1] + num[i], num[i]); 
		    maxSum = Math.max(maxSum, dp[i]);
		}
		
		System.out.println(maxSum);  
	}
}
