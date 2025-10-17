import java.util.*;

class Solution {
    static int N;
    static int start;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        Set<String> isVisited = new HashSet<>();
        N = info.length;
        start = n;
    
        dfs(0, info, n, m, isVisited);
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    static void dfs(int idx, int[][] info, int n, int m, Set<String> isVisited) {
        if (start - n >= answer) return; 
        if (n <= 0 || m <= 0) return;    

        if (idx == N) {            
            answer = Math.min(answer, start - n);
            return;
        }
        
        String key = n + "," + m + "," + idx;
        if (isVisited.contains(key)) {
            return;
        }

        // System.out.printf("idx:%d, n:%d, m:%d\n", idx, n, m);
        
        // A가 훔치는 경우
        dfs(idx + 1, info, n - info[idx][0], m, isVisited);
        // B가 훔치는 경우 
        dfs(idx + 1, info, n, m - info[idx][1], isVisited);
        
        isVisited.add(key);
    }
}