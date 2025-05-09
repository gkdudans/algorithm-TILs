import java.io.*;
import java.util.*;

public class Main
{
    public static int V, E, K;
    public static int[] distance; // 최단거리 배열 
    public static boolean[] visited; // 방문 배열 
    public static ArrayList<Edge> A[]; // 인접 리스트 
    // pq -> "다음에 처리할 정점"을 꺼내기 위해 사용
    // value(거리)가 가장 작은 Edge 먼저 꺼내짐 
    public static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 배열 및 리스트 초기화 
		distance = new int[V+1]; 
		visited = new boolean[V+1]; 
		A = new ArrayList[V+1]; 
		for(int i=1; i<=V; i++) {
		    A[i] = new ArrayList<Edge>();
		    distance[i] =  Integer.MAX_VALUE;
		}
		
		// 인접 리스트에 데이터 저장 
		for(int i=0; i<E; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    A[u].add(new Edge(v, w)); 
		}
		
		// K를 시작점으로 설정 
        pq.add(new Edge(K, 0)); 
		distance[K] = 0;
		
		while(!pq.isEmpty()) {
		    //가장 짧은 예상 거리의 정점 꺼내기
		    Edge now = pq.poll(); 
            int u = now.vertex;

            // 이미 확정된 정점이면 스킵 
            if (visited[u]) continue;           
            visited[u] = true;
		    
		    for(Edge next : A[u]) {
		        // Edge(value=distance[v]): 해당 정점까지의 누적 최단거리,
		        // 이를 기준으로 pq가 작동 
		        int v = next.vertex;
                int w = next.value;
                distance[v] = Math.min(distance[u] + w, distance[v]);

		        pq.add(new Edge(v, distance[v]));
		    }
		}
		
		for(int i=1; i<=V; i++) {
		    if(visited[i]){
		        System.out.println(distance[i]); 
		    } else {
		        System.out.println("INF"); 
		    }
		}
	}
	
	static class Edge implements Comparable<Edge> {
	    int vertex, value;
	    Edge(int vertex, int value) {
	        this.vertex = vertex;
	        this.value = value; 
	    }
	    
	    // value(거리)가 작은 순서대로 우선순위 정
	    public int compareTo(Edge e) {
	        if(this.value > e.value) return 1;
	        else return -1;
	    }
	    
	    /* 아래처럼 구현해도 동일 
	    @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
        */ 
	}
}