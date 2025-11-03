import java.util.*;
import java.io.*;

public class Main
{
    static int N, S;
    static int[] num;
    static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
		    num[i] = Integer.parseInt(st.nextToken());
		}
		
		combine(0, 0);
		if(S == 0) answer--;
		
		System.out.println(answer);
	}
	
	static void combine(int idx, int sum) {
	    if(idx == N) {
	        if(sum == S) answer++;
	        return;
	    }
	    
	    // 현재 값을 포함하는 경우 
	    combine(idx + 1, sum + num[idx]);
	    // 현재 값을 포함하지 않는 경우 
	    combine(idx + 1, sum);
	    
	}
}