import java.util.*;
import java.io.*;

public class Main
{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] color;
    static boolean flag = true;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<K; i++) {
		    st = new StringTokenizer(br.readLine());
		    int V = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    A = new ArrayList[V+1];
		    visited = new boolean[V+1];
		    // color: 0 OR 1
		    color = new int[V+1];
		    flag = true;
		    
		    // 인접 리스트에 양방향 저장 
		    for(int j=1; j<=V; j++) {
		        A[j] = new ArrayList<>();
		    }
		    
		    for(int j=0; j<E; j++) {
		        st = new StringTokenizer(br.readLine());
		        int u = Integer.parseInt(st.nextToken());
		        int v = Integer.parseInt(st.nextToken());
		        A[u].add(v);
		        A[v].add(u);
		    }

		    for(int j=1; j<=V; j++) {
		        // 시작 노드 color를 1로 설정 
		        if(flag) {
		            color[j] = 1;
		            DFS(j);
		        }
		        // 이미 flag = false라면 탐색 종료
		        else break;
		    }
		    
		    System.out.println(flag ? "YES" : "NO");
		    
		}
	}
	
	static void DFS(int n) {
	    if(visited[n]) return;
	    
	    visited[n] = true;

	    for(int k : A[n]) {
	        if(!visited[k]) {
	            // 방문하지 않은 노드 다른 color로 칠함 
	            color[k] = (color[n]+1)%2;
	            DFS(k);
	        }
	        // 인접 노드에 이미 색이 칠해졌는데 현재 color와 같은 경우 
	        // 같은 집합에 속하면 인접하지 않아야 함 -> false 
	        else if(color[k] == color[n]) {
	            flag = false;
	        }
	    }
	}
}