import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N+1];
		
		for(int i=1; i<=N; i++) {
		    A[i] = sc.nextInt();
		}
		
		int count = 0;
		
		for(int i=N; i>=1; i--) {
		    if(K == 0) break;
		    
		    if(A[i] <= K) {
		        count += K / A[i]; 
		        K %= A[i]; 
		    }
		
	    }
	    System.out.println(count);
	}
}