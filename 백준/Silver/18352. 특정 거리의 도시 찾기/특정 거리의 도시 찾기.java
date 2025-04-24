import java.io.*;
import java.util.*; 

public class Main
{
    static int N, M, K, X;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int distance=0;
    
	public static void main(String[] args) throws IOException {
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
	    
	    // 인접 리스트 사용 
	    for(int i=1; i<=N; i++) {
	        A[i] = new ArrayList<>();
	    }
	    for(int i=1; i<=M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int s = Integer.parseInt(st.nextToken());
	        int e = Integer.parseInt(st.nextToken());
	        A[s].add(e);
	    }
		
		// BFS 이용 
		BFS(X);
		
		// 오름차순 출력 
		if(answer.isEmpty()) {
		    System.out.println("-1");
		} else {
		    Collections.sort(answer);
    		for(int i=0; i<answer.size(); i++) {
    		    System.out.println(answer.get(i));
    		}   
		}
	}
	
	// Queue<Node>를 이용한 BFS
	static void BFS(int X) {
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(new Node(X, 0));
	    visited[X] = true;
	    
	    while(!queue.isEmpty()) {
	        Node node = queue.poll();
	        int now = node.n;
	        int dist = node.d;
	        
	        if(dist == K) {
	            answer.add(now);
	            continue;
	        }
	        
	        for(int i : A[now]) {
	            if(!visited[i]) {
	                queue.add(new Node(i, dist+1));
	                visited[i] = true;
	            }
	        }
	    }
	}
	
	// 도시 번호, distance를 가진 Node
	static class Node {
	    int n;
	    int d;
	    
	    Node(int n, int d) {
	        this.n = n;
	        this.d = d;
	    }
	}
}