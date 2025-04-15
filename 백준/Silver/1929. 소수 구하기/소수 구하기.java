import java.util.*;


public class Main
{
    static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		A = new int[N+1];
		
		// 0, 1은 소수에서 제외 
		for(int i=2; i<=N; i++) {
		    A[i] = i;
		}
		
	
		// 2부터 제곱근의 값까지 값을 탐색 
		for(int i=2; i<=Math.sqrt(N); i++) {
		    // 이미 소수로 체크한 경우 continue
		    if (A[i] == 0) continue;
		    
		    // 소수면 해당 배열값 0으로 변경 
		    for(int j=i*2; j<=N; j=j+i) {
		        A[j] = 0;
		    }
		}
		
		for(int i=M; i<=N; i++) {
		    if (A[i] != 0) {
		        System.out.println(A[i]);
		    }
		}
		
	}
}