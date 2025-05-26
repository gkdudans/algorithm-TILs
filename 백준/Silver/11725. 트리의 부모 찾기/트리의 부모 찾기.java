import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer>[] A; // 트리 & 인접 리스트 
    static boolean[] visited; // DFS: 방문 배열 
    static int[] result; // 결과 저장할 배열 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		// A.get(i): 노드 i에 연결된 노드들의 리스트 
		for(int i=1; i<=N; i++) {
		    A[i] = new ArrayList<>();
		}
	
		// 트리: 양방향 간선 추가 
		for(int i=0; i<N-1; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    A[s].add(e);
            A[e].add(s);
		}
		
		DFS(1);
		
		for(int i=2; i<=N; i++) {
		    System.out.println(result[i]); 
		}
		
	}
	
	// DFS: 재귀적으로 구현 
	static void DFS(int j) {
	    if(visited[j]) return;
	    
	    visited[j] = true;
	    
	    for(int i : A[j]) {
	        if (!visited[i]) {
	            result[i] = j;
	            DFS(i);
	        }
	    }
	}
}