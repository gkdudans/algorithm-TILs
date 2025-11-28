import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[M][N];
		for(int i=0; i<N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<M; j++) {
		        num[j][i] = Integer.parseInt(st.nextToken());
		    }
		}
		    
        // 2차원 Kadane 알고리즘: 2차원(2D)의 모든 직사각형을 고려
		int max = -Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
		    int[] temp = new int[N];
		    for(int j=i; j<M; j++) {
		        
		        for(int k=0; k<N; k++) {
		            temp[k] += num[j][k];
		        }
		        
		        int sum = 0;
		        for(int now : temp) {
		            // Kadane 
		            sum = Math.max(sum + now, now);  
		            max = Math.max(max, sum);
		        }
		    }
		}
		
		System.out.println(max);
		
	}
}
