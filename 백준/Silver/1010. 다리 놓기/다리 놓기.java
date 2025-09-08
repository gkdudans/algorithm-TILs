import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(combination(M, N));
        }

    }
    
    static int combination(int M, int N) {
        // mCn 구하기
        if (dp[M][N] > 0)
            return dp[M][N];
        if (M == N || N == 0)
            return dp[M][N] = 1;
        return dp[M][N] = combination(M - 1, N - 1) + combination(M - 1, N);
    }
    
}
