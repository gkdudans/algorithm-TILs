import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int [][] dp = new int[n+1][m+1];
	    int max = 0;
	    
	    dp[0][0] = 0;
	    
	    // dp[i][j]: (i행, j열)을 오른쪽 아래 꼭짓점으로 그릴 수 있는 가장 큰 정사각형 변의 길이 
	    for(int i=1; i<=n; i++) {
	        String now = br.readLine();
	        for(int j=1; j<=m; j++) {
	            int temp = now.charAt(j-1) - '0';
	            
	            // 배열의 (i행, j열)이 0인 경우 
	            if(temp == 0) {
	                dp[i][j] = 0;
	            } 
	            // 배열의 (i행, j열)이 1인 경우 
	            else {
	                if(dp[i-1][j-1] != 0 && dp[i-1][j] != 0 && dp[i][j-1] !=0 ) {
	                    // 정사각형의 변의 길이가 늘어나는 경우 
	                    if(dp[i-1][j-1] == dp[i-1][j] && dp[i-1][j] == dp[i][j-1]) {
	                        dp[i][j] = dp[i-1][j-1] + 1;
	                    }
	                    // 변의 길이가 늘어나지 않는 경우 
	                    else {
	                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
	                    }
	                }
	                // 해당 칸을 제외하고 정사각형을 만들 수 없는 경우 
	                else {
	                    dp[i][j] = 1;
	                }
	            }
	            if(max < dp[i][j]) max = dp[i][j]; 
	        }
	    }
	    System.out.println(max*max);
	}
}