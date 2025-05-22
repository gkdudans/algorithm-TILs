import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		int sum[] = new int[N+1]; // 케빈 베이컨의 수 배열 
		int[][] F = new int[N+1][N+1]; // 친구 관계 배열 

        // 친구 관계 배열 초기화 
		for(int i=1; i<N+1; i++) {
		    for(int j=1; j<N+1; j++) {
		        if(i == j) {
		            F[i][j] = 0;
		        } else {
		            F[i][j] = INF;
		        }
		    }
		}
		
		// 친구 관계 데이터 저장 
		for(int i=0; i<M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    F[A][B] = 1;
		    F[B][A] = 1;
		}
		
		// 플로이드-워셜: 최소 단계 구하기 
		for(int i=1; i<=N; i++) {
	        for(int j=1; j<=N; j++) {
	            for(int k=1; k<=N; k++) {
	                if(F[j][i] != INF && F[i][k] != INF) {
	                    F[j][k] = Math.min(F[j][k], F[j][i] + F[i][k]);
	                }
	            }
	        }
		}
		
		// 출력 
		int min = INF, answer = INF;
		for(int i=1; i<=N; i++) {
		    for(int j=1; j<=N; j++) {
		        sum[i] += F[i][j];
		    }
		    if(min > sum[i]) {
		        min = sum[i];
		        answer = i;
		        
		    } else if(min == sum[i] && answer > i) {
		        answer = i;
		    }
		}
		System.out.println(answer);
	}
}