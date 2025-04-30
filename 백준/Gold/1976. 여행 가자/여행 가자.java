import java.util.*;

public class Main
{
    static int[] parent;
    static int[][] city;
    static int[] route; 
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1]; 
		city = new int[N+1][N+1];
		route = new int[M+1];
		
		// 대표 노드 초기화  
		for(int i=1; i<=N; i++) {
		    parent[i] = i;
		}
		// 연결 정보를 인접 행렬 형태로 저장 
		for(int i=1; i<=N; i++) {
		    for(int j=1; j<=N; j++) {
		        city[i][j] = sc.nextInt();
		    }
		}
		// 여행 계획 데이터 저장 
		for(int i=1; i<=M; i++) {
		    route[i] = sc.nextInt();
		}
		
		// 인접 행렬 탐색 
		for(int i=1; i<=N; i++) {
		    for(int j=1; j<=N; j++) {
		        // 연결되어 있을 때 parent의 UNION 연산 
		        if(city[i][j] == 1) union(i, j); 
		    }
		}
		
		// 출력: route의 모든 도시 대표 노드가 같다면 YES
		int flag = find(route[1]); 
		
		for(int i=1; i<=M; i++) {
		    if(flag != find(route[i])) {
		        System.out.println("NO");
		        return;
		    }
		}
		System.out.println("YES");
		
	}
	
	// union 연산 
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    // find 연산
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            // 재귀 함수 형태로 구현 
            return parent[a] = find(parent[a]);
        }
    }
	
		
		
}