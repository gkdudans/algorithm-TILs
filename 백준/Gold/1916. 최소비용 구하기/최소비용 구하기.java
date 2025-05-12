import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int[] totalCost; // 최소비용 배열 
    static boolean[] visited; // 방문 배열 
    static ArrayList<Edge> A[]; // 인접 리스트 
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); // cost에 대한 PQ 
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    totalCost = new int[N+1];
	    visited = new boolean[N+1];
	    A = new ArrayList[N+1];
	    
	    // 배열 및 리스트 초기화 
	    for(int i=1; i<=N; i++) {
	        A[i] = new ArrayList<>();
	        totalCost[i] = Integer.MAX_VALUE;
	    }
	    
	    // 인접 리스트에 도시 데이터 저장 
	    for(int i=0; i<M; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int s = Integer.parseInt(st.nextToken());
	        int e = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        A[s].add(new Edge(e, c));
	    }
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int S = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
	    // 출발 노드 pq에 추가 
	    pq.add(new Edge(S, 0));
	    totalCost[S] = 0;
	    
	    /*
	    * 다익스트라 + 방문 배열, PQ 
	    * 연결 노드의 값 업데이트:
	    * Min(선택노드의 최단거리배열값+에지가중치, 연결노드의 최단거리 배열값) 
	    */ 
	    while(!pq.isEmpty()) {
	        Edge now = pq.poll();
	        int nowNode = now.node;
	        int nowCost = now.cost;
	        
	        // 이미 처리했으면 아래 로직 무시하고 다음으로 
	        if(visited[nowNode]) continue; 
	        visited[nowNode] = true;
	        
	        // E에 도달하면 종료 
	        if (nowNode == E) break;
	        
	        // 연결 노드의 값 업데이트
	        for(Edge next : A[nowNode]) {
	            int nextNode = next.node;
	            int nextCost = next.cost;
	            totalCost[nextNode] = Math.min(totalCost[nextNode], 
	                totalCost[nowNode] + nextCost);
	            pq.add(new Edge(nextNode, totalCost[nextNode]));
	        }
	    }
	    
	    System.out.println(totalCost[E]);
	}
	
	
	static class Edge implements Comparable<Edge> {
	    int node, cost;
	    
	    Edge(int n, int c) {
	        this.node = n;
	        this.cost = c;
	    }
	    
	    // cost가 작은 순서대로 우선순위 정렬 
	    @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
	}
}