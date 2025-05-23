import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Node>[] T; // 인접 행렬 
    static boolean visited[]; // 방문 배열 
    static int total;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 배열 및 인접 행렬 초기화 
		T = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
		    T[i] = new ArrayList<>();
		}
		
		// 간선 정보 저장: 무방향 그래프 
		for(int i=0; i<E; i++) {
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    int C = Integer.parseInt(st.nextToken());
		    T[A].add(new Node(B, C));
		    T[B].add(new Node(A, C)); 
		}
		
		/* 최소 신장 트리 - 프림
		* 정점 중심, visited[]를 이용해서 방문 여부 체크
		* 간선의 개수가 많은 경우 유리 
		* 인접 정점 중 최소 비용의 간선이 존재하는 정점 선택 
		* 모든 정점이 선택될 때까지 반복 
		BFS: Queue 기반, DFS: Stack 기반 
		Prim: 최소 비용의 트리를 구성하기 위해 PQ 사용 
		*/ 
		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
		    // 가장 낮은 가중치를 가지는 정점부터 
		    Node now = pq.poll();
		    int nowNode = now.to;
		    int nowValue = now.value;
		    
		    if(visited[nowNode]) continue;
		    
		    visited[nowNode] = true;
		    total += nowValue;
		    
		    // 인접 정점 탐색 
		    for(Node next : T[nowNode]) {
		        if(!visited[next.to]) {
		            pq.add(next);
		        }
		    }
		    
		}
		System.out.println(total);
	}
	
	// 가중치를 고려하기 위한 Comparable<Node> 
	static class Node implements Comparable<Node> {
	    int to, value;
	    
	    Node(int to, int value) {
	        this.to = to;
	        this.value = value;
	    }
	    
	    @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
	}
}