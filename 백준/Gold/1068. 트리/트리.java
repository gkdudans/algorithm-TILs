import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer>[] A; // 트리 & 인접 리스트
    static int[] visited; // DFS: 방문 배열 
    static int S; // 시작 노드 
    static int count = 0; // 리프 노드 카운트 
    
	public static void main(String[] args) throws IOException {
	    // 입력 및 초기화 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N+1];
		visited = new int[N+1];
		
		for(int i=0; i<=N; i++) {
		    A[i] = new ArrayList<>();
		}
		
		// 부모 노드 정보 저장 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
		    int parent = Integer.parseInt(st.nextToken());
		    if(parent == -1) {
		        S = i;
		        continue;
		    }
		    A[parent].add(i);
		}
		
		// 삭제 노드 정보 저장 
		int D = Integer.parseInt(br.readLine());
		visited[D] = -1;
		for(int i=0; i<A[D].size(); i++) {
		    int next = A[D].get(i);
		    visited[next] = -1;
		    
		}
		
        // Tree & DFS
		DFS(S);
		
		if (visited[S] == -1) {
            System.out.println(0);
            return;
        }
		System.out.println(count);
	}
	
	/* 
    * visited[i] = 0 -> not visited
    * visited[i] = -1 -> deleted
    * visited[i] = 1 -> visited 
    */ 
	public static void DFS(int j) {
        if (visited[j] != 0) return;
    
        visited[j] = 1;
    
        int childCount = 0;
        for (int child : A[j]) {
            if (visited[child] == -1) continue; // 삭제된 노드 무시 
            childCount++; 
            DFS(child); // 재귀 형태로 구현 
        }
    
        if (childCount == 0) {
            count++; 
        }
    }
}