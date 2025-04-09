import java.util.*;

public class Main
{
    static int[] A;
    static int M;
    static int N;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		A = new int[N+1];
		int sum = 0; // end
		int max = 0; // start 
		
		for(int i=1; i<=N; i++) {
		    A[i] = sc.nextInt();
		    sum += A[i];
		    if(max < A[i]) max = A[i];
		}
		
		binarySearch(max, sum);
	}
	
	// 이진 탐색: 최소 mid를 구하기 위해 
	public static void binarySearch(int s, int e) {
	    int result = 0;
	    
	    while(s <= e) {
	        int mid = (s + e)/2;
	        int count = countResult(mid);
	        
	        if(count <= M) {
	            // 용량 줄임
	            result = mid;
	            e = mid - 1;
	            
	        } else {
	            // 용량 늘림
	            s = mid + 1;
	            
	        }
	    }
	    System.out.println(result);
	}
	
	// mid 용량으로 몇 개의 블루레이가 필요한지 count 
	public static int countResult(int mid) {
	    int count = 0;
	    int sum = 0;
	    
	    for(int i=1; i<=N; i++) {
	        // A[i]까지의 sum이 mid를 초과 
	        if (sum + A[i] > mid) {
	            count++;
	            sum = A[i];
	        }
	        // A[i]까지의 sum이 mid 초과하지 않음
	        else {
	            sum += A[i];
	        }
	    }
	    return count+1;
	}
}