import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N + 1];
        int[] cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }
        
        int[] dp = new int[totalCost + 1];
        
        for(int i=1; i<=N; i++) {
            for(int c=totalCost; c>=cost[i]; c--) {
                dp[c] = Math.max(dp[c], dp[c - cost[i]] + memory[i]);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int c=0; c<=totalCost; c++) {
            if(dp[c] >= M) {
                answer = Math.min(answer, c);
            }
        }
        
        System.out.println(answer);
    }
}