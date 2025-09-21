import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        if (n >= 1) dp[1] = drink[1];
        if (n >= 2) dp[2] = drink[1] + drink[2];
        if (n >= 3) 
            dp[3] = Math.max(dp[2], Math.max(drink[1] + drink[3], drink[2] + drink[3]));

        // 1) i번째를 마시는 경우: dp[i - 1]
        // 2) i번째, i-2를 마시는 경우: dp[i - 2] + drink[i]
        // 3) i번재, i-1를 마시는 경우: dp[i - 1] + drink[i]
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + drink[i], dp[i - 3] + drink[i - 1] + drink[i]));
        }

        System.out.println(dp[n]);
    }
}