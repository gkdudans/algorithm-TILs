import java.util.*;
import java.io.*;

public class Main
{
    static PriorityQueue<Integer> dist[]; // 시간 합에 대한 내림차순 우선순위 pq  
    static ArrayList<Edge> A[]; // 경로 정보 저장 인접 리스트 
    static PriorityQueue<Edge> pq; // 다익스트라 구현을 위한 우선순위 pq 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 배열 및 인접 리스트 초기화 
		A = new ArrayList[n+1];
		dist = new PriorityQueue[n+1];
		
		for(int i=1; i<=n; i++) {
		    A[i] = new ArrayList<Edge>();
		    dist[i] = new PriorityQueue<>(Comparator.reverseOrder()); 
		    // 내림차순: 정점마다 1~k번째까지만 저장  
		}
		
		for(int i=0; i<m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    A[a].add(new Edge(b, c));
		}
		
		// 다익스트라 
		pq = new PriorityQueue<Edge>();
        // 시작 정점을 출발 노드로 선택 
		pq.add(new Edge(1, 0));
        dist[1].add(0);
		
		while(!pq.isEmpty()) {
		    Edge now = pq.poll();
		    int nowNode = now.n;
		    int nowTime = now.t;
		    
		    for (Edge next : A[nowNode]) {
                int nextNode = next.n;
                int nextTime = next.t + nowTime;
            
                // 내림차순 우선순위 큐 dist: 정점마다 1~k번째까지만 저장 
                if (dist[nextNode].size() < k) {
                    dist[nextNode].add(nextTime);
                    pq.add(new Edge(nextNode, nextTime));
                } else if (dist[nextNode].peek() > nextTime) {
                    dist[nextNode].poll(); // 가장 큰 값 제거 -> K번째 수가 아님 
                    dist[nextNode].add(nextTime);
                    pq.add(new Edge(nextNode, nextTime));
                }
            }
		}
		
		// 출력 
		for (int i = 1; i <= n; i++) {
            if (dist[i].size() == k) {
                System.out.println(dist[i].peek()); // k번째 최단거리
            } else {
                System.out.println(-1); // k개가 안되면 -1
            }
        }
	}
	
	static class Edge implements Comparable<Edge> {
	    int n, t;
	    
	    Edge(int n, int t) {
	        this.n = n;
	        this.t = t;
	    }
	    
	    @Override
	    public int compareTo(Edge o) {
	        return Integer.compare(this.t, o.t);
	    }
	}
}