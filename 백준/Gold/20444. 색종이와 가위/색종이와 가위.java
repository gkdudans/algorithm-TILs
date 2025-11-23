import java.util.*;
import java.io.*;

public class Main
{
    static long n;
    static long k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		// 색종이 조각의 개수는 (row + 1) * (col + 1)
		binarySearch(0, n);
	}
	
	static void binarySearch(long s, long e) {
	    while(s <= e) {
	        long mid = (s + e) / 2; 
	        long result = (mid + 1) * (n - mid + 1);
	        
	        if(result == k) {
	            System.out.println("YES");
	            System.exit(0);
	        } else if(result < k) {
	            e = mid - 1;
	        } else {
	            s = mid + 1; 
	        }
	    }
	    System.out.println("NO");
	}
}