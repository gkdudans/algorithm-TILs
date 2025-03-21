import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];
		for(int i=0; i<N; i++){
		    A[i] = sc.nextInt();
		}

		for(int i=1; i<N; i++){
		    int insertIdx = i;
		    for(int j=i-1; j>=0; j--){
		        if(A[i]<A[j]){
		            insertIdx = j;
		        }
		    }
		    int tmp = A[i];
		    for(int j=i; j>insertIdx; j--){
		        A[j] = A[j-1];
		    }
		    A[insertIdx] = tmp;
		}
		
		S[0] = A[0];
		int sum = S[0];
		for(int i=1; i<=N-1; i++){
		    S[i] = S[i-1] + A[i];
		    sum += S[i];
		}

		System.out.println(sum);
		
	}
}