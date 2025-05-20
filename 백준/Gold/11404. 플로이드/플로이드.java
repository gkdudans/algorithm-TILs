import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(br.readLine());
		int[][] D = new int[n+1][n+1];
		int INF = Integer.MAX_VALUE;
		
		// 최단거리 2차 배열을 INF로 초기화 
		for(int i=1; i<n+1; i++) {
		    for(int j=1; j<n+1; j++) {
		        if(i == j) {
		            D[i][j] = 0;
		        } else {
		            D[i][j] = INF;
		        }
		    }
		}
		
		// 간선 정보 저장 
	    for(int i=0; i<m; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken()); 
	        int b = Integer.parseInt(st.nextToken()); 
	        int c = Integer.parseInt(st.nextToken()); 
	        // 시작 - 도착 연결하는 간선은 하나가 아닐 수 있음 
	        D[a][b] = Math.min(D[a][b], c);
	    }
	    
	    
	    /*
         * 플로이드-워셜 
         * 음수 사이클이 없는 그래프 
         * 그래프에 시작점이 없고 모든 정점과 관련된 거리를 구함 
         * 음의 가중치를 가지는 간선 가능 
         * 플로이드-워셜 알고리즘을 돌면서 그래프의 값을 업데이트 
         
         * 최단 거리 배열 D[S][E]에서 
         * 3중 for문을 도는 점화식: Math.min(D[S][E], D[S][K] + D[K][E])
         */
	    for(int i=1; i<=n; i++) {
	        for(int j=1; j<=n; j++) {
	            for(int k=1; k<=n; k++) {
	                if (D[j][i] != INF && D[i][k] != INF) {
                        D[j][k] = Math.min(D[j][k], D[j][i] + D[i][k]);
                    }
	            }
	        }
	    }
	    
	    // 배열의 값이 INF라면 도착할 수 없는 것으로 판단 
	    for(int i=1; i<=n; i++) {
	        for(int j=1; j<=n; j++) {
	            if(D[i][j] == INF) {
	                System.out.print(0 + " ");
	            }
	            else {
	                System.out.print(D[i][j] + " ");
	            }
	        }
	        System.out.println();
	    }
	}
}