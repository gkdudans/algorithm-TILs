import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer>[] A;
    static boolean visited[];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++){
		    A[i] = new ArrayList<Integer>();
		}
		
		// 연결 리스트에 데이터 삽입 
		for(int i=0; i<M; i++){
		    st = new StringTokenizer(br.readLine()); // 줄바꿈하면서 읽어옴 
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    A[s].add(e);
		    A[e].add(s);
		}
		
		// 연결 요소의 개수 count 
		int count=0;
		for(int i=1; i<N+1; i++){
		    if (!visited[i]){
		        count++;
		        DFS(i);
		    }
		}
		
		System.out.println(count);
	}
	
	// DFS (재귀적으로 수행)
	public static void DFS(int j){
	    if (visited[j]) return;
	     
	    visited[j] = true;
	    
	    for(int i : A[j]){
	        if (!visited[i]) DFS(i);
	    }
	    
	}
}