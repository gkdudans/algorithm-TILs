import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 1_000_000 * 16 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N]; 
        // dp[현재도시][방문상태]
        // 1 << N: 2^n, 방문 상태를 비트로 표현하기 위한 최대 크기


        // 입력 저장 
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // dp 배열 초기화 (메모이제이션 체크용용)
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        // 0번 도시에서 시작
        // 첫 도시 방문 표시, visited = 1<<0 = 1(0001)
        System.out.println(tsp(0, 1)); 
    }

    // 모든 경우의 수에 대한 완전 탐색, 재귀 구현
    // dp[c][v]: not visited 도시를 다 돌고 다시 출발지로 가는 최소 비용 
    static int tsp(int c, int v) { 
        // c: 현재 도시 
        // v: 현재까지 방문한 도시 리스트를 bit로 표시 
        
        // 모든 노드를 방문한 경우 
        // 1 << N - 1: 모든 비트가 1인 상태 
        if(v == (1 << N)-1) {    
            return cost[c][0] == 0 ? INF : cost[c][0];
        }
        
        // 이미 방문한 노드인 경우 리턴 (메모이제이션)
        if (dp[c][v] != -1) {  
            return dp[c][v];
        }
        
        dp[c][v] = INF;
        for(int i=0; i<N; i++) {
            // 방문한 적이 없고, 갈 수 있는 도시인 경우 
            // v | (1 << i): i번 도시를 방문 표시한 새로운 visited
            // tsp(i, newVisited) + cost[c][i]: 다음 도시 i로 이동했을 때의 비용과 현재 이동 비용의 합산 
            if((v&(1<<i))==0 && cost[c][i]!=0) {   
                dp[c][v] = Math.min(dp[c][v], tsp(i, (v | (1 << i))) + cost[c][i]);
            }
        }
        return dp[c][v];
    }
}
