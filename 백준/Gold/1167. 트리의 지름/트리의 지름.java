import java.util.*;

public class Main
{
    static boolean visited[];
    static int distance[];
    static ArrayList<Edge>[] A;
    static Queue<int[]> queue = new LinkedList<>();
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		for(int i=1; i<=N; i++) {
		    A[i] = new ArrayList<Edge>();
		}
		
		// 인접 리스트에 데이터 저장
		for(int i=0; i<N; i++) {
		    int S = sc.nextInt();
		    while(true) {
		        int E = sc.nextInt();
		        if (E == -1) break;
		        else {
		            int V = sc.nextInt();
		            A[S].add(new Edge(E, V));
		        }
		    }
		}
		
		/*
		* 트리의 지름: 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것
		* 가장 먼 노드 B는 지름의 한쪽 끝점, 이를 찾기 위한 BFS
		*/
		BFS(1);
		int max = 0;
        for (int i = 2; i <= N; i++) {
            if (distance[i] > distance[max]) {
            max = i;
            }
        }
		

		/*
		* B로부터 가장 멀리 떨어져 있는 C를 찾기 위한 BFS
		* B와 C 사이의 거리가 트리의 지름이 됨
		*/
		visited = new boolean[N+1];
		distance = new int[N+1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
		
	
	}
	
	/*
	* BFS: 큐 기반 반복문이 정석
	*/
	public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
    
        while (!queue.isEmpty()) {
            int now = queue.poll();
    
            for (Edge edge : A[now]) {
                int next = edge.e;
                int value = edge.value;
    
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + value;
                    queue.add(next);
                }
            }
        }
	    
	}

	
	static class Edge{
	    int e;
	    int value;
	    public Edge(int e, int value) {
	        this.e = e;
	        this.value = value;
	    }
	}
}