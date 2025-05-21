import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] A = new int[N+1][N+1];
		int INF = Integer.MAX_VALUE;
		
		// 간선 2차 배열을 INF로 초기화 
		for(int i=1; i<=N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for(int j=1; j<=N; j++) {
		        int temp = Integer.parseInt(st.nextToken());
		        if(temp == 1){
		            A[i][j] = 1; 
		        }
		        else {
		            A[i][j] = INF;
		        }
		    }
		}
		
		// 플로이드-워셜: A[S][E] = Math.min(A[S][E], A[S][K] + A[K][E])
		for(int i=1; i<=N; i++) {
		    for(int j=1; j<=N; j++) {
		        for(int k=1; k<=N; k++) {
		            if(A[j][i] == 1 && A[i][k] == 1) {
		                A[j][k] = 1;
		            }
		        }
		    }
		}
		
		// 출력 
		for(int i=1; i<=N; i++){
		    for(int j=1; j<=N; j++) {
		        if(A[i][j] == 1) {
		            System.out.print("1 ");
		        }
		        else {
		            System.out.print("0 ");
		        }
		    }
		    System.out.println();
		}

	}
}