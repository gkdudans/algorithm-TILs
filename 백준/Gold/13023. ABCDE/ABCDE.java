import java.io.*;
import java.util.*;

public class Main
{
    
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int depth;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N];

		for(int i=0; i<N; i++) {
		    A[i] = new ArrayList<Integer>();
		}
		
		// 연결 리스트에 양방향 데이터 삽입
		for(int i=0; i<M; i++){
		    st = new StringTokenizer(br.readLine()); 
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    A[s].add(e);
		    A[e].add(s);
		}
		
            
		for(int i=0; i<N; i++){
		    visited = new boolean[N];
		    DFS(i, 0);
		}
		
		System.out.println("0");
		
	}
	
	// DFS (재귀적으로 수행)
	public static void DFS(int j, int depth){
        if (visited[j]) return;
    
        visited[j] = true;
        
        // 문제 조건에 맞는 친구 관계 존재하는 경우
        if (depth == 4) {
            System.out.println("1");
            System.exit(0);
        }
    
        for (int i : A[j]) {
            if (!visited[i]) {
                DFS(i, depth + 1);  // 자식은 depth + 1
            }
        }
        // 백트래킹 
        visited[j] = false; 
}

}