import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        int[] num = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            num[i] = sc.nextInt();
            max = Math.max(max, num[i]);
        }

        // dp[n][k]: n을 1~k로 만드는 경우의 수
        int[][] dp = new int[max+1][4]; 

        for(int k=1; k<=3; k++) {
            dp[0][k] = 1;
        }

        for(int n=1; n<=max; n++) {
            for(int k=1; k<=3; k++) {
                /*
                dp[n][1]: 1만 써서 n 만들기
                dp[n][2]: 1,2만 써서 n 만들기
                dp[n][3]: 1,2,3 써서 n 만들기 → 최종 정답
                */
                
                /*
                예시: n=6
                dp[6][1] = dp[6][0] + dp[5][1] = 0 + 1 = 1
                dp[6][2] = dp[6][1] + dp[4][2] = 1 + 3 = 4
                dp[6][3] = dp[6][2] + dp[3][3] = 4 + 3 = 7
                */
                dp[n][k] = dp[n][k-1];
                if(n-k >= 0) {
                    dp[n][k] += dp[n-k][k];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[num[i]][3]); 
        }
    }
}
