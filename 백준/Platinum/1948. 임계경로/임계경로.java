import java.io.*;
import java.util.*;

public class Main
{
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] A = new ArrayList[n + 1];
		ArrayList<Edge>[] reverseA = new ArrayList[n + 1];
		
		int indegree[]  = new int[n+1];
		int result[] = new int[n+1];

		
		for(int i=1; i<=n; i++) {
		   A[i] = new ArrayList<>(); 
		   reverseA[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int t = Integer.parseInt(st.nextToken());
		    A[s].add(new Edge(e, t));
		    reverseA[e].add(new Edge(s, t)); 
		    indegree[e]++;
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		// 위상 정렬 
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입 차수가 0인 정점 삽입
		for(int i=1; i<=n; i++) {
		    if(indegree[i] == 0) {
		        queue.add(i);
		    }
		}
		
		// 위상 정렬 수행 
		while(!queue.isEmpty()) {
		    int now = queue.poll();
		    for (Edge edge : A[now]) {
                int next = edge.to;
                indegree[next]--;
                
                // ⭐ 중요: 최장 경로만 저장하도록 result 업데이트
                result[next] = Math.max(result[next], result[now] + edge.time);
                
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
		}
		// ⭐ 중요: 역추적 위상정렬, 최장 경로의 간선 수 세기
		boolean[] visited = new boolean[n + 1];
        Queue<Integer> reverseQueue = new LinkedList<>();
        reverseQueue.add(e);
        visited[e] = true;
        
        int count = 0;
        while (!reverseQueue.isEmpty()) {
            int now = reverseQueue.poll();
            
            for (Edge edge : reverseA[now]) {
                int prev = edge.to;
                
                if (result[now] == result[prev] + edge.time) {
                    count++;
                    
                    // ⭐ 중요:  출발점(s)에서 도달 가능한 경로인지 확인
                    if (!visited[prev] && result[prev] >= result[s]) {
                        visited[prev] = true;
                        reverseQueue.add(prev);
                    }
                }
            }
        }
        
        System.out.println(result[e]-result[s]);
        System.out.println(count);
	}
	
	static class Edge {
        int to;      
        int time;    

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

}