import java.util.*;
import java.io.*;

public class Main
{
    static long N;
    static List<Integer> A = new ArrayList<>();
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		dfs(N, 0);
		
		Collections.sort(A);
		
		System.out.print(A.get(0) + " ");
		System.out.print(A.get(A.size() - 1));
		
	}
	
	public static void dfs(long N, int totalCount) {
	    String now = String.valueOf(N);
	    totalCount += countOdd(now);
	    
	    if(now.length() == 1) {
	        A.add(totalCount);
	        return;
	    }
	    else if(now.length() == 2) {
	        int next = 0;
	        next += N / 10;
	        next += N % 10;
	        dfs(next, totalCount);
	    } 
	    else {
	        // i: 첫번째 자를 위치
	        // j: 두번째 자를 위치 
	        for(int i=1; i<now.length()-1; i++) {
                for(int j=i+1; j<now.length(); j++) {
                    int a = Integer.parseInt(now.substring(0, i));
                    int b = Integer.parseInt(now.substring(i, j));
                    int c = Integer.parseInt(now.substring(j));
                    int sum = a + b + c;
                    dfs(sum, totalCount);
                }
            }
	    }
	}
	
	public static int countOdd(String N) {
	    int count = 0;
	    
	    for(int i=0; i<N.length(); i++) {
	        int now = Integer.parseInt(String.valueOf(N.charAt(i)));
	        if(now % 2 != 0) count++;
	    }
	    return count;
	}
}