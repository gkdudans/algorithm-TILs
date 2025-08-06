import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    
		    // 간선 정보 저장 
		    ArrayList<Integer>[] A = new ArrayList[N+1];
		    boolean[] visited = new boolean[N+1]; 
		    int[] kind = new int[N+1];
		    int count = 0;
		    
		    for(int j=1; j<=N; j++) {
                A[j] = new ArrayList<>();
            }
        
            int start = 0;
		    for(int j=1; j<=M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
                if(j == 1) start = a;
		    }
		    
		    // 최소 신장 트리(MST) - Prim
		    PriorityQueue<Integer> pq = new PriorityQueue<>();
		    pq.add(start);
		    Arrays.fill(kind, Integer.MAX_VALUE);
		    kind[start] = 1;
		    visited[start] = true;
		    
		    int now = 0;
		    while(!pq.isEmpty()) {
		        now = pq.poll();
		        count++;
		        if(count == N) {
		            System.out.println(N-1);
		            break;
		        }
		        visited[now] = true;
		        
		        for(int n : A[now]) {
		            if(!visited[n]) {
		                pq.add(n);
		                kind[n] = Math.min(kind[n], kind[now] + 1);
		            }
		        }
		    }
		}
	}
}