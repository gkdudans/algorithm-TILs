class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n+1];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int i, int[][] computers, int n) {
        visited[i] = true;
        
        for(int next=0; next<n; next++) {
            if(i != next && computers[i][next] == 1 && !visited[next]) {
                dfs(next, computers, n);
            }
        }
    }
    
    
}