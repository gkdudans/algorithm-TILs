import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[N+1];
		int[] money = new int[N+1];
		int[] dp = new int[N+1]; 
		
		for(int i=1; i<=N; i++) {
		    time[i] = sc.nextInt();
		    money[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
		    // default 
		    dp[i] = Math.max(dp[i-1], dp[i]); 
		    
		    // 오늘 날짜의 상담을 하는 경우 체크 
		    if(i-1 + time[i] <= N) {
		        dp[i-1 + time[i]] = Math.max(dp[i-1 + time[i]], dp[i-1] + money[i]); 
		    }
		}
		System.out.println(dp[N]);
	}
}