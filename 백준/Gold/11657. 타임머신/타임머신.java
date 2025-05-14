import java.util.*;
import java.io.*;

public class Main
{
    static long[] totalTime; // 시간 총합 저장 배열 
    static ArrayList<Edge> E[]; // 경로 정보 저장 Edge 리스트 
    static final long INF = Long.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		
		// 배열 및 인접 리스트 초기화 
		totalTime = new long[N+1];
		E = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
		    totalTime[i] = INF;
		    E[i] = new ArrayList<Edge>();
		}
		
		// 간선 정보 저장 
		for(int i=0; i<M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    int C = Integer.parseInt(st.nextToken());
		    E[A].add(new Edge(B, C));
		}
		
		// 시작 정점 
		totalTime[1] = 0;
		
		/*
		* 벨만-포드: 음수 간선이 존재할 수 있는 그래프에서 단일 출발점 최대 경로
		* 바깥 루프(i): 최단 거리 정보를 N-1 반복해서 갱신 
		* 안쪽 루프(u): 모든 노드의 간선을 꺼내서 갱신할지 판단 
		* 한 마디로, 갱신할 때마다 모든 노드를 검사해서 갱신함 
		*/ 
        for (int i = 1; i <= N; i++) {
            for (int u = 1; u <= N; u++) {
                for (Edge edge : E[u]) {
                    int n = edge.n;
    		        int t = edge.t;
    		        
    		        // 1번에서 u(출발도시)로 도달하지 못한 경우 
    		        if(totalTime[u] == INF) continue;
    		        
    		        if(totalTime[n] > totalTime[u] + t) {
    		            totalTime[n] = totalTime[u] + t;
        		      
        		        // N번째 반복에서 또 갱신된다면 음수 사이클 존재 		        
        		        if(i == N) {
        		            System.out.println("-1");
        		            System.exit(0);
        		        }
    		            
    		        }
                }
            }
        }
                    
		// 출력 
		for(int i=2; i<=N; i++) {
		    if(totalTime[i] == INF) {
		        System.out.println("-1");
		    } else {
		        System.out.println(totalTime[i]);
		    }
		}
		
	}
	
	static class Edge {
	    int n, t;
	    
	    Edge(int n, int t) {
	        this.n = n;
	        this.t = t;
	    }
	}
}