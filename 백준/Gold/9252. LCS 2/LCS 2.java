import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		
		int[][] dp = new int[first.length()+1][second.length()+1];
		
		// DP: LCS의 길이를 구하는 DP 구현 
		for(int i=1; i<=first.length(); i++) {
		    for(int j=1; j<=second.length(); j++) {
		        int f = first.charAt(i-1) - 'A';
		        int s = second.charAt(j-1) - 'A';
		        
		        if(f == s) { 
		            dp[i][j] = dp[i-1][j-1] + 1;
		            
		        } else {
		            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		        }
		    }
		}
		
		
		// Traceback: 역추적을 통해 문자열 탐색 
		StringBuilder lcs = new StringBuilder();
        int i = first.length();
        int j = second.length();
        
        while(i > 0 && j > 0) {
            if(first.charAt(i-1) == second.charAt(j-1)) {
                lcs.append(first.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        
        lcs.reverse();
        
        // 길이 출력
        System.out.println(dp[first.length()][second.length()]);
        // 길이가 0인 경우는 출력하지 않음 
        if(lcs.length() > 0)
            System.out.println(lcs.toString());
	}
}