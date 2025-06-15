import java.util.*;

class Solution {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int min = 0;
    
    public int solution(int n, int[][] costs) {
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<n; i++) {
            A[i] = new ArrayList<>();
        }
        
        // 간선 정보 저장
        for(int[] now : costs) {
            int s = now[0];
            int e = now[1];
            int v = now[2];
            A[s].add(new Edge(e, v));
            A[e].add(new Edge(s, v));
        }
        
        /* 최소 신장 트리 - 프림
            * 정점 중심, visited[]를 이용해서 방문 여부 체크
            * 인접 정점 중 최소 비용의 간선이 존재하는 정점 선택 
            * 모든 정점이 선택될 때까지 반복 
            * Prim: 최소 비용의 트리를 구성하기 위해 PQ 사용 
		*/ 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(visited[now.n]) continue;
            visited[now.n] = true;
            min += now.value;
            
            for(Edge next : A[now.n]) {
                if(!visited[next.n]) {
                    pq.add(next);
                }
            }
        }
        
        return min;
    }
    
    static class Edge implements Comparable<Edge> {
        int n;
        int value;
        
        public Edge(int n, int value) {
            this.n = n;
            this.value = value;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}