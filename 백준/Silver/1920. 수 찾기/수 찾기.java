import java.util.*;

public class Main
{
    static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N
		int N = sc.nextInt();
		A = new int[N];
		for(int i=0; i<N; i++) {
		    A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		
		// M
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
		    int m = sc.nextInt();
		    binarySearch(0, N-1, m);
		}
	}
	
	public static void binarySearch(int s, int e, int m) {
	    if(s > e) {
	        System.out.println(0);
	        return;
	    }
	    
	    int mid = (s+e)/2;
	    int value = A[mid];

	    if(value == m) {
	        System.out.println(1);
	    }
	    else if(value > m) {
	        binarySearch(s, mid-1, m);
	    }
	    else {
	        binarySearch(mid+1, e, m);
	    }
	    
	}
}