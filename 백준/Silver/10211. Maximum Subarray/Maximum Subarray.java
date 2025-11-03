import java.util.*;
import java.io.*;

public class Main
{
    static int max = -Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
		    int N = Integer.parseInt(br.readLine());
		    int[] num = new int[N];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    
		    for(int i=0; i<N; i++) {
		        num[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    int sum = num[0];
		    int max = num[0];
		    
		    for(int i=1; i<N; i++) {
		        // Kadane’s 알고리즘: 이전 구간을 유지할지 버릴지 결정 
		        sum = Math.max(num[i], sum + num[i]);
		        max = Math.max(max, sum);
		    }
		    System.out.println(max);
		}
	}
}