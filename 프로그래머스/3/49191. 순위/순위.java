class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1]; 
        
        for(int i=0; i<results.length; i++) {
            int[] result = results[i];
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = true;
        }
        
        // 3중 for문으로 플로이드-워셜 적용해 간접 승리 확인 
        // 백준 11403. 경로 찾기 문제와 유사 
        // i -> k -> j (k는 거쳐가는 중간 노드)
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        
        // 이긴 사람 수 + 진 사람 수 = n-1이면 순위 예측 가능
        for(int i=1; i<=n; i++) {
            int count = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j] || graph[j][i]) count++;
            }
            if(count == n-1) answer++;
        }

        return answer;
    }
}